package ru.gruzoff.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.*;
import ru.gruzoff.entity.*;

@Service
public class ClassToDtoService
{
    @Autowired
    UserService userService;

    public OrderDto convertOrderToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setOrderDetails(
                convertOrderDetailsToOrderDetailsDto(order.getOrderDetails())
        );
        orderDto.setCar(convertCarToCarDto(order.getCarId()));
        orderDto.setCustomer(userService.convertUserToUserDto(order.getCustomerId().getUser()));
        orderDto.setDriver(userService.convertUserToUserDto(order.getDriverId().getUser()));
        List<UserDto> loadersLst = new ArrayList<>();
        for (Loaders loader : order.getLoaders()) {
            loadersLst.add(userService.convertUserToUserDto(loader.getUser()));
        }
        orderDto.setLoaders(loadersLst);
        orderDto.setPrice(order.getPrice());
        orderDto.setStatus(order.getStatus());
        List<UserDto> extraCustomersLst = new ArrayList<>();
        for (Customers customer : order.getExtraCustomers()) {
            extraCustomersLst.add(userService.convertUserToUserDto(customer.getUser()));
        }
        orderDto.setExtraCustomers(extraCustomersLst);

        return orderDto;
    }

    public OrderDetailsDto convertOrderDetailsToOrderDetailsDto(OrderDetails orderDetails) {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();

        orderDetailsDto.setComment(orderDetails.getComment());
        orderDetailsDto.setCountry(orderDetails.getCountry());
        orderDetailsDto.setStreet(orderDetails.getStreet());
        orderDetailsDto.setTown(orderDetails.getTown());
        orderDetailsDto.setTimeOnOrder(orderDetails.getTimeOnOrder());
        orderDetailsDto.setDateTime(orderDetails.getDateTime());
        orderDetailsDto.setHouseNomber(orderDetails.getHouseNomber());
        orderDetailsDto.setExtraHouseDefinition(orderDetails.getExtraHouseDefinition());
        orderDetailsDto.setTimeOnOrder(orderDetails.getTimeOnOrder());

        return orderDetailsDto;
    }

    public CarDto convertCarToCarDto(Car car) {
        CarDto carDto = new CarDto();

        carDto.setGosNomber(car.getGosNomber());

        return carDto;
    }

    public UserPublicDto convertUserToUserPublicDto(User user) {
        return new UserPublicDto(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
}
