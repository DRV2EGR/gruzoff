package ru.gruzoff.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserDtoPayloadTest {
    @Test
    public void testCanEqual() {
        assertFalse((new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "iloveyou",
                "4105551212", "https://example.org/example")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertTrue(userDtoPayload.canEqual(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testConstructor() {
        UserDtoPayload actualUserDtoPayload = new UserDtoPayload();
        actualUserDtoPayload.setEmail("jane.doe@example.org");
        actualUserDtoPayload.setFirstName("Jane");
        actualUserDtoPayload.setLastName("Doe");
        actualUserDtoPayload.setPassword("iloveyou");
        actualUserDtoPayload.setPhoneNumber("4105551212");
        actualUserDtoPayload.setSecondName("Second Name");
        actualUserDtoPayload.setUserProfileImageUrl("https://example.org/example");
        actualUserDtoPayload.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserDtoPayload.getEmail());
        assertEquals("Jane", actualUserDtoPayload.getFirstName());
        assertEquals("Doe", actualUserDtoPayload.getLastName());
        assertEquals("iloveyou", actualUserDtoPayload.getPassword());
        assertEquals("4105551212", actualUserDtoPayload.getPhoneNumber());
        assertEquals("Second Name", actualUserDtoPayload.getSecondName());
        assertEquals("https://example.org/example", actualUserDtoPayload.getUserProfileImageUrl());
        assertEquals("janedoe", actualUserDtoPayload.getUsername());
        assertEquals("UserDtoPayload(firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane"
                + ".doe@example.org, password=iloveyou, phoneNumber=4105551212, userProfileImageUrl=https://example.org"
                + "/example)", actualUserDtoPayload.toString());
    }

    @Test
    public void testConstructor2() {
        UserDtoPayload actualUserDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example");
        actualUserDtoPayload.setEmail("jane.doe@example.org");
        actualUserDtoPayload.setFirstName("Jane");
        actualUserDtoPayload.setLastName("Doe");
        actualUserDtoPayload.setPassword("iloveyou");
        actualUserDtoPayload.setPhoneNumber("4105551212");
        actualUserDtoPayload.setSecondName("Second Name");
        actualUserDtoPayload.setUserProfileImageUrl("https://example.org/example");
        actualUserDtoPayload.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserDtoPayload.getEmail());
        assertEquals("Jane", actualUserDtoPayload.getFirstName());
        assertEquals("Doe", actualUserDtoPayload.getLastName());
        assertEquals("iloveyou", actualUserDtoPayload.getPassword());
        assertEquals("4105551212", actualUserDtoPayload.getPhoneNumber());
        assertEquals("Second Name", actualUserDtoPayload.getSecondName());
        assertEquals("https://example.org/example", actualUserDtoPayload.getUserProfileImageUrl());
        assertEquals("janedoe", actualUserDtoPayload.getUsername());
        assertEquals("UserDtoPayload(firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane"
                + ".doe@example.org, password=iloveyou, phoneNumber=4105551212, userProfileImageUrl=https://example.org"
                + "/example)", actualUserDtoPayload.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "iloveyou",
                "4105551212", "https://example.org/example")).equals("42"));
    }

    @Test
    public void testEquals10() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", null, "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals11() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "Jane", "iloveyou",
                "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals12() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", null, "iloveyou",
                "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals13() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "Jane", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals14() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                null, "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals15() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "+44 1865 4960636", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals16() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", null, "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals17() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "Jane");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals18() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", null);
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals19() {
        UserDtoPayload userDtoPayload = new UserDtoPayload(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload()));
    }

    @Test
    public void testEquals2() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertTrue(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals20() {
        UserDtoPayload userDtoPayload = new UserDtoPayload();
        assertTrue(userDtoPayload.equals(new UserDtoPayload()));
    }

    @Test
    public void testEquals3() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload()));
    }

    @Test
    public void testEquals4() {
        UserDtoPayload userDtoPayload = new UserDtoPayload(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals5() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Jane", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals6() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", null, "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals7() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Jane", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals8() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", null, "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testEquals9() {
        UserDtoPayload userDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "Jane", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example");
        assertFalse(userDtoPayload.equals(new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example")));
    }

    @Test
    public void testHashCode() {
        assertEquals(1610440046, (new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example")).hashCode());
        assertEquals(-1129596843, (new UserDtoPayload(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example")).hashCode());
        assertEquals(-1854997374, (new UserDtoPayload("Jane", null, "Doe", "janedoe", "jane.doe@example.org", "iloveyou",
                "4105551212", "https://example.org/example")).hashCode());
        assertEquals(1542438953, (new UserDtoPayload("Jane", "Second Name", null, "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", "https://example.org/example")).hashCode());
        assertEquals(694580445, (new UserDtoPayload("Jane", "Second Name", "Doe", null, "jane.doe@example.org", "iloveyou",
                "4105551212", "https://example.org/example")).hashCode());
        assertEquals(740873057, (new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", null, "iloveyou", "4105551212",
                "https://example.org/example")).hashCode());
        assertEquals(1195906013, (new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", null,
                "4105551212", "https://example.org/example")).hashCode());
        assertEquals(-2108420533, (new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", null, "https://example.org/example")).hashCode());
        assertEquals(-1199497715, (new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "iloveyou", "4105551212", null)).hashCode());
    }
}

