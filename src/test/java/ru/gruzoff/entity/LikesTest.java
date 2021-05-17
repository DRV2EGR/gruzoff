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

public class LikesTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Likes()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Likes likes = new Likes();

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

        Likes likes1 = new Likes();
        likes1.setId(123L);
        likes1.setUser_to(user);
        likes1.setUser_from(user1);
        assertTrue(likes.canEqual(likes1));
    }

    @Test
    public void testConstructor() {
        Likes actualLikes = new Likes();
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
        actualLikes.setUser_from(user);
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
        actualLikes.setUser_to(user1);
        User user_to = actualLikes.getUser_to();
        User user_from = actualLikes.getUser_from();
        assertEquals(user_to, user_from);
        assertSame(user, user_from);
        assertSame(user1, user_to);
        assertEquals(user, user_to);
        assertEquals(
                "Likes(user_from=User{id=123, email='jane.doe@example.org'}, user_to=User{id=123, email='jane.doe@example"
                        + ".org'})",
                actualLikes.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Likes()).equals("42"));
    }

    @Test
    public void testEquals2() {
        Likes likes = new Likes();

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

        Likes likes1 = new Likes();
        likes1.setId(123L);
        likes1.setUser_to(user);
        likes1.setUser_from(user1);
        assertFalse(likes.equals(likes1));
    }

    @Test
    public void testEquals3() {
        Likes likes = new Likes();
        assertTrue(likes.equals(new Likes()));
    }

    @Test
    public void testEquals4() {
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

        Likes likes = new Likes();
        likes.setUser_to(user);
        assertFalse(likes.equals(new Likes()));
    }

    @Test
    public void testEquals5() {
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

        Likes likes = new Likes();
        likes.setUser_from(user);
        assertFalse(likes.equals(new Likes()));
    }

    @Test
    public void testEquals6() {
        Likes likes = new Likes();

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

        Likes likes1 = new Likes();
        likes1.setUser_to(user);
        assertFalse(likes.equals(likes1));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new Likes()).hashCode());
    }

    @Test
    public void testHashCode2() {
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

        Likes likes = new Likes();
        likes.setUser_to(user);
        assertEquals(1654525456, likes.hashCode());
    }

    @Test
    public void testHashCode3() {
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

        Likes likes = new Likes();
        likes.setUser_from(user);
        assertEquals(-1167597442, likes.hashCode());
    }

    @Test
    public void testHashCode4() {
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

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode(null);
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(null);
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(null);
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName(null);
        user1.setPuttedLikes(new ArrayList<Likes>());

        Likes likes = new Likes();
        likes.setId(123L);
        likes.setUser_to(user);
        likes.setUser_from(user1);

        ArrayList<Likes> likesList = new ArrayList<Likes>();
        likesList.add(likes);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setRecievedLikes(likesList);
        user2.setActivationCode(null);
        user2.setPuttedComments(new ArrayList<Comments>());
        user2.setCreatedActivationCode(null);
        user2.setId(123L);
        user2.setOrders(new ArrayList<Order>());
        user2.setRole(role2);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(null);
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setUsername("janedoe");
        user2.setRecievedComments(new ArrayList<Comments>());
        user2.setSecondName(null);
        user2.setPuttedLikes(new ArrayList<Likes>());

        Likes likes1 = new Likes();
        likes1.setUser_to(user2);
        assertEquals(117866359, likes1.hashCode());
    }

