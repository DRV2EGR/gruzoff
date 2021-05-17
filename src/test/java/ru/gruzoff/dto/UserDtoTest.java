package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ru.gruzoff.entity.Role;
import ru.gruzoff.entity.User;

public class UserDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))
                .canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertTrue(userDto
                .canEqual(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testConstructor() {
        UserDto actualUserDto = new UserDto();
        actualUserDto.setEmail("jane.doe@example.org");
        actualUserDto.setFirstName("Jane");
        actualUserDto.setId(123L);
        actualUserDto.setLastName("Doe");
        actualUserDto.setPhoneNumber("4105551212");
        actualUserDto.setRole("Role");
        actualUserDto.setSecondName("Second Name");
        actualUserDto.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserDto.getEmail());
        assertEquals("Jane", actualUserDto.getFirstName());
        assertEquals(123L, actualUserDto.getId());
        assertEquals("Doe", actualUserDto.getLastName());
        assertEquals("4105551212", actualUserDto.getPhoneNumber());
        assertEquals("Role", actualUserDto.getRole());
        assertEquals("Second Name", actualUserDto.getSecondName());
        assertEquals("janedoe", actualUserDto.getUsername());
        assertEquals(
                "UserDto(id=123, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane.doe"
                        + "@example.org, phoneNumber=4105551212, role=Role)",
                actualUserDto.toString());
    }

    @Test
    public void testConstructor2() {
        UserDto actualUserDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        actualUserDto.setEmail("jane.doe@example.org");
        actualUserDto.setFirstName("Jane");
        actualUserDto.setId(123L);
        actualUserDto.setLastName("Doe");
        actualUserDto.setPhoneNumber("4105551212");
        actualUserDto.setRole("Role");
        actualUserDto.setSecondName("Second Name");
        actualUserDto.setUsername("janedoe");
        assertEquals("jane.doe@example.org", actualUserDto.getEmail());
        assertEquals("Jane", actualUserDto.getFirstName());
        assertEquals(123L, actualUserDto.getId());
        assertEquals("Doe", actualUserDto.getLastName());
        assertEquals("4105551212", actualUserDto.getPhoneNumber());
        assertEquals("Role", actualUserDto.getRole());
        assertEquals("Second Name", actualUserDto.getSecondName());
        assertEquals("janedoe", actualUserDto.getUsername());
        assertEquals(
                "UserDto(id=123, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane.doe"
                        + "@example.org, phoneNumber=4105551212, role=Role)",
                actualUserDto.toString());
    }

    @Test
    public void testConstructor3() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(123L, "janedoe");
        user.setRole(role);
        UserDto actualUserDto = new UserDto(user);
        assertNull(actualUserDto.getEmail());
        assertEquals("janedoe", actualUserDto.getUsername());
        assertNull(actualUserDto.getSecondName());
        assertEquals("Name", actualUserDto.getRole());
        assertNull(actualUserDto.getPhoneNumber());
        assertNull(actualUserDto.getLastName());
        assertNull(actualUserDto.getFirstName());
    }

    @Test
    public void testConstructor4() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(0L, "janedoe");
        user.setRole(role);
        UserDto actualUserDto = new UserDto(user);
        assertNull(actualUserDto.getEmail());
        assertEquals("janedoe", actualUserDto.getUsername());
        assertNull(actualUserDto.getSecondName());
        assertEquals("Name", actualUserDto.getRole());
        assertNull(actualUserDto.getPhoneNumber());
        assertNull(actualUserDto.getLastName());
        assertNull(actualUserDto.getFirstName());
    }

    @Test
    public void testEquals() {
        assertFalse((new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))
                .equals("42"));
    }

    @Test
    public void testEquals10() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", null, "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals11() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "Jane", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals12() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", null, "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals13() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "+44 1865 4960636",
                "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals14() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", null, "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals15() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Jane");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals16() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", null);
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals17() {
        UserDto userDto = new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto.equals(new UserDto()));
    }

    @Test
    public void testEquals18() {
        UserDto userDto = new UserDto();
        assertTrue(userDto.equals(new UserDto()));
    }

    @Test
    public void testEquals2() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertTrue(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals3() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertFalse(userDto.equals(new UserDto()));
    }

    @Test
    public void testEquals4() {
        UserDto userDto = new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals5() {
        UserDto userDto = new UserDto("Jane", "Jane", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals6() {
        UserDto userDto = new UserDto("Jane", null, "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals7() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Jane", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals8() {
        UserDto userDto = new UserDto("Jane", "Second Name", null, "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals9() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "Jane", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testHashCode() {
        assertEquals(10668934,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))
                        .hashCode());
        assertEquals(2002517195,
                (new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(243116930,
                (new UserDto("Jane", null, "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(-1009628409,
                (new UserDto("Jane", "Second Name", null, "janedoe", "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(-587222557,
                (new UserDto("Jane", "Second Name", "Doe", null, "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(-295253713,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", null, "4105551212", "Role")).hashCode());
        assertEquals(586775651,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", null, "Role")).hashCode());
        assertEquals(8115995,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", null)).hashCode());
    }
}

