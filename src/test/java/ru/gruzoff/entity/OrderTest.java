package ru.gruzoff.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Order()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Order order = new Order();

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("Activation Code");
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
        drivers.setCars(new ArrayList<Car>());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment("Comment");
        orderDetails.setLoadersCapacity(0);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType1);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user1);

        Order order1 = new Order();
        order1.setExtraCustomers(new ArrayList<Customers>());
        order1.setSended(true);
        order1.setDriverId(drivers);
        order1.setStatus("Status");
        order1.setPrice(10.0f);
        order1.setOrderDetails(orderDetails);
        order1.setId(123L);
        order1.setCarId(car);
        order1.setCustomerId(customers);
        order1.setLoaders(new ArrayList<Loaders>());
        assertTrue(order.canEqual(order1));
    }

    @Test
    public void testConstructor() {
        Order actualOrder = new Order();
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");
        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);
        actualOrder.setCarId(car);
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("Activation Code");
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());
        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user);
        actualOrder.setCustomerId(customers);
        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());
        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user1);
        drivers.setCars(new ArrayList<Car>());
        actualOrder.setDriverId(drivers);
        ArrayList<Customers> customersList = new ArrayList<Customers>();
        actualOrder.setExtraCustomers(customersList);
        ArrayList<Loaders> loadersList = new ArrayList<Loaders>();
        actualOrder.setLoaders(loadersList);
        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");
        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType1);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment("Comment");
        orderDetails.setLoadersCapacity(1);
        actualOrder.setOrderDetails(orderDetails);
        actualOrder.setPrice(10.0f);
        actualOrder.setSended(true);
        actualOrder.setStatus("Status");
        assertSame(car, actualOrder.getCarId());
        assertSame(customers, actualOrder.getCustomerId());
        assertSame(drivers, actualOrder.getDriverId());
        assertSame(customersList, actualOrder.getExtraCustomers());
        assertSame(loadersList, actualOrder.getLoaders());
        assertSame(orderDetails, actualOrder.getOrderDetails());
        assertEquals(10.0f, actualOrder.getPrice());
        assertEquals("Status", actualOrder.getStatus());
        assertTrue(actualOrder.isSended());
    }

    @Test
    public void testConstructor2() {
        Customers customerId = new Customers();
        Drivers driverId = new Drivers();
        Car carId = new Car();
        OrderDetails orderDetails = new OrderDetails();
        ArrayList<Loaders> loaders = new ArrayList<Loaders>();
        Order actualOrder = new Order(customerId, driverId, carId, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<Customers>(), true);
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");
        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);
        actualOrder.setCarId(car);
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("Activation Code");
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());
        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user);
        actualOrder.setCustomerId(customers);
        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());
        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user1);
        drivers.setCars(new ArrayList<Car>());
        actualOrder.setDriverId(drivers);
        ArrayList<Customers> customersList = new ArrayList<Customers>();
        actualOrder.setExtraCustomers(customersList);
        ArrayList<Loaders> loadersList = new ArrayList<Loaders>();
        actualOrder.setLoaders(loadersList);
        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");
        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType1);
        orderDetails1.setTimeOnOrder(10.0f);
        orderDetails1.setAdressFrom(adress);
        orderDetails1.setAdressTo(adress1);
        orderDetails1.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails1.setComment("Comment");
        orderDetails1.setLoadersCapacity(1);
        actualOrder.setOrderDetails(orderDetails1);
        actualOrder.setPrice(10.0f);
        actualOrder.setSended(true);
        actualOrder.setStatus("Status");
        assertSame(car, actualOrder.getCarId());
        assertSame(customers, actualOrder.getCustomerId());
        assertSame(drivers, actualOrder.getDriverId());
        assertSame(customersList, actualOrder.getExtraCustomers());
        assertSame(loadersList, actualOrder.getLoaders());
        assertSame(orderDetails1, actualOrder.getOrderDetails());
        assertEquals(10.0f, actualOrder.getPrice());
        assertEquals("Status", actualOrder.getStatus());
        assertTrue(actualOrder.isSended());
    }

    @Test
    public void testEquals() {
        assertFalse((new Order()).equals("42"));
    }

    @Test
    public void testEquals10() {
        Order order = new Order();
        order.setLoaders(new ArrayList<Loaders>());
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testEquals11() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setExtraCustomers(new ArrayList<Customers>());
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals12() {
        Order order = new Order();

        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode(null);
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(null);
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName(null);
        user.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
        drivers.setCars(new ArrayList<Car>());

        Order order1 = new Order();
        order1.setDriverId(drivers);
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals13() {
        Order order = new Order();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition(null);
        adress1.setCountry(null);
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber(null);
        adress1.setTown("Oxford");
        adress1.setStreet(null);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment(null);
        orderDetails.setLoadersCapacity(0);

        Order order1 = new Order();
        order1.setOrderDetails(orderDetails);
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals14() {
        Order order = new Order();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber(null);
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        Order order1 = new Order();
        order1.setCarId(car);
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals15() {
        Order order = new Order();

        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode(null);
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(null);
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName(null);
        user.setPuttedLikes(new ArrayList<Likes>());

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user);

        Order order1 = new Order();
        order1.setCustomerId(customers);
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals16() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setLoaders(new ArrayList<Loaders>());
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals2() {
        Order order = new Order();

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("Activation Code");
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
        drivers.setCars(new ArrayList<Car>());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment("Comment");
        orderDetails.setLoadersCapacity(0);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType1);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user1);

        Order order1 = new Order();
        order1.setExtraCustomers(new ArrayList<Customers>());
        order1.setSended(true);
        order1.setDriverId(drivers);
        order1.setStatus("Status");
        order1.setPrice(10.0f);
        order1.setOrderDetails(orderDetails);
        order1.setId(123L);
        order1.setCarId(car);
        order1.setCustomerId(customers);
        order1.setLoaders(new ArrayList<Loaders>());
        assertFalse(order.equals(order1));
    }

    @Test
    public void testEquals3() {
        Order order = new Order();
        assertTrue(order.equals(new Order()));
    }

    @Test
    public void testEquals4() {
        Order order = new Order();
        order.setExtraCustomers(new ArrayList<Customers>());
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testEquals5() {
        Order order = new Order();
        order.setSended(true);
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testEquals6() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode(null);
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(null);
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName(null);
        user.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
        drivers.setCars(new ArrayList<Car>());

        Order order = new Order();
        order.setDriverId(drivers);
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testEquals7() {
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition(null);
        adress1.setCountry(null);
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber(null);
        adress1.setTown("Oxford");
        adress1.setStreet(null);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment(null);
        orderDetails.setLoadersCapacity(0);

        Order order = new Order();
        order.setOrderDetails(orderDetails);
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testEquals8() {
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber(null);
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        Order order = new Order();
        order.setCarId(car);
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testEquals9() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode(null);
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(null);
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName(null);
        user.setPuttedLikes(new ArrayList<Likes>());

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user);

        Order order = new Order();
        order.setCustomerId(customers);
        assertFalse(order.equals(new Order()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1706077331, (new Order()).hashCode());
    }

    @Test
    public void testHashCode2() {
        Customers customerId = new Customers();
        Drivers driverId = new Drivers();
        Car carId = new Car();
        OrderDetails orderDetails = new OrderDetails();
        ArrayList<Loaders> loaders = new ArrayList<Loaders>();
        assertEquals(-269054726, (new Order(customerId, driverId, carId, 10.0f, "Status", orderDetails, loaders,
                new ArrayList<Customers>(), true)).hashCode());
    }

    @Test
    public void testHashCode3() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("Activation Code");
        user.setPuttedComments(new ArrayList<Comments>());
        user.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setId(123L);
        user.setOrders(new ArrayList<Order>());
        user.setRole(role);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName("Second Name");
        user.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers = new Drivers();
        drivers.setId(123L);
        drivers.setUser(user);
        drivers.setCars(new ArrayList<Car>());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        orderDetails.setTimeOnOrder(10.0f);
        orderDetails.setAdressFrom(adress);
        orderDetails.setAdressTo(adress1);
        orderDetails.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails.setComment("Comment");
        orderDetails.setLoadersCapacity(1);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType1);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode("Activation Code");
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());

        Customers customers = new Customers();
        customers.setId(123L);
        customers.setUser(user1);

        Order order = new Order();
        order.setExtraCustomers(new ArrayList<Customers>());
        order.setSended(true);
        order.setDriverId(drivers);
        order.setStatus("Status");
        order.setPrice(10.0f);
        order.setOrderDetails(orderDetails);
        order.setId(123L);
        order.setCarId(car);
        order.setCustomerId(customers);
        order.setLoaders(new ArrayList<Loaders>());

        ArrayList<Order> orderList = new ArrayList<Order>();
        orderList.add(order);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setRecievedLikes(new ArrayList<Likes>());
        user2.setActivationCode(null);
        user2.setPuttedComments(new ArrayList<Comments>());
        user2.setCreatedActivationCode(null);
        user2.setId(123L);
        user2.setOrders(orderList);
        user2.setRole(role2);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(null);
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setUsername("janedoe");
        user2.setRecievedComments(new ArrayList<Comments>());
        user2.setSecondName(null);
        user2.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers1 = new Drivers();
        drivers1.setId(123L);
        drivers1.setUser(user2);
        drivers1.setCars(new ArrayList<Car>());

        Order order1 = new Order();
        order1.setDriverId(drivers1);
        assertEquals(157091594, order1.hashCode());
    }
}