//    @Test
//    public void testHashCode5() {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName(null);
//
//        User user = new User();
//        user.setLastName("Doe");
//        user.setEmail("jane.doe@example.org");
//        user.setPassword("iloveyou");
//        user.setRecievedLikes(new ArrayList<Likes>());
//        user.setActivationCode(null);
//        user.setPuttedComments(new ArrayList<Comments>());
//        user.setCreatedActivationCode(null);
//        user.setId(123L);
//        user.setOrders(new ArrayList<Order>());
//        user.setRole(role);
//        user.setPhoneNumber("4105551212");
//        user.setTimeOfAccountCreation(null);
//        user.setUserProfileImageUrl("https://example.org/example");
//        user.setFirstName("Jane");
//        user.setUsername("janedoe");
//        user.setRecievedComments(new ArrayList<Comments>());
//        user.setSecondName(null);
//        user.setPuttedLikes(new ArrayList<Likes>());
//
//        Drivers drivers = new Drivers();
//        drivers.setId(123L);
//        drivers.setUser(user);
//        drivers.setCars(new ArrayList<Car>());
//
//        CarType carType = new CarType();
//        carType.setPricePerHour(10.0f);
//        carType.setId(123L);
//        carType.setDescription("The characteristics of someone or something");
//
//        Adress adress = new Adress();
//        adress.setLatitude(10.0f);
//        adress.setExtraHouseDefinition(null);
//        adress.setCountry(null);
//        adress.setLongitude(10.0f);
//        adress.setId(123L);
//        adress.setHouseNomber(null);
//        adress.setTown("Oxford");
//        adress.setStreet(null);
//
//        Adress adress1 = new Adress();
//        adress1.setLatitude(10.0f);
//        adress1.setExtraHouseDefinition(null);
//        adress1.setCountry(null);
//        adress1.setLongitude(10.0f);
//        adress1.setId(123L);
//        adress1.setHouseNomber(null);
//        adress1.setTown("Oxford");
//        adress1.setStreet(null);
//
//        OrderDetails orderDetails = new OrderDetails();
//        orderDetails.setCarType(carType);
//        orderDetails.setTimeOnOrder(10.0f);
//        orderDetails.setAdressFrom(adress);
//        orderDetails.setAdressTo(adress1);
//        orderDetails.setId(123L);
//        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
//        orderDetails.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
//        orderDetails.setComment(null);
//        orderDetails.setLoadersCapacity(0);
//
//        CarType carType1 = new CarType();
//        carType1.setPricePerHour(10.0f);
//        carType1.setId(123L);
//        carType1.setDescription("The characteristics of someone or something");
//
//        Car car = new Car();
//        car.setMaxPeopleCapacity(3);
//        car.setGosNomber(null);
//        car.setType(carType1);
//        car.setId(123L);
//        car.setMax_weight(3);
//        car.setSize(3);
//        car.setWidth(1);
//        car.setLength(3);
//        car.setHeight(0);
//
//        Role role1 = new Role();
//        role1.setId(123L);
//        role1.setName(null);
//
//        User user1 = new User();
//        user1.setLastName("Doe");
//        user1.setEmail("jane.doe@example.org");
//        user1.setPassword("iloveyou");
//        user1.setRecievedLikes(new ArrayList<Likes>());
//        user1.setActivationCode(null);
//        user1.setPuttedComments(new ArrayList<Comments>());
//        user1.setCreatedActivationCode(null);
//        user1.setId(123L);
//        user1.setOrders(new ArrayList<Order>());
//        user1.setRole(role1);
//        user1.setPhoneNumber("4105551212");
//        user1.setTimeOfAccountCreation(null);
//        user1.setUserProfileImageUrl("https://example.org/example");
//        user1.setFirstName("Jane");
//        user1.setUsername("janedoe");
//        user1.setRecievedComments(new ArrayList<Comments>());
//        user1.setSecondName(null);
//        user1.setPuttedLikes(new ArrayList<Likes>());
//
//        Customers customers = new Customers();
//        customers.setId(123L);
//        customers.setUser(user1);
//
//        Order order = new Order();
//        order.setExtraCustomers(new ArrayList<Customers>());
//        order.setSended(true);
//        order.setDriverId(drivers);
//        order.setStatus(null);
//        order.setPrice(10.0f);
//        order.setOrderDetails(orderDetails);
//        order.setId(123L);
//        order.setCarId(car);
//        order.setCustomerId(customers);
//        order.setLoaders(new ArrayList<Loaders>());
//
//        ArrayList<Order> orderList = new ArrayList<Order>();
//        orderList.add(order);
//
//        Role role2 = new Role();
//        role2.setId(123L);
//        role2.setName(null);
//
//        User user2 = new User();
//        user2.setLastName("Doe");
//        user2.setEmail("jane.doe@example.org");
//        user2.setPassword("iloveyou");
//        user2.setRecievedLikes(new ArrayList<Likes>());
//        user2.setActivationCode(null);
//        user2.setPuttedComments(new ArrayList<Comments>());
//        user2.setCreatedActivationCode(null);
//        user2.setId(123L);
//        user2.setOrders(orderList);
//        user2.setRole(role2);
//        user2.setPhoneNumber("4105551212");
//        user2.setTimeOfAccountCreation(null);
//        user2.setUserProfileImageUrl("https://example.org/example");
//        user2.setFirstName("Jane");
//        user2.setUsername("janedoe");
//        user2.setRecievedComments(new ArrayList<Comments>());
//        user2.setSecondName(null);
//        user2.setPuttedLikes(new ArrayList<Likes>());
//
//        Likes likes = new Likes();
//        likes.setUser_to(user2);
//        assertEquals(2034939652, likes.hashCode());
//    }

    @Test
    public void testHashCode6() {
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

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

        User user1 = new User();
        user1.setLastName("Doe");
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setRecievedLikes(new ArrayList<Likes>());
        user1.setActivationCode(null);
        user1.setPuttedComments(new ArrayList<Comments>());
        user1.setCreatedActivationCode(null);
        user1.setId(123L);
        user1.setOrders(new ArrayList<Order>());
        user1.setRole(role1);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(null);
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName(null);
        user1.setPuttedLikes(new ArrayList<Likes>());

        Likes likes = new Likes();
        likes.setId(123L);
        likes.setUser_to(user);
        likes.setUser_from(user1);

        ArrayList<Likes> likesList = new ArrayList<Likes>();
        likesList.add(likes);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setRecievedLikes(likesList);
        user2.setActivationCode(null);
        user2.setPuttedComments(new ArrayList<Comments>());
        user2.setCreatedActivationCode(null);
        user2.setId(123L);
        user2.setOrders(new ArrayList<Order>());
        user2.setRole(role2);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(null);
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setUsername("janedoe");
        user2.setRecievedComments(new ArrayList<Comments>());
        user2.setSecondName(null);
        user2.setPuttedLikes(new ArrayList<Likes>());

        Likes likes1 = new Likes();
        likes1.setUser_from(user2);
        assertEquals(-1636170949, likes1.hashCode());
    }
}

