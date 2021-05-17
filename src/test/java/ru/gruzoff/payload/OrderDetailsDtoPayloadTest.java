package ru.gruzoff.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import ru.gruzoff.entity.Adress;

public class OrderDetailsDtoPayloadTest {
    @Test
    public void testCanEqual() {
        assertFalse((new OrderDetailsDtoPayload()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        assertTrue(orderDetailsDtoPayload.canEqual(new OrderDetailsDtoPayload()));
    }

    @Test
    public void testConstructor() {
        OrderDetailsDtoPayload actualOrderDetailsDtoPayload = new OrderDetailsDtoPayload();
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition("Extra House Definition");
        adress.setCountry("Country");
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber("House Nomber");
        adress.setTown("Oxford");
        adress.setStreet("Street");
        actualOrderDetailsDtoPayload.setAdressFrom(adress);
        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        actualOrderDetailsDtoPayload.setAdressTo(adress1);
        actualOrderDetailsDtoPayload.setComment("Comment");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualOrderDetailsDtoPayload.setDateTime(fromResult);
        actualOrderDetailsDtoPayload.setLoadersCapacity(1);
        actualOrderDetailsDtoPayload.setTimeOnOrder(10.0f);
        Adress adressFrom = actualOrderDetailsDtoPayload.getAdressFrom();
        assertSame(adress, adressFrom);
        assertEquals(adress1, adressFrom);
        Adress adressTo = actualOrderDetailsDtoPayload.getAdressTo();
        assertEquals(adressFrom, adressTo);
        assertSame(adress1, adressTo);
        assertEquals("Comment", actualOrderDetailsDtoPayload.getComment());
        assertSame(fromResult, actualOrderDetailsDtoPayload.getDateTime());
        assertEquals(1, actualOrderDetailsDtoPayload.getLoadersCapacity());
        assertEquals(10.0f, actualOrderDetailsDtoPayload.getTimeOnOrder());
    }

    @Test
    public void testConstructor2() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        Adress adress1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        OrderDetailsDtoPayload actualOrderDetailsDtoPayload = new OrderDetailsDtoPayload(adress, adress1, new Date(1L),
                10.0f, 1, "Comment");
        Adress adress2 = new Adress();
        adress2.setLatitude(10.0f);
        adress2.setExtraHouseDefinition("Extra House Definition");
        adress2.setCountry("Country");
        adress2.setLongitude(10.0f);
        adress2.setId(123L);
        adress2.setHouseNomber("House Nomber");
        adress2.setTown("Oxford");
        adress2.setStreet("Street");
        actualOrderDetailsDtoPayload.setAdressFrom(adress2);
        Adress adress3 = new Adress();
        adress3.setLatitude(10.0f);
        adress3.setExtraHouseDefinition("Extra House Definition");
        adress3.setCountry("Country");
        adress3.setLongitude(10.0f);
        adress3.setId(123L);
        adress3.setHouseNomber("House Nomber");
        adress3.setTown("Oxford");
        adress3.setStreet("Street");
        actualOrderDetailsDtoPayload.setAdressTo(adress3);
        actualOrderDetailsDtoPayload.setComment("Comment");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualOrderDetailsDtoPayload.setDateTime(fromResult);
        actualOrderDetailsDtoPayload.setLoadersCapacity(1);
        actualOrderDetailsDtoPayload.setTimeOnOrder(10.0f);
        Adress adressFrom = actualOrderDetailsDtoPayload.getAdressFrom();
        assertEquals(adress, adressFrom);
        assertEquals(adress1, adressFrom);
        assertEquals(adress3, adressFrom);
        assertSame(adress2, adressFrom);
        Adress adressTo = actualOrderDetailsDtoPayload.getAdressTo();
        assertEquals(adress1, adressTo);
        assertEquals(adressFrom, adressTo);
        assertSame(adress3, adressTo);
        assertEquals(adress, adressTo);
        assertEquals("Comment", actualOrderDetailsDtoPayload.getComment());
        assertSame(fromResult, actualOrderDetailsDtoPayload.getDateTime());
        assertEquals(1, actualOrderDetailsDtoPayload.getLoadersCapacity());
        assertEquals(10.0f, actualOrderDetailsDtoPayload.getTimeOnOrder());
    }

    @Test
    public void testEquals() {
        assertFalse((new OrderDetailsDtoPayload()).equals("42"));
    }

    @Test
    public void testEquals10() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();

        OrderDetailsDtoPayload orderDetailsDtoPayload1 = new OrderDetailsDtoPayload();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetailsDtoPayload1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(orderDetailsDtoPayload.equals(orderDetailsDtoPayload1));
    }

