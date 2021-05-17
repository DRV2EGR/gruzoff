package ru.gruzoff.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Car()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Car car = new Car();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertTrue(car.canEqual(car1));
    }

    @Test
    public void testConstructor() {
        Car actualCar = new Car();
        actualCar.setGosNomber("Gos Nomber");
        actualCar.setHeight(1);
        actualCar.setLength(3);
        actualCar.setMaxPeopleCapacity(3);
        actualCar.setMax_weight(3);
        actualCar.setSize(3);
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");
        actualCar.setType(carType);
        actualCar.setWidth(1);
        assertEquals("Gos Nomber", actualCar.getGosNomber());
        assertEquals(1, actualCar.getHeight());
        assertEquals(3, actualCar.getLength());
        assertEquals(3, actualCar.getMaxPeopleCapacity());
        assertEquals(3, actualCar.getMax_weight());
        assertEquals(3, actualCar.getSize());
        assertSame(carType, actualCar.getType());
        assertEquals(1, actualCar.getWidth());
        assertEquals(
                "Car(max_weight=3, length=3, width=1, height=1, size=3, maxPeopleCapacity=3, type=CarType(pricePerHour=10.0,"
                        + " description=The characteristics of someone or something), gosNomber=Gos Nomber)",
                actualCar.toString());
    }

    @Test
    public void testConstructor2() {
        CarType carType = new CarType(10.0f, "The characteristics of someone or something");
        Car actualCar = new Car(3, 3, 1, 1, 3, 3, carType, "Gos Nomber");
        actualCar.setGosNomber("Gos Nomber");
        actualCar.setHeight(1);
        actualCar.setLength(3);
        actualCar.setMaxPeopleCapacity(3);
        actualCar.setMax_weight(3);
        actualCar.setSize(3);
        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        actualCar.setType(carType1);
        actualCar.setWidth(1);
        assertEquals("Gos Nomber", actualCar.getGosNomber());
        assertEquals(1, actualCar.getHeight());
        assertEquals(3, actualCar.getLength());
        assertEquals(3, actualCar.getMaxPeopleCapacity());
        assertEquals(3, actualCar.getMax_weight());
        assertEquals(3, actualCar.getSize());
        CarType type = actualCar.getType();
        assertSame(carType1, type);
        assertEquals(carType, type);
        assertEquals(1, actualCar.getWidth());
        assertEquals(
                "Car(max_weight=3, length=3, width=1, height=1, size=3, maxPeopleCapacity=3, type=CarType(pricePerHour=10.0,"
                        + " description=The characteristics of someone or something), gosNomber=Gos Nomber)",
                actualCar.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Car()).equals("42"));
    }

    @Test
    public void testEquals10() {
        Car car = new Car();
        car.setSize(3);
        assertFalse(car.equals(new Car()));
    }

    @Test
    public void testEquals11() {
        Car car = new Car();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setType(carType);
        assertFalse(car.equals(car1));
    }

    @Test
    public void testEquals12() {
        Car car = new Car(3, 3, 1, 0, 3, 3, new CarType(10.0f, "The characteristics of someone or something"),
                "The characteristics of someone or something");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertFalse(car.equals(car1));
    }

    @Test
    public void testEquals13() {
        Car car = new Car(3, 3, 1, 0, 3, 3, new CarType(10.0f, "The characteristics of someone or something"), null);

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertFalse(car.equals(car1));
    }

    @Test
    public void testEquals2() {
        Car car = new Car();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertFalse(car.equals(car1));
    }

    @Test
    public void testEquals3() {
        Car car = new Car();
        assertTrue(car.equals(new Car()));
    }

    @Test
    public void testEquals4() {
        Car car = new Car(3, 3, 1, 1, 3, 3, new CarType(10.0f, "The characteristics of someone or something"),
                "Gos Nomber");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertFalse(car.equals(car1));
    }

    @Test
    public void testEquals5() {
        Car car = new Car();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(0);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertFalse(car.equals(car1));
    }

    @Test
    public void testEquals6() {
        Car car = new Car(3, 3, 0, 1, 3, 3, new CarType(10.0f, "The characteristics of someone or something"),
                "Gos Nomber");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertFalse(car.equals(car1));
    }

    @Test
    public void testEquals7() {
        Car car = new Car(3, 3, 1, 0, 3, 3, new CarType(10.0f, "The characteristics of someone or something"),
                "Gos Nomber");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car1 = new Car();
        car1.setMaxPeopleCapacity(3);
        car1.setGosNomber("Gos Nomber");
        car1.setType(carType);
        car1.setId(123L);
        car1.setMax_weight(3);
        car1.setSize(3);
        car1.setWidth(1);
        car1.setLength(3);
        car1.setHeight(0);
        assertTrue(car.equals(car1));
    }

    @Test
    public void testEquals8() {
        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        assertFalse(car.equals(new Car()));
    }

    @Test
    public void testEquals9() {
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setType(carType);
        assertFalse(car.equals(new Car()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1609341451, (new Car()).hashCode());
        assertEquals(1166437679,
                (new Car(3, 3, 1, 1, 3, 3, new CarType(10.0f, "The characteristics of someone or something"), "Gos Nomber"))
                        .hashCode());
    }
}

