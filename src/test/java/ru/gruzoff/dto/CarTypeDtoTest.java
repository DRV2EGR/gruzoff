package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTypeDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        CarTypeDto carTypeDto = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertTrue(carTypeDto.canEqual(new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")));
    }

    @Test
    public void testConstructor() {
        CarTypeDto actualCarTypeDto = new CarTypeDto();
        actualCarTypeDto.setDescription("The characteristics of someone or something");
        actualCarTypeDto.setId(123L);
        actualCarTypeDto.setPricePerHour(10.0f);
        assertEquals("The characteristics of someone or something", actualCarTypeDto.getDescription());
        assertEquals(123L, actualCarTypeDto.getId());
        assertEquals(10.0f, actualCarTypeDto.getPricePerHour());
        assertEquals("CarTypeDto(id=123, pricePerHour=10.0, description=The characteristics of someone or something)",
                actualCarTypeDto.toString());
    }

    @Test
    public void testConstructor2() {
        CarTypeDto actualCarTypeDto = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", actualCarTypeDto.getDescription());
        assertEquals(10.0f, actualCarTypeDto.getPricePerHour());
        assertEquals(123L, actualCarTypeDto.getId());
    }

    @Test
    public void testEquals() {
        assertFalse((new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")).equals("42"));
    }

    @Test
    public void testEquals2() {
        CarTypeDto carTypeDto = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertTrue(carTypeDto.equals(new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")));
    }

    @Test
    public void testEquals3() {
        CarTypeDto carTypeDto = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carTypeDto.equals(new CarTypeDto()));
    }

    @Test
    public void testEquals4() {
        CarTypeDto carTypeDto = new CarTypeDto(123L, 0.5f, "The characteristics of someone or something");
        assertFalse(carTypeDto.equals(new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")));
    }

    @Test
    public void testEquals5() {
        CarTypeDto carTypeDto = new CarTypeDto(123L, 10.0f, null);
        assertFalse(carTypeDto.equals(new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")));
    }

    @Test
    public void testEquals6() {
        CarTypeDto carTypeDto = new CarTypeDto(123L, 10.0f, "Description");
        assertFalse(carTypeDto.equals(new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")));
    }

    @Test
    public void testEquals7() {
        CarTypeDto carTypeDto = new CarTypeDto();
        assertTrue(carTypeDto.equals(new CarTypeDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(1300057507, (new CarTypeDto(123L, 10.0f, "The characteristics of someone or something")).hashCode());
        assertEquals(40479473, (new CarTypeDto(123L, 10.0f, null)).hashCode());
    }
}

