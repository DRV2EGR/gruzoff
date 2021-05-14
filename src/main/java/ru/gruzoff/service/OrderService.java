package ru.gruzoff.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.OrderDto;
import ru.gruzoff.entity.*;
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

    public OrderDto createNewOrder(CreateOrderDtoPayload createOrderDtoPayload) {
        User user = userService.findById(createOrderDtoPayload.getCustomerId()).orElseThrow(
                () -> new UserNotFoundExeption("Main customer not found!")
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
        Adress adressTo = createOrderDtoPayload.getOrderDetails().getAdressTo();

        adressRepository.save(adressFrom);
        adressRepository.save(adressTo);

        OrderDetails orderDetails = new OrderDetails(
                adressFrom,
                adressTo,
                createOrderDtoPayload.getOrderDetails().getDateTime(),
                -1,
                createOrderDtoPayload.getOrderDetails().getComment()
        );


        orderDetailsReposirory.save(orderDetails);

        Order order = new Order(
                customerRepository.findByUser(user).orElseThrow(
                            () -> new UserNotFoundExeption("NoSuch Customer Found!")
                    ),
                null,
                null,
                -1,
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
