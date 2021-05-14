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

//    public OrderDto convertOrderToOrderDto(Order order) {
//        OrderDto orderDto = new OrderDto();
//
//        orderDto.setOrderDetails(
//                convertOrderDetailsToOrderDetailsDto(order.getOrderDetails())
//        );
//        orderDto.setCar(convertCarToCarDto(order.getCarId()));
//        orderDto.setCustomer(userService.convertUserToUserDto(order.getCustomerId().getUser()));
//        orderDto.setDriver(userService.convertUserToUserDto(order.getDriverId().getUser()));
//        List<UserDto> loadersLst = new ArrayList<>();
//        for (Loaders loader : order.getLoaders()) {
//            loadersLst.add(userService.convertUserToUserDto(loader.getUser()));
//        }
//        orderDto.setLoaders(loadersLst);
//        orderDto.setPrice(order.getPrice());
//        orderDto.setStatus(order.getStatus());
//        List<UserDto> extraCustomersLst = new ArrayList<>();
//        for (Customers customer : order.getExtraCustomers()) {
//            extraCustomersLst.add(userService.convertUserToUserDto(customer.getUser()));
//        }
//        orderDto.setExtraCustomers(extraCustomersLst);
//
//        return orderDto;
//    }

    public AdressDto convertAdressToAdressDto(Adress adress) {
        return new AdressDto(
                adress.getCountry(),
                adress.getTown(),
                adress.getStreet(),
                adress.getHouseNomber(),
                adress.getExtraHouseDefinition()
        );
    }

    public OrderDetailsDto convertOrderDetailsToOrderDetailsDto(OrderDetails orderDetails) {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();

        orderDetailsDto.setComment(orderDetails.getComment());
        orderDetailsDto.setTimeOnOrder(orderDetails.getTimeOnOrder());
        orderDetailsDto.setDateTime(orderDetails.getDateTime());
        orderDetailsDto.setTimeOnOrder(orderDetails.getTimeOnOrder());

        return orderDetailsDto;
    }

    public CarDto convertCarToCarDto(Car car) {
        if (car == null) { return null; }
        return new CarDto(
                car.getMax_weight(),
                car.getLength(),
                car.getWidth(),
                car.getHeight(),
                car.getSize(),
                car.getMaxPeopleCapacity(),
                car.getType(),
                car.getGosNomber()
        );
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

    public OrderDto convertOrderToOrderDto(Order order) {

        List<UserDto> loaderslstDto = new ArrayList<>();
        for(Loaders loader : order.getLoaders()) {
            loaderslstDto.add(userService.convertUserToUserDto(loader.getUser()));
        }

        List<UserDto> extraCusDto = new ArrayList<>();
        for(Customers customer : order.getExtraCustomers()) {
            extraCusDto.add(userService.convertUserToUserDto(customer.getUser()));
        }

        return new OrderDto(
                userService.convertUserToUserDto(order.getCustomerId().getUser()),

                order.getDriverId() != null ? userService.convertUserToUserDto(order.getDriverId().getUser()) : null ,

                convertCarToCarDto(order.getCarId()),
                order.getPrice(),
                order.getStatus(),
                convertOrderDetailsToOrderDetailsDto(order.getOrderDetails()),
                loaderslstDto,
                extraCusDto
        );
    }
}
