package ru.gruzoff.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarValidityTest {
    @Test
    public void testCanEqual() {
        assertFalse((new CarValidity()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        CarValidity carValidity = new CarValidity();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(true);
        carValidity1.setId(123L);
        carValidity1.setCarId(car);
        assertTrue(carValidity.canEqual(carValidity1));
    }

    @Test
    public void testConstructor() {
        CarValidity actualCarValidity = new CarValidity();
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");
        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);
        actualCarValidity.setCarId(car);
        actualCarValidity.setReasonOfCrash("Just cause");
        actualCarValidity.setValid(true);
        assertSame(car, actualCarValidity.getCarId());
        assertEquals("Just cause", actualCarValidity.getReasonOfCrash());
        assertTrue(actualCarValidity.isValid());
        assertEquals(
                "CarValidity(isValid=true, reasonOfCrash=Just cause, carId=Car(max_weight=3, length=3, width=1, height=1,"
                        + " size=3, maxPeopleCapacity=3, type=CarType(pricePerHour=10.0, description=The characteristics of someone"
                        + " or something), gosNomber=Gos Nomber))",
                actualCarValidity.toString());
    }

    @Test
    public void testConstructor2() {
        CarValidity actualCarValidity = new CarValidity(true, "Just cause", new Car());
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");
        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(1);
        actualCarValidity.setCarId(car);
        actualCarValidity.setReasonOfCrash("Just cause");
        actualCarValidity.setValid(true);
        assertSame(car, actualCarValidity.getCarId());
        assertEquals("Just cause", actualCarValidity.getReasonOfCrash());
        assertTrue(actualCarValidity.isValid());
        assertEquals(
                "CarValidity(isValid=true, reasonOfCrash=Just cause, carId=Car(max_weight=3, length=3, width=1, height=1,"
                        + " size=3, maxPeopleCapacity=3, type=CarType(pricePerHour=10.0, description=The characteristics of someone"
                        + " or something), gosNomber=Gos Nomber))",
                actualCarValidity.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new CarValidity()).equals("42"));
    }

    @Test
    public void testEquals2() {
        CarValidity carValidity = new CarValidity();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(true);
        carValidity1.setId(123L);
        carValidity1.setCarId(car);
        assertFalse(carValidity.equals(carValidity1));
    }

    @Test
    public void testEquals3() {
        CarValidity carValidity = new CarValidity();
        assertTrue(carValidity.equals(new CarValidity()));
    }

    @Test
    public void testEquals4() {
        CarValidity carValidity = new CarValidity(true, "Just cause", new Car());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(true);
        carValidity1.setId(123L);
        carValidity1.setCarId(car);
        assertFalse(carValidity.equals(carValidity1));
    }

    @Test
    public void testEquals5() {
        CarValidity carValidity = new CarValidity();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(false);
        carValidity1.setId(123L);
        carValidity1.setCarId(car);
        assertFalse(carValidity.equals(carValidity1));
    }

    @Test
    public void testEquals6() {
        CarValidity carValidity = new CarValidity(true, "Reason Of Crash", new Car());

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(true);
        carValidity1.setId(123L);
        carValidity1.setCarId(car);
        assertFalse(carValidity.equals(carValidity1));
    }

    @Test
    public void testEquals7() {
        CarValidity carValidity = new CarValidity(true, "Just cause", null);

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Car car = new Car();
        car.setMaxPeopleCapacity(3);
        car.setGosNomber("Gos Nomber");
        car.setType(carType);
        car.setId(123L);
        car.setMax_weight(3);
        car.setSize(3);
        car.setWidth(1);
        car.setLength(3);
        car.setHeight(0);

        CarValidity carValidity1 = new CarValidity();
        carValidity1.setReasonOfCrash("Just cause");
        carValidity1.setValid(true);
        carValidity1.setId(123L);
        carValidity1.setCarId(car);
        assertFalse(carValidity.equals(carValidity1));
    }

    @Test
    public void testHashCode() {
        assertEquals(545616, (new CarValidity()).hashCode());
        assertEquals(836990470, (new CarValidity(true, "Just cause", new Car())).hashCode());
    }
}

