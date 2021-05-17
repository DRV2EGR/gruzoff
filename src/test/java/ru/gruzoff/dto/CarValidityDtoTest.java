package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarValidityDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new CarValidityDto(true, "Just cause")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        CarValidityDto carValidityDto = new CarValidityDto(true, "Just cause");
        assertTrue(carValidityDto.canEqual(new CarValidityDto(true, "Just cause")));
    }

    @Test
    public void testConstructor() {
        CarValidityDto actualCarValidityDto = new CarValidityDto();
        actualCarValidityDto.setReasonOfCrash("Just cause");
        actualCarValidityDto.setValid(true);
        assertEquals("Just cause", actualCarValidityDto.getReasonOfCrash());
        assertTrue(actualCarValidityDto.isValid());
        assertEquals("CarValidityDto(isValid=true, reasonOfCrash=Just cause)", actualCarValidityDto.toString());
    }

    @Test
    public void testConstructor2() {
        CarValidityDto actualCarValidityDto = new CarValidityDto(true, "Just cause");
        actualCarValidityDto.setReasonOfCrash("Just cause");
        actualCarValidityDto.setValid(true);
        assertEquals("Just cause", actualCarValidityDto.getReasonOfCrash());
        assertTrue(actualCarValidityDto.isValid());
        assertEquals("CarValidityDto(isValid=true, reasonOfCrash=Just cause)", actualCarValidityDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new CarValidityDto(true, "Just cause")).equals("42"));
    }

    @Test
    public void testEquals2() {
        CarValidityDto carValidityDto = new CarValidityDto(true, "Just cause");
        assertTrue(carValidityDto.equals(new CarValidityDto(true, "Just cause")));
    }

    @Test
    public void testEquals3() {
        CarValidityDto carValidityDto = new CarValidityDto(true, "Just cause");
        assertFalse(carValidityDto.equals(new CarValidityDto()));
    }

    @Test
    public void testEquals4() {
        CarValidityDto carValidityDto = new CarValidityDto(true, null);
        assertFalse(carValidityDto.equals(new CarValidityDto(true, "Just cause")));
    }

    @Test
    public void testEquals5() {
        CarValidityDto carValidityDto = new CarValidityDto(true, "Reason Of Crash");
        assertFalse(carValidityDto.equals(new CarValidityDto(true, "Just cause")));
    }

    @Test
    public void testEquals6() {
        CarValidityDto carValidityDto = new CarValidityDto();
        assertTrue(carValidityDto.equals(new CarValidityDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(1060608035, (new CarValidityDto(true, "Just cause")).hashCode());
        assertEquals(1060609097, (new CarValidityDto(false, "Just cause")).hashCode());
        assertEquals(8185, (new CarValidityDto(true, null)).hashCode());
    }
}

