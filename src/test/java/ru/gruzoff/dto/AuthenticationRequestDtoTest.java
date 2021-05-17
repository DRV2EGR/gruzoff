package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AuthenticationRequestDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new AuthenticationRequestDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        assertTrue(authenticationRequestDto.canEqual(new AuthenticationRequestDto()));
    }

    @Test
    public void testConstructor() {
        AuthenticationRequestDto actualAuthenticationRequestDto = new AuthenticationRequestDto();
        actualAuthenticationRequestDto.setEmail("jane.doe@example.org");
        actualAuthenticationRequestDto.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualAuthenticationRequestDto.getEmail());
        assertEquals("iloveyou", actualAuthenticationRequestDto.getPassword());
        assertEquals("AuthenticationRequestDto(email=jane.doe@example.org, password=iloveyou)",
                actualAuthenticationRequestDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new AuthenticationRequestDto()).equals("42"));
    }

    @Test
    public void testEquals2() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        assertTrue(authenticationRequestDto.equals(new AuthenticationRequestDto()));
    }

    @Test
    public void testEquals3() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        assertFalse(authenticationRequestDto.equals(new AuthenticationRequestDto()));
    }

    @Test
    public void testEquals4() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setPassword("iloveyou");
        assertFalse(authenticationRequestDto.equals(new AuthenticationRequestDto()));
    }

    @Test
    public void testEquals5() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();

        AuthenticationRequestDto authenticationRequestDto1 = new AuthenticationRequestDto();
        authenticationRequestDto1.setEmail("jane.doe@example.org");
        assertFalse(authenticationRequestDto.equals(authenticationRequestDto1));
    }

    @Test
    public void testEquals6() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();

        AuthenticationRequestDto authenticationRequestDto1 = new AuthenticationRequestDto();
        authenticationRequestDto1.setPassword("iloveyou");
        assertFalse(authenticationRequestDto.equals(authenticationRequestDto1));
    }

    @Test
    public void testEquals7() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");

        AuthenticationRequestDto authenticationRequestDto1 = new AuthenticationRequestDto();
        authenticationRequestDto1.setEmail("jane.doe@example.org");
        assertTrue(authenticationRequestDto.equals(authenticationRequestDto1));
    }

    @Test
    public void testEquals8() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setPassword("iloveyou");

        AuthenticationRequestDto authenticationRequestDto1 = new AuthenticationRequestDto();
        authenticationRequestDto1.setPassword("iloveyou");
        assertTrue(authenticationRequestDto.equals(authenticationRequestDto1));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new AuthenticationRequestDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        assertEquals(-1814710206, authenticationRequestDto.hashCode());
    }

    @Test
    public void testHashCode3() {
        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setPassword("iloveyou");
        assertEquals(-1332412826, authenticationRequestDto.hashCode());
    }
}

