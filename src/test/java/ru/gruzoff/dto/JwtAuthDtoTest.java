package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class JwtAuthDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new JwtAuthDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        assertTrue(jwtAuthDto.canEqual(new JwtAuthDto()));
    }

    @Test
    public void testConstructor() {
        JwtAuthDto actualJwtAuthDto = new JwtAuthDto();
        actualJwtAuthDto.setAccessToken("ABC123");
        actualJwtAuthDto.setRefreshToken("ABC123");
        actualJwtAuthDto.setUsername("janedoe");
        assertEquals("ABC123", actualJwtAuthDto.getAccessToken());
        assertEquals("ABC123", actualJwtAuthDto.getRefreshToken());
        assertEquals("janedoe", actualJwtAuthDto.getUsername());
        assertEquals("JwtAuthDto(username=janedoe, accessToken=ABC123, refreshToken=ABC123)", actualJwtAuthDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new JwtAuthDto()).equals("42"));
    }

    @Test
    public void testEquals10() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setAccessToken("ABC123");

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setAccessToken("ABC123");
        assertTrue(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testEquals11() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setUsername("janedoe");

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setUsername("janedoe");
        assertTrue(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testEquals2() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        assertTrue(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals3() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");
        assertFalse(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals4() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setAccessToken("ABC123");
        assertFalse(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals5() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setUsername("janedoe");
        assertFalse(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals6() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setRefreshToken("ABC123");
        assertFalse(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testEquals7() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setAccessToken("ABC123");
        assertFalse(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testEquals8() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setUsername("janedoe");
        assertFalse(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testEquals9() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setRefreshToken("ABC123");
        assertTrue(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testHashCode() {
        assertEquals(357642, (new JwtAuthDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");
        assertEquals(1924249487, jwtAuthDto.hashCode());
    }

    @Test
    public void testHashCode3() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setAccessToken("ABC123");
        assertEquals(1840826801, jwtAuthDto.hashCode());
    }

    @Test
    public void testHashCode4() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setUsername("janedoe");
        assertEquals(592859843, jwtAuthDto.hashCode());
    }
}