    @Test
    public void testEquals11() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        orderDetailsDtoPayload.setTimeOnOrder(10.0f);
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        assertFalse(orderDetailsDtoPayload
                .equals(new OrderDetailsDtoPayload(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals12() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload(adressFrom, adressTo, new Date(1L),
                10.0f, 1, "Country");
        Adress adressFrom1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        assertFalse(orderDetailsDtoPayload
                .equals(new OrderDetailsDtoPayload(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals13() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload(adressFrom, adressTo, new Date(1L),
                10.0f, 1, null);
        Adress adressFrom1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        assertFalse(orderDetailsDtoPayload
                .equals(new OrderDetailsDtoPayload(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals2() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        assertTrue(orderDetailsDtoPayload.equals(new OrderDetailsDtoPayload()));
    }

    @Test
    public void testEquals3() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        assertFalse(orderDetailsDtoPayload
                .equals(new OrderDetailsDtoPayload(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals4() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload(adressFrom, adressTo, new Date(1L),
                10.0f, 1, "Comment");
        Adress adressFrom1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo1 = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        assertTrue(orderDetailsDtoPayload
                .equals(new OrderDetailsDtoPayload(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals5() {
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        orderDetailsDtoPayload.setAdressFrom(adress);
        assertFalse(orderDetailsDtoPayload.equals(new OrderDetailsDtoPayload()));
    }

    @Test
    public void testEquals6() {
        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        orderDetailsDtoPayload.setAdressTo(adress);
        assertFalse(orderDetailsDtoPayload.equals(new OrderDetailsDtoPayload()));
    }

    @Test
    public void testEquals7() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetailsDtoPayload.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(orderDetailsDtoPayload.equals(new OrderDetailsDtoPayload()));
    }

    @Test
    public void testEquals8() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        OrderDetailsDtoPayload orderDetailsDtoPayload1 = new OrderDetailsDtoPayload();
        orderDetailsDtoPayload1.setAdressFrom(adress);
        assertFalse(orderDetailsDtoPayload.equals(orderDetailsDtoPayload1));
    }

    @Test
    public void testEquals9() {
        OrderDetailsDtoPayload orderDetailsDtoPayload = new OrderDetailsDtoPayload();

        Adress adress = new Adress();
        adress.setLatitude(10.0f);
        adress.setExtraHouseDefinition(null);
        adress.setCountry(null);
        adress.setLongitude(10.0f);
        adress.setId(123L);
        adress.setHouseNomber(null);
        adress.setTown("Oxford");
        adress.setStreet(null);

        OrderDetailsDtoPayload orderDetailsDtoPayload1 = new OrderDetailsDtoPayload();
        orderDetailsDtoPayload1.setAdressTo(adress);
        assertFalse(orderDetailsDtoPayload.equals(orderDetailsDtoPayload1));
    }

    @Test
    public void testHashCode() {
        assertEquals(-760155759, (new OrderDetailsDtoPayload()).hashCode());
    }

    @Test
    public void testHashCode2() {
        Adress adressFrom = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        Adress adressTo = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        assertEquals(1634947492,
                (new OrderDetailsDtoPayload(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment")).hashCode());
    }
}

