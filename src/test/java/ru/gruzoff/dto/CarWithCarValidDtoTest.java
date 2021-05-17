package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarWithCarValidDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new CarWithCarValidDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto();
        assertTrue(carWithCarValidDto.canEqual(new CarWithCarValidDto()));
    }

    @Test
    public void testConstructor() {
        CarWithCarValidDto actualCarWithCarValidDto = new CarWithCarValidDto();
        actualCarWithCarValidDto.setGosNomber("Gos Nomber");
        actualCarWithCarValidDto.setHeight(1);
        actualCarWithCarValidDto.setLength(3);
        actualCarWithCarValidDto.setMaxPeopleCapacity(3);
        actualCarWithCarValidDto.setMax_weight(3);
        actualCarWithCarValidDto.setSize(3);
        CarTypeDto carTypeDto = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        actualCarWithCarValidDto.setType(carTypeDto);
        CarValidityDto carValidityDto = new CarValidityDto(true, "Just cause");
        actualCarWithCarValidDto.setValidity(carValidityDto);
        actualCarWithCarValidDto.setWidth(1);
        assertEquals("Gos Nomber", actualCarWithCarValidDto.getGosNomber());
        assertEquals(1, actualCarWithCarValidDto.getHeight());
        assertEquals(3, actualCarWithCarValidDto.getLength());
        assertEquals(3, actualCarWithCarValidDto.getMaxPeopleCapacity());
        assertEquals(3, actualCarWithCarValidDto.getMax_weight());
        assertEquals(3, actualCarWithCarValidDto.getSize());
        assertSame(carTypeDto, actualCarWithCarValidDto.getType());
        assertSame(carValidityDto, actualCarWithCarValidDto.getValidity());
        assertEquals(1, actualCarWithCarValidDto.getWidth());
        assertEquals(
                "CarWithCarValidDto(max_weight=3, length=3, width=1, height=1, size=3, maxPeopleCapacity=3, type"
                        + "=CarTypeDto(id=123, pricePerHour=10.0, description=The characteristics of someone or something),"
                        + " gosNomber=Gos Nomber, validity=CarValidityDto(isValid=true, reasonOfCrash=Just cause))",
                actualCarWithCarValidDto.toString());
    }

    @Test
    public void testConstructor2() {
        CarTypeDto carTypeDto = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        CarValidityDto carValidityDto = new CarValidityDto(true, "Just cause");
        CarWithCarValidDto actualCarWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3, carTypeDto, "Gos Nomber",
                carValidityDto);
        actualCarWithCarValidDto.setGosNomber("Gos Nomber");
        actualCarWithCarValidDto.setHeight(1);
        actualCarWithCarValidDto.setLength(3);
        actualCarWithCarValidDto.setMaxPeopleCapacity(3);
        actualCarWithCarValidDto.setMax_weight(3);
        actualCarWithCarValidDto.setSize(3);
        CarTypeDto carTypeDto1 = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        actualCarWithCarValidDto.setType(carTypeDto1);
        CarValidityDto carValidityDto1 = new CarValidityDto(true, "Just cause");
        actualCarWithCarValidDto.setValidity(carValidityDto1);
        actualCarWithCarValidDto.setWidth(1);
        assertEquals("Gos Nomber", actualCarWithCarValidDto.getGosNomber());
        assertEquals(1, actualCarWithCarValidDto.getHeight());
        assertEquals(3, actualCarWithCarValidDto.getLength());
        assertEquals(3, actualCarWithCarValidDto.getMaxPeopleCapacity());
        assertEquals(3, actualCarWithCarValidDto.getMax_weight());
        assertEquals(3, actualCarWithCarValidDto.getSize());
        CarTypeDto type = actualCarWithCarValidDto.getType();
        assertEquals(carTypeDto, type);
        assertSame(carTypeDto1, type);
        CarValidityDto validity = actualCarWithCarValidDto.getValidity();
        assertEquals(carValidityDto, validity);
        assertSame(carValidityDto1, validity);
        assertEquals(1, actualCarWithCarValidDto.getWidth());
        assertEquals(
                "CarWithCarValidDto(max_weight=3, length=3, width=1, height=1, size=3, maxPeopleCapacity=3, type"
                        + "=CarTypeDto(id=123, pricePerHour=10.0, description=The characteristics of someone or something),"
                        + " gosNomber=Gos Nomber, validity=CarValidityDto(isValid=true, reasonOfCrash=Just cause))",
                actualCarWithCarValidDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new CarWithCarValidDto()).equals("42"));
    }

    @Test
    public void testEquals10() {
        CarTypeDto type = new CarTypeDto(0L, 10.0f, "The characteristics of someone or something");
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber",
                new CarValidityDto(true, "Just cause"));
        CarTypeDto type1 = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type1, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals11() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3, null, "Gos Nomber",
                new CarValidityDto(true, "Just cause"));
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals12() {
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type,
                "The characteristics of someone or something", new CarValidityDto(true, "Just cause"));
        CarTypeDto type1 = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type1, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals13() {
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, null,
                new CarValidityDto(true, "Just cause"));
        CarTypeDto type1 = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type1, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals14() {
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber",
                new CarValidityDto(false, "Just cause"));
        CarTypeDto type1 = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type1, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals15() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3,
                new CarTypeDto(123L, 10.0f, "The characteristics of someone or something"), "Gos Nomber", null);
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals2() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto();
        assertTrue(carWithCarValidDto.equals(new CarWithCarValidDto()));
    }

    @Test
    public void testEquals3() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto();
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals4() {
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber",
                new CarValidityDto(true, "Just cause"));
        CarTypeDto type1 = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertTrue(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type1, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals5() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto();
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(0, 3, 1, 1, 3, 3, type, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testEquals6() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto();
        carWithCarValidDto.setMaxPeopleCapacity(3);
        assertFalse(carWithCarValidDto.equals(new CarWithCarValidDto()));
    }

    @Test
    public void testEquals7() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto();
        carWithCarValidDto.setSize(3);
        assertFalse(carWithCarValidDto.equals(new CarWithCarValidDto()));
    }

    @Test
    public void testEquals8() {
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto();
        carWithCarValidDto.setWidth(1);
        assertFalse(carWithCarValidDto.equals(new CarWithCarValidDto()));
    }

    @Test
    public void testEquals9() {
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        CarWithCarValidDto carWithCarValidDto = new CarWithCarValidDto(3, 3, 1, 0, 3, 3, type, "Gos Nomber",
                new CarValidityDto(true, "Just cause"));
        CarTypeDto type1 = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertFalse(carWithCarValidDto
                .equals(new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type1, "Gos Nomber", new CarValidityDto(true, "Just cause"))));
    }

    @Test
    public void testHashCode() {
        assertEquals(-461865054, (new CarWithCarValidDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertEquals(-940770595,
                (new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber", new CarValidityDto(true, "Just cause")))
                        .hashCode());
    }

    @Test
    public void testHashCode3() {
        CarTypeDto type = new CarTypeDto(123L, 10.0f, "The characteristics of someone or something");
        assertEquals(-940769533,
                (new CarWithCarValidDto(3, 3, 1, 1, 3, 3, type, "Gos Nomber", new CarValidityDto(false, "Just cause")))
                        .hashCode());
    }
}

