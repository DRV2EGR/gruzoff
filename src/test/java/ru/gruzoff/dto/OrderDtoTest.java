package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class OrderDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new OrderDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        OrderDto orderDto = new OrderDto();
        assertTrue(orderDto.canEqual(new OrderDto()));
    }

    @Test
    public void testConstructor() {
        OrderDto actualOrderDto = new OrderDto();
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        actualOrderDto.setCar(carDto);
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        actualOrderDto.setCustomer(userDto);
        UserDto userDto1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        actualOrderDto.setDriver(userDto1);
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();
        actualOrderDto.setExtraCustomers(userDtoList);
        actualOrderDto.setId(123L);
        ArrayList<UserDto> userDtoList1 = new ArrayList<UserDto>();
        actualOrderDto.setLoaders(userDtoList1);
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        actualOrderDto.setOrderDetails(orderDetailsDto);
        actualOrderDto.setPrice(10.0f);
        actualOrderDto.setStatus("Status");
        assertSame(carDto, actualOrderDto.getCar());
        UserDto customer = actualOrderDto.getCustomer();
        assertSame(userDto, customer);
        assertEquals(userDto1, customer);
        UserDto driver = actualOrderDto.getDriver();
        assertSame(userDto1, driver);
        assertEquals(customer, driver);
        assertSame(userDtoList, actualOrderDto.getExtraCustomers());
        assertEquals(123L, actualOrderDto.getId());
        assertSame(userDtoList1, actualOrderDto.getLoaders());
        assertSame(orderDetailsDto, actualOrderDto.getOrderDetails());
        assertEquals(10.0f, actualOrderDto.getPrice());
        assertEquals("Status", actualOrderDto.getStatus());
        assertEquals("OrderDto(id=123, customer=UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe,"
                + " username=janedoe, email=jane.doe@example.org, phoneNumber=4105551212, role=Role), driver=UserDto(id=0,"
                + " firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane.doe@example.org,"
                + " phoneNumber=4105551212, role=Role), car=CarDto(max_weight=3, length=3, width=1, height=1, size=3,"
                + " maxPeopleCapacity=3, type=1, gosNomber=Gos Nomber), price=10.0, status=Status, orderDetails=OrderDetailsDto"
                + "(adressFrom=null, adressTo=null, dateTime=null, timeOnOrder=0.0, loadersCapacity=0, comment=null),"
                + " loaders=[], extraCustomers=[])", actualOrderDto.toString());
    }

    @Test
    public void testConstructor2() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto actualOrderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        assertEquals("OrderDto(id=123, customer=UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe,"
                + " username=janedoe, email=jane.doe@example.org, phoneNumber=4105551212, role=Role), driver=UserDto(id=0,"
                + " firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane.doe@example.org,"
                + " phoneNumber=4105551212, role=Role), car=CarDto(max_weight=3, length=3, width=1, height=1, size=3,"
                + " maxPeopleCapacity=3, type=1, gosNomber=Gos Nomber), price=10.0, status=Status, orderDetails=OrderDetailsDto"
                + "(adressFrom=null, adressTo=null, dateTime=null, timeOnOrder=0.0, loadersCapacity=0, comment=null),"
                + " loaders=[], extraCustomers=[])", actualOrderDto.toString());
        assertEquals(10.0f, actualOrderDto.getPrice());
        assertEquals("Status", actualOrderDto.getStatus());
        assertEquals(123L, actualOrderDto.getId());
    }

    @Test
    public void testEquals() {
        assertFalse((new OrderDto()).equals("42"));
    }

    @Test
    public void testEquals10() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(0, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals11() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, null, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals12() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Jane", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals13() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, null, orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals14() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", null, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals15() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetails = new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment");
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals16() {
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();
        userDtoList.add(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, userDtoList,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals17() {
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();
        userDtoList.add(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails,
                new ArrayList<UserDto>(), userDtoList);
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals2() {
        OrderDto orderDto = new OrderDto();
        assertTrue(orderDto.equals(new OrderDto()));
    }

    @Test
    public void testEquals3() {
        OrderDto orderDto = new OrderDto();
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(
                new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders, new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals4() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertTrue(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals5() {
        OrderDto orderDto = new OrderDto();
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(
                new OrderDto(0L, customer, driver, car, 10.0f, "Status", orderDetails, loaders, new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals6() {
        UserDto customer = new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals7() {
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, null, driver, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals8() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver1, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testEquals9() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        OrderDto orderDto = new OrderDto(123L, customer, null, car, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<UserDto>());
        UserDto customer1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car1 = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails1 = new OrderDetailsDto();
        ArrayList<UserDto> loaders1 = new ArrayList<UserDto>();
        assertFalse(orderDto.equals(new OrderDto(123L, customer1, driver, car1, 10.0f, "Status", orderDetails1, loaders1,
                new ArrayList<UserDto>())));
    }

    @Test
    public void testHashCode() {
        assertEquals(2031734202, (new OrderDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        UserDto customer = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto driver = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        CarDto car = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        OrderDetailsDto orderDetails = new OrderDetailsDto();
        ArrayList<UserDto> loaders = new ArrayList<UserDto>();
        assertEquals(802200513,
                (new OrderDto(123L, customer, driver, car, 10.0f, "Status", orderDetails, loaders, new ArrayList<UserDto>()))
                        .hashCode());
    }
}

