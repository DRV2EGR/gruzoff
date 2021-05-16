package ru.gruzoff.service;

import java.time.LocalDateTime;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.CarDto;
import ru.gruzoff.dto.CarWithCarValidDto;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.*;
import ru.gruzoff.exception.ConflictException;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.CreateOrderDtoPayload;
import ru.gruzoff.payload.UserDtoPayload;
import ru.gruzoff.repository.*;

@Service
@Slf4j
public class OrderService {
    @Autowired
    UserService userService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderReposiory orderReposiory;

    @Autowired
    private LoadersRepository loadersRepository;

    @Autowired
    private DriversRepository driversRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderDetailsReposirory orderDetailsReposirory;

    @Autowired
    ClassToDtoService classToDtoService;

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    GeocoderService geocoder;

    @Autowired
    CarTypeRepository carTypeRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarValidityRepository carValidityRepository;

    @Autowired
    MailService mailService;

    Logger logger = LoggerFactory.getLogger("orderLogger");

    public OrderDto getOrderById(long orderId) {
        return classToDtoService.convertOrderToOrderDto(
                orderReposiory.findById(orderId).orElseThrow(
                        () -> new NotFoundException("Order not found")
                )
        );
    }

    public OrderDto createNewOrder(CreateOrderDtoPayload createOrderDtoPayload) throws Exception {
        User user = userService.findById(createOrderDtoPayload.getCustomerId()).orElseThrow(
                () -> new UserNotFoundExeption("Main customer not found!")
        );

        CarType carType = carTypeRepository.findById(createOrderDtoPayload.getCar_type()).orElseThrow(
                () -> new NotFoundException("No such car type")
        );

        List<Customers> extraCustomers = new ArrayList<>();
        for(UserDtoPayload udp : createOrderDtoPayload.getExtraCustomers()) {
            User nusr = new User(
                    udp.getFirstName(),
                    udp.getSecondName(),
                    udp.getLastName(),
                    udp.getEmail(),
                    udp.getPhoneNumber()
            );

            nusr.setRole(roleRepository.findById(7L).get());
            UUID randUUID = UUID.randomUUID();
            nusr.setPassword(String.valueOf(randUUID));

//            extraCustomers.add(nusr);
            userRepository.save(nusr);

            Customers customer = new Customers();
            customer.setUser(nusr);

            customerRepository.save(customer);
            extraCustomers.add(customer);
        }



        Adress adressFrom = createOrderDtoPayload.getOrderDetails().getAdressFrom();
        List<Float> coords0 = geocoder.GeocodeSync(adressFrom.toString());
        adressFrom.setLatitude(coords0.get(0));
        adressFrom.setLongitude(coords0.get(1));

        Adress adressTo = createOrderDtoPayload.getOrderDetails().getAdressTo();
        List<Float> coords1 = geocoder.GeocodeSync(adressTo.toString());
        adressTo.setLatitude(coords1.get(0));
        adressTo.setLongitude(coords1.get(1));

        adressRepository.save(adressFrom);
        adressRepository.save(adressTo);

        float time = geocoder.GeocodeRoute(coords0.get(0), coords0.get(1), coords1.get(0), coords1.get(1));
        //System.out.println(time);
        float price = (time/60/60) * carType.getPricePerHour() +
                (createOrderDtoPayload.getOrderDetails().getTimeOnOrder()/60/60) * 1000 * createOrderDtoPayload.getNumOfLoaders();

        OrderDetails orderDetails = new OrderDetails(
                adressFrom,
                adressTo,
                createOrderDtoPayload.getOrderDetails().getDateTime(),
                time,
                createOrderDtoPayload.getNumOfLoaders(),
                carType,
                createOrderDtoPayload.getOrderDetails().getComment()
        );


        orderDetailsReposirory.save(orderDetails);

        Order order = new Order(
                customerRepository.findByUser(user).orElseThrow(
                            () -> new UserNotFoundExeption("NoSuch Customer Found!")
                    ),
                null,
                null,
                price,
                "CREATED",
                orderDetails, /*ord det*/
                new ArrayList<>(),
                extraCustomers,
                false
        );

        orderReposiory.save(order);

        logger.info("Order " + order.getId() + " created at " + LocalDateTime.now() + " by user " + user.getId());
        mailService.send(user.getEmail(), "Создание нового заказа.", mailService.creationOrderNotify(user, order));

        user.getOrders().add(order);
        userRepository.save(user);

        return classToDtoService.convertOrderToOrderDto(order);
    }

    public List<OrderDto> findOrdersBetweenDates(User user, Date d1, Date d2) {
        List<OrderDto> ordersRes = new ArrayList<>();
        for (Order order : user.getOrders()) {
            if (order.getOrderDetails().getDateTime().after(d1)
                    && order.getOrderDetails().getDateTime().before(d2)) {
                ordersRes.add(classToDtoService.convertOrderToOrderDto(order));
            }
        }

        return ordersRes;
    }

    public List<OrderDto> findOrdersOnDate(User user, Date d1) {
        List<OrderDto> ordersRes = new ArrayList<>();

        if (driversRepository.findByUser(user).isPresent()) {
            for (Optional<Order> opOrder : orderReposiory.findAllByDriverId(driversRepository.findByUser(user).get())) {
                if (opOrder.get().getOrderDetails().getDateTime().compareTo(d1) == 0) {
                    ordersRes.add(classToDtoService.convertOrderToOrderDto(opOrder.get()));
                }
            }
        }

        if (loadersRepository.findByUser(user).isPresent()) {
            Loaders loader = loadersRepository.findByUser(user).get();
            for (Optional<Order> opOrder : orderReposiory.findAllByLoadersContaining(loader)) {
                if (opOrder.get().getOrderDetails().getDateTime().compareTo(d1) == 0) {
                    ordersRes.add(classToDtoService.convertOrderToOrderDto(opOrder.get()));
                }
            }
        }

        return ordersRes;
    }

