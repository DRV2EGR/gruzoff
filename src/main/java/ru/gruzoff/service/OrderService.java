package ru.gruzoff.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.*;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.CreateOrderDtoPayload;
import ru.gruzoff.payload.UserDtoPayload;
import ru.gruzoff.repository.*;

@Service
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
    Geocoder geocoder;

    @Autowired
    CarTypeRepository carTypeRepository;

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
        float price = (time/60/60) * carType.getPricePerHour() + (time/60/60) * 1000 * createOrderDtoPayload.getNumOfLoaders();

        OrderDetails orderDetails = new OrderDetails(
                adressFrom,
                adressTo,
                createOrderDtoPayload.getOrderDetails().getDateTime(),
                time,
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
                extraCustomers
        );

        orderReposiory.save(order);

        user.getOrders().add(order);
        userRepository.save(user);

        return classToDtoService.convertOrderToOrderDto(order);
    }
}
