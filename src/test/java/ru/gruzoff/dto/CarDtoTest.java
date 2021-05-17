package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        assertTrue(carDto.canEqual(new CarDto()));
    }

    @Test
    public void testConstructor() {
        CarDto actualCarDto = new CarDto();
        actualCarDto.setGosNomber("Gos Nomber");
        actualCarDto.setHeight(1);
        actualCarDto.setLength(3);
        actualCarDto.setMaxPeopleCapacity(3);
        actualCarDto.setMax_weight(3);
        actualCarDto.setSize(3);
        actualCarDto.setType(1);
        actualCarDto.setWidth(1);
        assertEquals("Gos Nomber", actualCarDto.getGosNomber());
        assertEquals(1, actualCarDto.getHeight());
        assertEquals(3, actualCarDto.getLength());
        assertEquals(3, actualCarDto.getMaxPeopleCapacity());
        assertEquals(3, actualCarDto.getMax_weight());
        assertEquals(3, actualCarDto.getSize());
        assertEquals(1, actualCarDto.getType());
        assertEquals(1, actualCarDto.getWidth());
        assertEquals("CarDto(max_weight=3, length=3, width=1, height=1, size=3, maxPeopleCapacity=3, type=1, gosNomber=Gos"
                + " Nomber)", actualCarDto.toString());
    }

    @Test
    public void testConstructor2() {
        CarDto actualCarDto = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        actualCarDto.setGosNomber("Gos Nomber");
        actualCarDto.setHeight(1);
        actualCarDto.setLength(3);
        actualCarDto.setMaxPeopleCapacity(3);
        actualCarDto.setMax_weight(3);
        actualCarDto.setSize(3);
        actualCarDto.setType(1);
        actualCarDto.setWidth(1);
        assertEquals("Gos Nomber", actualCarDto.getGosNomber());
        assertEquals(1, actualCarDto.getHeight());
        assertEquals(3, actualCarDto.getLength());
        assertEquals(3, actualCarDto.getMaxPeopleCapacity());
        assertEquals(3, actualCarDto.getMax_weight());
        assertEquals(3, actualCarDto.getSize());
        assertEquals(1, actualCarDto.getType());
        assertEquals(1, actualCarDto.getWidth());
        assertEquals("CarDto(max_weight=3, length=3, width=1, height=1, size=3, maxPeopleCapacity=3, type=1, gosNomber=Gos"
                + " Nomber)", actualCarDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")).equals("42"));
    }

    @Test
    public void testEquals10() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 3, 1, null);
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals11() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 3, 1, "ru.gruzoff.dto.CarDto");
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals12() {
        CarDto carDto = new CarDto();
        assertTrue(carDto.equals(new CarDto()));
    }

    @Test
    public void testEquals2() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        assertTrue(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals3() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber");
        assertFalse(carDto.equals(new CarDto()));
    }

    @Test
    public void testEquals4() {
        CarDto carDto = new CarDto(3, 0, 1, 1, 3, 3, 1, "Gos Nomber");
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals5() {
        CarDto carDto = new CarDto(3, 3, 0, 1, 3, 3, 1, "Gos Nomber");
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals6() {
        CarDto carDto = new CarDto(3, 3, 1, 0, 3, 3, 1, "Gos Nomber");
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals7() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 0, 3, 1, "Gos Nomber");
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals8() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 0, 1, "Gos Nomber");
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testEquals9() {
        CarDto carDto = new CarDto(3, 3, 1, 1, 3, 3, 0, "Gos Nomber");
        assertFalse(carDto.equals(new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")));
    }

    @Test
    public void testHashCode() {
        assertEquals(1809629752, (new CarDto(3, 3, 1, 1, 3, 3, 1, "Gos Nomber")).hashCode());
        assertEquals(-1887799637, (new CarDto(3, 3, 1, 1, 3, 3, 1, null)).hashCode());
    }
}

