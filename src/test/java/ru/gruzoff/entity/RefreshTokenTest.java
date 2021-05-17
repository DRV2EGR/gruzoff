package ru.gruzoff.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RefreshTokenTest {
    @Test
    public void testCanEqual() {
        assertFalse((new RefreshToken(123L, "ABC123")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        RefreshToken refreshToken = new RefreshToken(123L, "ABC123");

        RefreshToken refreshToken1 = new RefreshToken();
        refreshToken1.setRefreshToken("ABC123");
        refreshToken1.setUserId(123L);
        assertTrue(refreshToken.canEqual(refreshToken1));
    }

    @Test
    public void testConstructor() {
        RefreshToken actualRefreshToken = new RefreshToken();
        actualRefreshToken.setRefreshToken("ABC123");
        actualRefreshToken.setUserId(123L);
        assertEquals("ABC123", actualRefreshToken.getRefreshToken());
        assertEquals(123L, actualRefreshToken.getUserId());
        assertEquals("RefreshToken(userId=123, refreshToken=ABC123)", actualRefreshToken.toString());
    }

    @Test
    public void testConstructor2() {
        RefreshToken actualRefreshToken = new RefreshToken(123L, "ABC123");
        assertEquals("ABC123", actualRefreshToken.getRefreshToken());
        assertEquals(123L, actualRefreshToken.getUserId());
    }

    @Test
    public void testEquals() {
        assertFalse((new RefreshToken(123L, "ABC123")).equals("42"));
    }

    @Test
    public void testEquals2() {
        RefreshToken refreshToken = new RefreshToken(123L, "ABC123");

        RefreshToken refreshToken1 = new RefreshToken();
        refreshToken1.setRefreshToken("ABC123");
        refreshToken1.setUserId(123L);
        assertTrue(refreshToken.equals(refreshToken1));
    }

    @Test
    public void testEquals3() {
        RefreshToken refreshToken = new RefreshToken(123L, "ABC123");
        assertFalse(refreshToken.equals(new RefreshToken()));
    }

    @Test
    public void testEquals4() {
        RefreshToken refreshToken = new RefreshToken(123L, null);

        RefreshToken refreshToken1 = new RefreshToken();
        refreshToken1.setRefreshToken("ABC123");
        refreshToken1.setUserId(123L);
        assertFalse(refreshToken.equals(refreshToken1));
    }

    @Test
    public void testEquals5() {
        RefreshToken refreshToken = new RefreshToken(123L, "Refresh Token");

        RefreshToken refreshToken1 = new RefreshToken();
        refreshToken1.setRefreshToken("ABC123");
        refreshToken1.setUserId(123L);
        assertFalse(refreshToken.equals(refreshToken1));
    }

    @Test
    public void testEquals6() {
        RefreshToken refreshToken = new RefreshToken(123L, null);

        RefreshToken refreshToken1 = new RefreshToken();
        refreshToken1.setRefreshToken(null);
        refreshToken1.setUserId(123L);
        assertTrue(refreshToken.equals(refreshToken1));
    }

    @Test
    public void testHashCode() {
        assertEquals(1923902626, (new RefreshToken(123L, "ABC123")).hashCode());
        assertEquals(10781, (new RefreshToken(123L, null)).hashCode());
    }
}

