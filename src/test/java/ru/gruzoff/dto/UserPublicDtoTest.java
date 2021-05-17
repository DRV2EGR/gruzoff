package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserPublicDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212"))
                .canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "4105551212");
        assertTrue(userPublicDto.canEqual(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testConstructor() {
        UserPublicDto actualUserPublicDto = new UserPublicDto();
        actualUserPublicDto.setEmail("jane.doe@example.org");
        actualUserPublicDto.setFirstName("Jane");
        actualUserPublicDto.setId(123L);
        actualUserPublicDto.setLastName("Doe");
        actualUserPublicDto.setPhoneNumber("4105551212");
        actualUserPublicDto.setSecondName("Second Name");
        actualUserPublicDto.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserPublicDto.getEmail());
        assertEquals("Jane", actualUserPublicDto.getFirstName());
        assertEquals(123L, actualUserPublicDto.getId());
        assertEquals("Doe", actualUserPublicDto.getLastName());
        assertEquals("4105551212", actualUserPublicDto.getPhoneNumber());
        assertEquals("Second Name", actualUserPublicDto.getSecondName());
        assertEquals("janedoe", actualUserPublicDto.getUsername());
        assertEquals("UserPublicDto(id=123, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe,"
                + " email=jane.doe@example.org, phoneNumber=4105551212)", actualUserPublicDto.toString());
    }

    @Test
    public void testConstructor2() {
        UserPublicDto actualUserPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "4105551212");
        assertEquals("jane.doe@example.org", actualUserPublicDto.getEmail());
        assertEquals("janedoe", actualUserPublicDto.getUsername());
        assertEquals("Second Name", actualUserPublicDto.getSecondName());
        assertEquals("4105551212", actualUserPublicDto.getPhoneNumber());
        assertEquals("Doe", actualUserPublicDto.getLastName());
        assertEquals(123L, actualUserPublicDto.getId());
        assertEquals("Jane", actualUserPublicDto.getFirstName());
    }

    @Test
    public void testEquals() {
        assertFalse((new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212"))
                .equals("42"));
    }

    @Test
    public void testEquals10() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "Jane", "jane.doe@example.org",
                "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals11() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", null, "jane.doe@example.org",
                "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals12() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "Jane",
                "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals13() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", null, "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals14() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "+44 1865 4960636");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals15() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", null);
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals16() {
        UserPublicDto userPublicDto = new UserPublicDto();
        assertTrue(userPublicDto.equals(new UserPublicDto()));
    }

    @Test
    public void testEquals2() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "4105551212");
        assertTrue(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals3() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "4105551212");
        assertFalse(userPublicDto.equals(new UserPublicDto()));
    }

    @Test
    public void testEquals4() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, null, "Second Name", "Doe", "janedoe", "jane.doe@example.org",
                "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals5() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Second Name", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals6() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Jane", "Doe", "janedoe", "jane.doe@example.org",
                "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals7() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", null, "Doe", "janedoe", "jane.doe@example.org",
                "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals8() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", "Jane", "janedoe",
                "jane.doe@example.org", "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testEquals9() {
        UserPublicDto userPublicDto = new UserPublicDto(123L, "Jane", "Second Name", null, "janedoe",
                "jane.doe@example.org", "4105551212");
        assertFalse(userPublicDto.equals(
                new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212")));
    }

    @Test
    public void testHashCode() {
        assertEquals(-915474781,
                (new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212"))
                        .hashCode());
        assertEquals(1811739426,
                (new UserPublicDto(123L, null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212"))
                        .hashCode());
        assertEquals(-620350761,
                (new UserPublicDto(123L, "Jane", null, "Doe", "janedoe", "jane.doe@example.org", "4105551212")).hashCode());
        assertEquals(2124666390,
                (new UserPublicDto(123L, "Jane", "Second Name", null, "janedoe", "jane.doe@example.org", "4105551212"))
                        .hashCode());
        assertEquals(-1507976982,
                (new UserPublicDto(123L, "Jane", "Second Name", "Doe", null, "jane.doe@example.org", "4105551212")).hashCode());
        assertEquals(899241486,
                (new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", null, "4105551212")).hashCode());
        assertEquals(-32157590,
                (new UserPublicDto(123L, "Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", null)).hashCode());
    }
}

