package ru.gruzoff.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.*;
import ru.gruzoff.entity.*;

/**
 * The type Class to dto service.
 */
@Service
public class ClassToDtoService
{
    /**
     * The User service.
     */
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

    /**
     * Convert adress to adress dto adress dto.
     *
     * @param adress the adress
     * @return the adress dto
     */
    public AdressDto convertAdressToAdressDto(Adress adress) {
        return new AdressDto(
                adress.getCountry(),
                adress.getTown(),
                adress.getStreet(),
                adress.getHouseNomber(),
                adress.getExtraHouseDefinition()
        );
    }

    /**
     * Convert order details to order details dto order details dto.
     *
     * @param orderDetails the order details
     * @return the order details dto
     */
    public OrderDetailsDto convertOrderDetailsToOrderDetailsDto(OrderDetails orderDetails) {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();

        orderDetailsDto.setLoadersCapacity(orderDetails.getLoadersCapacity());
        orderDetailsDto.setAdressFrom(convertAdressToAdressDto(orderDetails.getAdressFrom()));
        orderDetailsDto.setAdressTo(convertAdressToAdressDto(orderDetails.getAdressTo()));

        orderDetailsDto.setComment(orderDetails.getComment());
        orderDetailsDto.setTimeOnOrder(orderDetails.getTimeOnOrder());
        orderDetailsDto.setDateTime(orderDetails.getDateTime());

        return orderDetailsDto;
    }

    /**
     * Convert car to car dto car dto.
     *
     * @param car the car
     * @return the car dto
     */
    public CarDto convertCarToCarDto(Car car) {
        if (car == null) { return null; }
        return new CarDto(
                car.getMax_weight(),
                car.getLength(),
                car.getWidth(),
                car.getHeight(),
                car.getSize(),
                car.getMaxPeopleCapacity(),
                (int) car.getType().getId(),
                car.getGosNomber()
        );
    }

    /**
     * Convert user to user public dto user public dto.
     *
     * @param user the user
     * @return the user public dto
     */
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

    /**
     * Convert order to order dto order dto.
     *
     * @param order the order
     * @return the order dto
     */
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
                order.getId(),
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

    /**
     * Convert car type to car type dto car type dto.
     *
     * @param carType the car type
     * @return the car type dto
     */
    public CarTypeDto convertCarTypeToCarTypeDto(CarType carType) {
        return new CarTypeDto(
                carType.getId(),
                carType.getPricePerHour(),
                carType.getDescription()
        );
    }

    /**
     * Convert car validity to car validity dto car validity dto.
     *
     * @param carValidity the car validity
     * @return the car validity dto
     */
    public CarValidityDto convertCarValidityToCarValidityDto(CarValidity carValidity) {
        return new CarValidityDto(
                carValidity.isValid(),
                carValidity.getReasonOfCrash()
        );
    }

    /**
     * Convert car to car with car valid dto car with car valid dto.
     *
     * @param car         the car
     * @param carValidity the car validity
     * @return the car with car valid dto
     */
    public CarWithCarValidDto convertCarToCarWithCarValidDto(Car car, CarValidity carValidity) {
        return new CarWithCarValidDto(
                car.getMax_weight(),
                car.getLength(),
                car.getWidth(),
                car.getHeight(),
                car.getSize(),
                car.getMaxPeopleCapacity(),
                convertCarTypeToCarTypeDto(car.getType()),
                car.getGosNomber(),
                convertCarValidityToCarValidityDto(carValidity)
        );
    }
}
