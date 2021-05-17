package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LikeDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new LikeDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        LikeDto likeDto = new LikeDto();
        assertTrue(likeDto.canEqual(new LikeDto()));
    }

    @Test
    public void testConstructor() {
        LikeDto actualLikeDto = new LikeDto();
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        actualLikeDto.setUser_from(userDto);
        UserDto userDto1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        actualLikeDto.setUser_to(userDto1);
        UserDto user_from = actualLikeDto.getUser_from();
        assertEquals(userDto1, user_from);
        assertSame(userDto, user_from);
        UserDto user_to = actualLikeDto.getUser_to();
        assertSame(userDto1, user_to);
        assertEquals(user_from, user_to);
        assertEquals(
                "LikeDto(user_from=UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe,"
                        + " email=jane.doe@example.org, phoneNumber=4105551212, role=Role), user_to=UserDto(id=0, firstName=Jane,"
                        + " secondName=Second Name, lastName=Doe, username=janedoe, email=jane.doe@example.org, phoneNumber=4105551212,"
                        + " role=Role))",
                actualLikeDto.toString());
    }

    @Test
    public void testConstructor2() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        UserDto userDto1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        LikeDto actualLikeDto = new LikeDto(userDto, userDto1);
        UserDto userDto2 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        actualLikeDto.setUser_from(userDto2);
        UserDto userDto3 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        actualLikeDto.setUser_to(userDto3);
        UserDto user_from = actualLikeDto.getUser_from();
        assertEquals(userDto, user_from);
        assertSame(userDto2, user_from);
        assertEquals(userDto3, user_from);
        assertEquals(userDto1, user_from);
        UserDto user_to = actualLikeDto.getUser_to();
        assertEquals(user_from, user_to);
        assertEquals(userDto, user_to);
        assertSame(userDto3, user_to);
        assertEquals(userDto1, user_to);
        assertEquals(
                "LikeDto(user_from=UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe,"
                        + " email=jane.doe@example.org, phoneNumber=4105551212, role=Role), user_to=UserDto(id=0, firstName=Jane,"
                        + " secondName=Second Name, lastName=Doe, username=janedoe, email=jane.doe@example.org, phoneNumber=4105551212,"
                        + " role=Role))",
                actualLikeDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new LikeDto()).equals("42"));
    }

    @Test
    public void testEquals2() {
        LikeDto likeDto = new LikeDto();
        assertTrue(likeDto.equals(new LikeDto()));
    }

    @Test
    public void testEquals3() {
        LikeDto likeDto = new LikeDto();
        UserDto user_from = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertFalse(likeDto.equals(new LikeDto(user_from,
                new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))));
    }

    @Test
    public void testEquals4() {
        UserDto user_from = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        LikeDto likeDto = new LikeDto(user_from,
                new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));
        assertFalse(likeDto.equals(new LikeDto()));
    }

    @Test
    public void testEquals5() {
        UserDto user_from = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        LikeDto likeDto = new LikeDto(user_from,
                new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));
        UserDto user_from1 = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertTrue(likeDto.equals(new LikeDto(user_from1,
                new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))));
    }

    @Test
    public void testEquals6() {
        LikeDto likeDto = new LikeDto();
        assertFalse(likeDto.equals(new LikeDto(null,
                new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))));
    }

    @Test
    public void testEquals7() {
        LikeDto likeDto = new LikeDto(null,
                new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"));
        assertFalse(likeDto.equals(new LikeDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new LikeDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        UserDto user_from = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertEquals(640139521,
                (new LikeDto(user_from,
                        new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")))
                        .hashCode());
    }
}

