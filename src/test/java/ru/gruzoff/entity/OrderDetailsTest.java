package ru.gruzoff.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class OrderDetailsTest {
    @Test
    public void testCanEqual() {
        assertFalse((new OrderDetails()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        OrderDetails orderDetails = new OrderDetails();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType);
        orderDetails1.setTimeOnOrder(10.0f);
        orderDetails1.setAdressFrom(adress);
        orderDetails1.setAdressTo(adress1);
        orderDetails1.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails1.setComment("Comment");
        orderDetails1.setLoadersCapacity(0);
        assertTrue(orderDetails.canEqual(orderDetails1));
    }

    @Test
    public void testConstructor() {
        OrderDetails actualOrderDetails = new OrderDetails();
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");
        actualOrderDetails.setAdressFrom(adress);
        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        actualOrderDetails.setAdressTo(adress1);
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");
        actualOrderDetails.setCarType(carType);
        actualOrderDetails.setComment("Comment");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualOrderDetails.setDateTime(fromResult);
        actualOrderDetails.setLoadersCapacity(1);
        actualOrderDetails.setTimeOnOrder(10.0f);
        Adress adressFrom = actualOrderDetails.getAdressFrom();
        assertEquals(adress1, adressFrom);
        assertSame(adress, adressFrom);
        Adress adressTo = actualOrderDetails.getAdressTo();
        assertSame(adress1, adressTo);
        assertEquals(adressFrom, adressTo);
        assertSame(carType, actualOrderDetails.getCarType());
        assertEquals("Comment", actualOrderDetails.getComment());
        assertSame(fromResult, actualOrderDetails.getDateTime());
        assertEquals(1, actualOrderDetails.getLoadersCapacity());
        assertEquals(10.0f, actualOrderDetails.getTimeOnOrder());
    }

    @Test
    public void testConstructor2() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        Adress adress1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        Date dateTime = new Date(1L);
        CarType carType = new CarType(10.0f, "The characteristics of someone or something");
        OrderDetails actualOrderDetails = new OrderDetails(adress, adress1, dateTime, 10.0f, 1, carType, "Comment");
        Adress adress2 = new Adress();
        adress2.setLatitude(10.0f);
        adress2.setExtraHouseDefinition("Extra House Definition");
        adress2.setCountry("Country");
        adress2.setLongitude(10.0f);
        adress2.setId(123L);
        adress2.setHouseNomber("House Nomber");
        adress2.setTown("Oxford");
        adress2.setStreet("Street");
        actualOrderDetails.setAdressFrom(adress2);
        Adress adress3 = new Adress();
        adress3.setLatitude(10.0f);
        adress3.setExtraHouseDefinition("Extra House Definition");
        adress3.setCountry("Country");
        adress3.setLongitude(10.0f);
        adress3.setId(123L);
        adress3.setHouseNomber("House Nomber");
        adress3.setTown("Oxford");
        adress3.setStreet("Street");
        actualOrderDetails.setAdressTo(adress3);
        CarType carType1 = new CarType();
        carType1.setPricePerHour(10.0f);
        carType1.setId(123L);
        carType1.setDescription("The characteristics of someone or something");
        actualOrderDetails.setCarType(carType1);
        actualOrderDetails.setComment("Comment");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualOrderDetails.setDateTime(fromResult);
        actualOrderDetails.setLoadersCapacity(1);
        actualOrderDetails.setTimeOnOrder(10.0f);
        Adress adressFrom = actualOrderDetails.getAdressFrom();
        assertEquals(adress, adressFrom);
        assertSame(adress2, adressFrom);
        assertEquals(adress1, adressFrom);
        assertEquals(adress3, adressFrom);
        Adress adressTo = actualOrderDetails.getAdressTo();
        assertEquals(adress, adressTo);
        assertSame(adress3, adressTo);
        assertEquals(adress1, adressTo);
        assertEquals(adressFrom, adressTo);
        CarType carType2 = actualOrderDetails.getCarType();
        assertSame(carType1, carType2);
        assertEquals(carType, carType2);
        assertEquals("Comment", actualOrderDetails.getComment());
        assertSame(fromResult, actualOrderDetails.getDateTime());
        assertEquals(1, actualOrderDetails.getLoadersCapacity());
        assertEquals(10.0f, actualOrderDetails.getTimeOnOrder());
    }

    @Test
    public void testEquals() {
        assertFalse((new OrderDetails()).equals("42"));
    }

    @Test
    public void testEquals10() {
        OrderDetails orderDetails = new OrderDetails();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType);
        assertFalse(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals11() {
        OrderDetails orderDetails = new OrderDetails();

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setAdressTo(adress);
        assertFalse(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals12() {
        OrderDetails orderDetails = new OrderDetails();

        OrderDetails orderDetails1 = new OrderDetails();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals13() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date dateTime = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        OrderDetails orderDetails = new OrderDetails(adressFrom, adressTo, dateTime, 10.0f, 0,
                new CarType(10.0f, "The characteristics of someone or something"), "Comment");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType);
        orderDetails1.setTimeOnOrder(10.0f);
        orderDetails1.setAdressFrom(adress);
        orderDetails1.setAdressTo(adress1);
        orderDetails1.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails1.setComment("Comment");
        orderDetails1.setLoadersCapacity(0);
        assertTrue(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals2() {
        OrderDetails orderDetails = new OrderDetails();

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType);
        orderDetails1.setTimeOnOrder(10.0f);
        orderDetails1.setAdressFrom(adress);
        orderDetails1.setAdressTo(adress1);
        orderDetails1.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails1.setComment("Comment");
        orderDetails1.setLoadersCapacity(0);
        assertFalse(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals3() {
        OrderDetails orderDetails = new OrderDetails();
        assertTrue(orderDetails.equals(new OrderDetails()));
    }

    @Test
    public void testEquals4() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        Date dateTime = new Date(1L);
        OrderDetails orderDetails = new OrderDetails(adressFrom, adressTo, dateTime, 10.0f, 1,
                new CarType(10.0f, "The characteristics of someone or something"), "Comment");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType);
        orderDetails1.setTimeOnOrder(10.0f);
        orderDetails1.setAdressFrom(adress);
        orderDetails1.setAdressTo(adress1);
        orderDetails1.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails1.setComment("Comment");
        orderDetails1.setLoadersCapacity(0);
        assertFalse(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals5() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setTimeOnOrder(10.0f);

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType);
        orderDetails1.setTimeOnOrder(10.0f);
        orderDetails1.setAdressFrom(adress);
        orderDetails1.setAdressTo(adress1);
        orderDetails1.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails1.setComment("Comment");
        orderDetails1.setLoadersCapacity(0);
        assertFalse(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals6() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        Date dateTime = new Date(1L);
        OrderDetails orderDetails = new OrderDetails(adressFrom, adressTo, dateTime, 10.0f, 0,
                new CarType(10.0f, "The characteristics of someone or something"), "Comment");

        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");

        OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setCarType(carType);
        orderDetails1.setTimeOnOrder(10.0f);
        orderDetails1.setAdressFrom(adress);
        orderDetails1.setAdressTo(adress1);
        orderDetails1.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetails1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        orderDetails1.setComment("Comment");
        orderDetails1.setLoadersCapacity(0);
        assertFalse(orderDetails.equals(orderDetails1));
    }

    @Test
    public void testEquals7() {
        CarType carType = new CarType();
        carType.setPricePerHour(10.0f);
        carType.setId(123L);
        carType.setDescription("The characteristics of someone or something");

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCarType(carType);
        assertFalse(orderDetails.equals(new OrderDetails()));
    }

    @Test
    public void testEquals8() {
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setAdressFrom(adress);
        assertFalse(orderDetails.equals(new OrderDetails()));
    }

    @Test
    public void testEquals9() {
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setAdressTo(adress);
        assertFalse(orderDetails.equals(new OrderDetails()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1899516778, (new OrderDetails()).hashCode());
    }

    @Test
    public void testHashCode2() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        Date dateTime = new Date(1L);
        assertEquals(-19721800, (new OrderDetails(adressFrom, adressTo, dateTime, 10.0f, 1,
                new CarType(10.0f, "The characteristics of someone or something"), "Comment")).hashCode());
    }
}

