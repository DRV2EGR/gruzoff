package ru.gruzoff.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTypeTest {
    @Test
    public void testCanEqual() {
        assertFalse((new CarType(10.0f, "The characteristics of someone or something")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        CarType carType = new CarType(10.0f, "The characteristics of someone or something");

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        assertTrue(carType.canEqual(carType1));
    }

    @Test
    public void testConstructor() {
        CarType actualCarType = new CarType();
        actualCarType.setDescription("The characteristics of someone or something");
        actualCarType.setPricePerHour(10.0f);
        assertEquals("The characteristics of someone or something", actualCarType.getDescription());
        assertEquals(10.0f, actualCarType.getPricePerHour());
        assertEquals("CarType(pricePerHour=10.0, description=The characteristics of someone or something)",
                actualCarType.toString());
    }

    @Test
    public void testConstructor2() {
        CarType actualCarType = new CarType(10.0f, "The characteristics of someone or something");
        actualCarType.setDescription("The characteristics of someone or something");
        actualCarType.setPricePerHour(10.0f);
        assertEquals("The characteristics of someone or something", actualCarType.getDescription());
        assertEquals(10.0f, actualCarType.getPricePerHour());
        assertEquals("CarType(pricePerHour=10.0, description=The characteristics of someone or something)",
                actualCarType.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new CarType(10.0f, "The characteristics of someone or something")).equals("42"));
    }

    @Test
    public void testEquals2() {
        CarType carType = new CarType(10.0f, "The characteristics of someone or something");

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        assertTrue(carType.equals(carType1));
    }

    @Test
    public void testEquals3() {
        CarType carType = new CarType(10.0f, "The characteristics of someone or something");
        assertFalse(carType.equals(new CarType()));
    }

    @Test
    public void testEquals4() {
        CarType carType = new CarType(10.0f, null);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        assertFalse(carType.equals(carType1));
    }

    @Test
    public void testEquals5() {
        CarType carType = new CarType(10.0f, "Description");

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        assertFalse(carType.equals(carType1));
    }

    @Test
    public void testEquals6() {
        CarType carType = new CarType(10.0f, null);

        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription(null);
        assertTrue(carType.equals(carType1));
    }

    @Test
    public void testHashCode() {
        assertEquals(1299427446, (new CarType(10.0f, "The characteristics of someone or something")).hashCode());
        assertEquals(39849412, (new CarType(10.0f, null)).hashCode());
    }
}

