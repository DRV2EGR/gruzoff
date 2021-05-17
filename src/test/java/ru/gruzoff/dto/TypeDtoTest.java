package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TypeDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new TypeDto(123L)).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        TypeDto typeDto = new TypeDto(123L);
        assertTrue(typeDto.canEqual(new TypeDto(123L)));
    }

    @Test
    public void testConstructor() {
        TypeDto actualTypeDto = new TypeDto();
        actualTypeDto.setId(123L);
        assertEquals(123L, actualTypeDto.getId());
        assertEquals("TypeDto(id=123)", actualTypeDto.toString());
    }

    @Test
    public void testConstructor2() {
        TypeDto actualTypeDto = new TypeDto(123L);
        actualTypeDto.setId(123L);
        assertEquals(123L, actualTypeDto.getId());
        assertEquals("TypeDto(id=123)", actualTypeDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new TypeDto(123L)).equals("42"));
    }

    @Test
    public void testEquals2() {
        TypeDto typeDto = new TypeDto(123L);
        assertTrue(typeDto.equals(new TypeDto(123L)));
    }

    @Test
    public void testEquals3() {
        TypeDto typeDto = new TypeDto(123L);
        assertFalse(typeDto.equals(new TypeDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(182, (new TypeDto(123L)).hashCode());
    }
}

