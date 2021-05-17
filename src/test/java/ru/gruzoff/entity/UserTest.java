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

public class UserTest {
    @Test
    public void testCanEqual() {
        assertFalse((new User(123L, "janedoe")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        User user = new User(123L, "janedoe");

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
        assertTrue(user.canEqual(user1));
    }

    @Test
    public void testConstructor() {
        User actualUser = new User();
        actualUser.setActivationCode("Activation Code");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUser.setCreatedActivationCode(ofResult);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        ArrayList<Order> orderList = new ArrayList<Order>();
        actualUser.setOrders(orderList);
        actualUser.setPassword("iloveyou");
        actualUser.setPhoneNumber("4105551212");
        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        actualUser.setPuttedComments(commentsList);
        ArrayList<Likes> likesList = new ArrayList<Likes>();
        actualUser.setPuttedLikes(likesList);
        ArrayList<Comments> commentsList1 = new ArrayList<Comments>();
        actualUser.setRecievedComments(commentsList1);
        ArrayList<Likes> likesList1 = new ArrayList<Likes>();
        actualUser.setRecievedLikes(likesList1);
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        actualUser.setRole(role);
        actualUser.setSecondName("Second Name");
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUser.setTimeOfAccountCreation(ofResult1);
        actualUser.setUserProfileImageUrl("https://example.org/example");
        actualUser.setUsername("janedoe");
        assertEquals("Activation Code", actualUser.getActivationCode());
        LocalDateTime timeOfAccountCreation = actualUser.getTimeOfAccountCreation();
        LocalDateTime createdActivationCode = actualUser.getCreatedActivationCode();
        assertEquals(timeOfAccountCreation, createdActivationCode);
        assertSame(ofResult, createdActivationCode);
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertSame(orderList, actualUser.getOrders());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("4105551212", actualUser.getPhoneNumber());
        assertSame(commentsList, actualUser.getPuttedComments());
        assertSame(likesList, actualUser.getPuttedLikes());
        assertSame(commentsList1, actualUser.getRecievedComments());
        assertSame(likesList1, actualUser.getRecievedLikes());
        assertSame(role, actualUser.getRole());
        assertEquals("Second Name", actualUser.getSecondName());
        assertEquals(ofResult, timeOfAccountCreation);
        assertSame(ofResult1, timeOfAccountCreation);
        assertEquals("https://example.org/example", actualUser.getUserProfileImageUrl());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("User{id=0, email='jane.doe@example.org'}", actualUser.toString());
    }

    @Test
    public void testConstructor2() {
        User actualUser = new User("Jane", "Second Name", "Doe", "jane.doe@example.org", "4105551212");
        actualUser.setActivationCode("Activation Code");
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUser.setCreatedActivationCode(ofResult);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        ArrayList<Order> orderList = new ArrayList<Order>();
        actualUser.setOrders(orderList);
        actualUser.setPassword("iloveyou");
        actualUser.setPhoneNumber("4105551212");
        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        actualUser.setPuttedComments(commentsList);
        ArrayList<Likes> likesList = new ArrayList<Likes>();
        actualUser.setPuttedLikes(likesList);
        ArrayList<Comments> commentsList1 = new ArrayList<Comments>();
        actualUser.setRecievedComments(commentsList1);
        ArrayList<Likes> likesList1 = new ArrayList<Likes>();
        actualUser.setRecievedLikes(likesList1);
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        actualUser.setRole(role);
        actualUser.setSecondName("Second Name");
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUser.setTimeOfAccountCreation(ofResult1);
        actualUser.setUserProfileImageUrl("https://example.org/example");
        actualUser.setUsername("janedoe");
        assertEquals("Activation Code", actualUser.getActivationCode());
        LocalDateTime createdActivationCode = actualUser.getCreatedActivationCode();
        assertSame(ofResult, createdActivationCode);
        LocalDateTime timeOfAccountCreation = actualUser.getTimeOfAccountCreation();
        assertEquals(timeOfAccountCreation, createdActivationCode);
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertSame(orderList, actualUser.getOrders());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("4105551212", actualUser.getPhoneNumber());
        assertSame(commentsList, actualUser.getPuttedComments());
        assertSame(likesList, actualUser.getPuttedLikes());
        assertSame(commentsList1, actualUser.getRecievedComments());
        assertSame(likesList1, actualUser.getRecievedLikes());
        assertSame(role, actualUser.getRole());
        assertEquals("Second Name", actualUser.getSecondName());
        assertSame(ofResult1, timeOfAccountCreation);
        assertEquals(ofResult, timeOfAccountCreation);
        assertEquals("https://example.org/example", actualUser.getUserProfileImageUrl());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("User{id=0, email='jane.doe@example.org'}", actualUser.toString());
    }

    @Test
    public void testConstructor3() {
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
        Role role = new Role();
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Likes> puttedLikes = new ArrayList<Likes>();
        ArrayList<Likes> recievedLikes = new ArrayList<Likes>();
        ArrayList<Comments> puttedComments = new ArrayList<Comments>();
        User actualUser = new User("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "iloveyou",
                "4105551212", "Activation Code", ofResult, ofResult1, "https://example.org/example", role, orders, puttedLikes,
                recievedLikes, puttedComments, new ArrayList<Comments>());
        actualUser.setActivationCode("Activation Code");
        LocalDateTime ofResult2 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUser.setCreatedActivationCode(ofResult2);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setLastName("Doe");
        ArrayList<Order> orderList = new ArrayList<Order>();
        actualUser.setOrders(orderList);
        actualUser.setPassword("iloveyou");
        actualUser.setPhoneNumber("4105551212");
        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        actualUser.setPuttedComments(commentsList);
        ArrayList<Likes> likesList = new ArrayList<Likes>();
        actualUser.setPuttedLikes(likesList);
        ArrayList<Comments> commentsList1 = new ArrayList<Comments>();
        actualUser.setRecievedComments(commentsList1);
        ArrayList<Likes> likesList1 = new ArrayList<Likes>();
        actualUser.setRecievedLikes(likesList1);
        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        actualUser.setRole(role1);
        actualUser.setSecondName("Second Name");
        LocalDateTime ofResult3 = LocalDateTime.of(1, 1, 1, 1, 1);
        actualUser.setTimeOfAccountCreation(ofResult3);
        actualUser.setUserProfileImageUrl("https://example.org/example");
        actualUser.setUsername("janedoe");
        assertEquals("Activation Code", actualUser.getActivationCode());
        LocalDateTime timeOfAccountCreation = actualUser.getTimeOfAccountCreation();
        LocalDateTime createdActivationCode = actualUser.getCreatedActivationCode();
        assertEquals(timeOfAccountCreation, createdActivationCode);
        assertSame(ofResult2, createdActivationCode);
        assertEquals(ofResult1, createdActivationCode);
        assertEquals(ofResult, createdActivationCode);
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Doe", actualUser.getLastName());
        assertSame(orderList, actualUser.getOrders());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("4105551212", actualUser.getPhoneNumber());
        assertSame(commentsList, actualUser.getPuttedComments());
        assertSame(likesList, actualUser.getPuttedLikes());
        assertSame(commentsList1, actualUser.getRecievedComments());
        assertSame(likesList1, actualUser.getRecievedLikes());
        assertSame(role1, actualUser.getRole());
        assertEquals("Second Name", actualUser.getSecondName());
        assertEquals(ofResult2, timeOfAccountCreation);
        assertSame(ofResult3, timeOfAccountCreation);
        assertEquals(ofResult1, timeOfAccountCreation);
        assertEquals(ofResult, timeOfAccountCreation);
        assertEquals("https://example.org/example", actualUser.getUserProfileImageUrl());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("User{id=0, email='jane.doe@example.org'}", actualUser.toString());
    }

    @Test
    public void testConstructor4() {
        User actualUser = new User(123L, "janedoe");
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals(123L, actualUser.getId());
    }

    @Test
    public void testEquals() {
        assertFalse((new User(123L, "janedoe")).equals("42"));
    }

    @Test
    public void testEquals10() {
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
        user.setSecondName("Jane");
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
        assertFalse(user.equals(user1));
    }

    @Test
    public void testEquals11() {
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
        assertFalse(user.equals(user1));
    }

    @Test
    public void testEquals2() {
        User user = new User(123L, "janedoe");

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
        assertFalse(user.equals(user1));
    }

    @Test
    public void testEquals3() {
        User user = new User(123L, "janedoe");
        assertTrue(user.equals(new User(123L, "janedoe")));
    }

    @Test
    public void testEquals4() {
        User user = new User(123L, "janedoe");
        assertFalse(user.equals(new User()));
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
        assertFalse(user.equals(user1));
    }

    @Test
    public void testEquals6() {
        User user = new User("Jane", "Second Name", "Doe", "jane.doe@example.org", "4105551212");

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
        assertFalse(user.equals(user1));
    }

    @Test
    public void testEquals7() {
        LocalDateTime timeOfAccountCreation = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime createdActivationCode = LocalDateTime.of(1, 1, 1, 1, 1);
        Role role = new Role();
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Likes> puttedLikes = new ArrayList<Likes>();
        ArrayList<Likes> recievedLikes = new ArrayList<Likes>();
        ArrayList<Comments> puttedComments = new ArrayList<Comments>();
        User user = new User("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "iloveyou", "4105551212",
                "Activation Code", timeOfAccountCreation, createdActivationCode, "https://example.org/example", role, orders,
                puttedLikes, recievedLikes, puttedComments, new ArrayList<Comments>());

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
        assertFalse(user.equals(user1));
    }

    @Test
    public void testEquals8() {
        Role role = new Role();
        role.setId(123L);
        role.setName("janedoe");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setRecievedLikes(new ArrayList<Likes>());
        user.setActivationCode("janedoe");
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
        user.setSecondName("janedoe");
        user.setPuttedLikes(new ArrayList<Likes>());
        assertFalse(user.equals(new User(123L, "janedoe")));
    }

    @Test
    public void testEquals9() {
        User user = new User(123L, null);
        assertTrue(user.equals(new User()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-412212207, (new User(123L, "janedoe")).hashCode());
        assertEquals(-309967866, (new User(123L, null)).hashCode());
        assertEquals(1209710692, (new User("Jane", "Second Name", "Doe", "jane.doe@example.org", "4105551212")).hashCode());
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
        assertEquals(1654519438, user.hashCode());
    }

    @Test
    public void testHashCode3() {
        LocalDateTime timeOfAccountCreation = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime createdActivationCode = LocalDateTime.of(1, 1, 1, 1, 1);
        Role role = new Role();
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Likes> puttedLikes = new ArrayList<Likes>();
        ArrayList<Likes> recievedLikes = new ArrayList<Likes>();
        ArrayList<Comments> puttedComments = new ArrayList<Comments>();
        assertEquals(2035126334,
                (new User("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "iloveyou", "4105551212",
                        "Activation Code", timeOfAccountCreation, createdActivationCode, "https://example.org/example", role,
                        orders, puttedLikes, recievedLikes, puttedComments, new ArrayList<Comments>())).hashCode());
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
        assertEquals(117860341, user2.hashCode());
    }

    @Test
    public void testHashCode5() {
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

        Comments comments = new Comments();
        comments.setRating(0);
        comments.setId(123L);
        comments.setUser_to(user);
        comments.setCommentText(null);
        comments.setUser_from(user1);

        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        commentsList.add(comments);

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setRecievedLikes(new ArrayList<Likes>());
        user2.setActivationCode(null);
        user2.setPuttedComments(commentsList);
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
        assertEquals(820567156, user2.hashCode());
    }

//    @Test
//    public void testHashCode6() {
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
//        assertEquals(2034933634, user2.hashCode());
//    }

    @Test
    public void testHashCode7() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

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
        user.setRole(role1);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName(null);
        user.setPuttedLikes(new ArrayList<Likes>());

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

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
        user1.setRole(role2);
        user1.setPhoneNumber("4105551212");
        user1.setTimeOfAccountCreation(null);
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setFirstName("Jane");
        user1.setUsername("janedoe");
        user1.setRecievedComments(new ArrayList<Comments>());
        user1.setSecondName(null);
        user1.setPuttedLikes(new ArrayList<Likes>());

        Comments comments = new Comments();
        comments.setRating(0);
        comments.setId(123L);
        comments.setUser_to(user);
        comments.setCommentText(null);
        comments.setUser_from(user1);

        ArrayList<Comments> commentsList = new ArrayList<Comments>();
        commentsList.add(comments);

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setRecievedLikes(new ArrayList<Likes>());
        user2.setActivationCode(null);
        user2.setPuttedComments(new ArrayList<Comments>());
        user2.setCreatedActivationCode(null);
        user2.setId(123L);
        user2.setOrders(new ArrayList<Order>());
        user2.setRole(role);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(null);
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setUsername("janedoe");
        user2.setRecievedComments(commentsList);
        user2.setSecondName(null);
        user2.setPuttedLikes(new ArrayList<Likes>());
        assertEquals(330055648, user2.hashCode());
    }

    @Test
    public void testHashCode8() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);

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
        user.setRole(role1);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(null);
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setUsername("janedoe");
        user.setRecievedComments(new ArrayList<Comments>());
        user.setSecondName(null);
        user.setPuttedLikes(new ArrayList<Likes>());

        Role role2 = new Role();
        role2.setId(123L);
        role2.setName(null);

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
        user1.setRole(role2);
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

        User user2 = new User();
        user2.setLastName("Doe");
        user2.setEmail("jane.doe@example.org");
        user2.setPassword("iloveyou");
        user2.setRecievedLikes(new ArrayList<Likes>());
        user2.setActivationCode(null);
        user2.setPuttedComments(new ArrayList<Comments>());
        user2.setCreatedActivationCode(null);
        user2.setId(123L);
        user2.setOrders(new ArrayList<Order>());
        user2.setRole(role);
        user2.setPhoneNumber("4105551212");
        user2.setTimeOfAccountCreation(null);
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setFirstName("Jane");
        user2.setUsername("janedoe");
        user2.setRecievedComments(new ArrayList<Comments>());
        user2.setSecondName(null);
        user2.setPuttedLikes(likesList);
        assertEquals(1185945931, user2.hashCode());
    }
}

