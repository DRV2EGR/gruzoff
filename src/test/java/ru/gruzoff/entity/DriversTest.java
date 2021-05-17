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

public class DriversTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Drivers()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Drivers drivers = new Drivers();

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

        Drivers drivers1 = new Drivers();
        drivers1.setId(123L);
        drivers1.setUser(user);
        drivers1.setCars(new ArrayList<Car>());
        assertTrue(drivers.canEqual(drivers1));
    }

    @Test
    public void testConstructor() {
        Drivers actualDrivers = new Drivers();
        ArrayList<Car> carList = new ArrayList<Car>();
        actualDrivers.setCars(carList);
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
        actualDrivers.setUser(user);
        assertSame(carList, actualDrivers.getCars());
        assertSame(user, actualDrivers.getUser());
        assertEquals("Drivers(user=User{id=123, email='jane.doe@example.org'}, cars=[])", actualDrivers.toString());
    }

    @Test
    public void testConstructor2() {
        User user = new User(123L, "janedoe");
        Drivers actualDrivers = new Drivers(user, new ArrayList<Car>());
        ArrayList<Car> carList = new ArrayList<Car>();
        actualDrivers.setCars(carList);
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
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
        user1.setRole(role);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());
        actualDrivers.setUser(user1);
        assertSame(carList, actualDrivers.getCars());
        assertSame(user1, actualDrivers.getUser());
        assertEquals("Drivers(user=User{id=123, email='jane.doe@example.org'}, cars=[])", actualDrivers.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Drivers()).equals("42"));
    }

    @Test
    public void testEquals2() {
        Drivers drivers = new Drivers();

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

        Drivers drivers1 = new Drivers();
        drivers1.setId(123L);
        drivers1.setUser(user);
        drivers1.setCars(new ArrayList<Car>());
        assertFalse(drivers.equals(drivers1));
    }

    @Test
    public void testEquals3() {
        Drivers drivers = new Drivers();
        assertTrue(drivers.equals(new Drivers()));
    }

    @Test
    public void testEquals4() {
        User user = new User(123L, "janedoe");
        Drivers drivers = new Drivers(user, new ArrayList<Car>());

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

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
        user1.setRole(role);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName("Second Name");
        user1.setPuttedLikes(new ArrayList<Likes>());

        Drivers drivers1 = new Drivers();
        drivers1.setId(123L);
        drivers1.setUser(user1);
        drivers1.setCars(new ArrayList<Car>());
        assertFalse(drivers.equals(drivers1));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new Drivers()).hashCode());
    }

    @Test
    public void testHashCode2() {
        User user = new User(123L, "janedoe");
        assertEquals(1449287045, (new Drivers(user, new ArrayList<Car>())).hashCode());
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
        drivers1.setUser(user2);
        assertEquals(2052126540, drivers1.hashCode());
    }
}