    public List<OrderDto> findAllWorkerOrders(User user) {
        List<OrderDto> ordersRes = new ArrayList<>();

        if (driversRepository.findByUser(user).isPresent()) {
            for (Optional<Order> opOrder : orderReposiory.findAllByDriverId(driversRepository.findByUser(user).get())) {
                ordersRes.add(classToDtoService.convertOrderToOrderDto(opOrder.get()));
            }
        }

        if (loadersRepository.findByUser(user).isPresent()) {
            Loaders loader = loadersRepository.findByUser(user).get();
            for (Optional<Order> opOrder : orderReposiory.findAllByLoadersContaining(loader)) {
                ordersRes.add(classToDtoService.convertOrderToOrderDto(opOrder.get()));
            }
        }

        return ordersRes;
    }

    public boolean takeOrderToDriver(User user, long carId, long orderId) {
        Drivers driver = driversRepository.findByUser(user).orElseThrow(
                () -> new UserNotFoundExeption("No such driver")
        );

        Order order = orderReposiory.findById(orderId).orElseThrow(
                () -> new NotFoundException("No such order")
        );

        if (order.getDriverId() != null) {
            return false;
        }

        Car car = carRepository.findByIdAndType(carId, order.getOrderDetails().getCarType()).orElseThrow(
                () -> new NotFoundException("No such car")
        );

        if (!driver.getCars().contains(car)) { throw new ConflictException("Not car of this driver"); }

        boolean f = false;
        for (Optional<Order> ord : orderReposiory.findAllByCarId(car)) {
            if (ord.get().getOrderDetails().getDateTime().compareTo(order.getOrderDetails().getDateTime()) == 0) {
                f = true;
                throw new ConflictException("At this day car is not valid");
            }
        }
        if (f) { return false; }

        order.setDriverId(driver);
        order.setCarId(car);


        if (order.getOrderDetails().getLoadersCapacity() <= order.getLoaders().size() && order.getDriverId() != null) {
            order.setStatus("WAIT_APPROVE");
        }

        orderReposiory.save(order);
        return true;
    }

    public boolean takeOrderToLoader(User user, long orderId) {
        Loaders loader = loadersRepository.findByUser(user).orElseThrow(
                () -> new UserNotFoundExeption("No such loader")
        );

        Order order = orderReposiory.findById(orderId).orElseThrow(
                () -> new NotFoundException("No such order")
        );

        if (order.getLoaders().contains(loader)) {
            return false;
        }

        boolean flag = false;
        if (order.getOrderDetails().getLoadersCapacity() > order.getLoaders().size()) {
            order.getLoaders().add(loader);
            flag = true;
        }

        if (order.getOrderDetails().getLoadersCapacity() <= order.getLoaders().size() && order.getDriverId() != null) {
            order.setStatus("WAIT_APPROVE");
        }

        orderReposiory.save(order);
        return flag;
    }

    public List<OrderDto> showReleventOrdersOnDay(Date date, int driverOrLoader) {
        List<OrderDto> orderDtoList = new ArrayList<>();

        if (driverOrLoader == 1) {
            for (Optional<Order> order : orderReposiory.findAllByDriverIdIsNullAndOrderDetailsDateTime(date)) {
                orderDtoList.add(
                        classToDtoService.convertOrderToOrderDto(order.get())
                );
            }
        } else if (driverOrLoader == 2) {
            //System.out.println(orderReposiory.countByLoaders());
            for (Optional<Long> idOrder : orderReposiory.countByLoaders(date)) {
                orderDtoList.add(
                        classToDtoService.convertOrderToOrderDto(
                                orderReposiory.findById(idOrder.get()).get()
                        )
                );
            }
        }

        return orderDtoList;
    }

    public boolean rejectWorkerAcceptedOrder(User user, long orderId, int driverOrLoader) {

        Order order = orderReposiory.findById(orderId).orElseThrow(
                () -> new NotFoundException("Order not found")
        );

        if (order.getStatus().equals("IN_WORK")) {
            return false;
        }

        if (driverOrLoader == 1) {
            if (order.getDriverId() == driversRepository.findByUser(user).orElseThrow(
                    () -> new UserNotFoundExeption("No such driver")
            )) {
                order.setDriverId(null);
                order.setStatus("CREATED");
                orderReposiory.save(order);

                return true;
            }
        } else if (driverOrLoader == 2) {
            if (order.getLoaders().contains( loadersRepository.findByUser(user).orElseThrow(
                    () -> new UserNotFoundExeption("No such driver")
                ))
            ) {
                order.getLoaders().remove(loadersRepository.findByUser(user).get());
                order.setStatus("CREATED");
                orderReposiory.save(order);

                return true;
            }
        }

        return false;
    }

    public List<CarWithCarValidDto> getAllDriverCars(User user) {
        List<Car> carList = driversRepository.findByUser(user).orElseThrow(
                () -> new NotFoundException("No such driver")
        ).getCars();

        List<CarWithCarValidDto> carDtoList = new ArrayList<>();
        for (Car car : carList) {
            carDtoList.add(
                    classToDtoService.convertCarToCarWithCarValidDto(
                            car,
                            carValidityRepository.findByCarId(car).get()
                    )
            );
        }

        return carDtoList;
    }
}
