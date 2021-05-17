package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class OrderDetailsDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new OrderDetailsDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        assertTrue(orderDetailsDto.canEqual(new OrderDetailsDto()));
    }

    @Test
    public void testConstructor() {
        OrderDetailsDto actualOrderDetailsDto = new OrderDetailsDto();
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        actualOrderDetailsDto.setAdressFrom(adressDto);
        AdressDto adressDto1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        actualOrderDetailsDto.setAdressTo(adressDto1);
        actualOrderDetailsDto.setComment("Comment");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualOrderDetailsDto.setDateTime(fromResult);
        actualOrderDetailsDto.setLoadersCapacity(1);
        actualOrderDetailsDto.setTimeOnOrder(10.0f);
        AdressDto adressFrom = actualOrderDetailsDto.getAdressFrom();
        assertEquals(adressDto1, adressFrom);
        assertSame(adressDto, adressFrom);
        AdressDto adressTo = actualOrderDetailsDto.getAdressTo();
        assertSame(adressDto1, adressTo);
        assertEquals(adressFrom, adressTo);
        assertEquals("Comment", actualOrderDetailsDto.getComment());
        assertSame(fromResult, actualOrderDetailsDto.getDateTime());
        assertEquals(1, actualOrderDetailsDto.getLoadersCapacity());
        assertEquals(10.0f, actualOrderDetailsDto.getTimeOnOrder());
    }

    @Test
    public void testConstructor2() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressDto1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto actualOrderDetailsDto = new OrderDetailsDto(adressDto, adressDto1, new Date(1L), 10.0f, 1,
                "Comment");
        AdressDto adressDto2 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        actualOrderDetailsDto.setAdressFrom(adressDto2);
        AdressDto adressDto3 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        actualOrderDetailsDto.setAdressTo(adressDto3);
        actualOrderDetailsDto.setComment("Comment");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualOrderDetailsDto.setDateTime(fromResult);
        actualOrderDetailsDto.setLoadersCapacity(1);
        actualOrderDetailsDto.setTimeOnOrder(10.0f);
        AdressDto adressFrom = actualOrderDetailsDto.getAdressFrom();
        assertSame(adressDto2, adressFrom);
        assertEquals(adressDto3, adressFrom);
        assertEquals(adressDto, adressFrom);
        assertEquals(adressDto1, adressFrom);
        AdressDto adressTo = actualOrderDetailsDto.getAdressTo();
        assertEquals(adressDto, adressTo);
        assertSame(adressDto3, adressTo);
        assertEquals(adressFrom, adressTo);
        assertEquals(adressDto1, adressTo);
        assertEquals("Comment", actualOrderDetailsDto.getComment());
        assertSame(fromResult, actualOrderDetailsDto.getDateTime());
        assertEquals(1, actualOrderDetailsDto.getLoadersCapacity());
        assertEquals(10.0f, actualOrderDetailsDto.getTimeOnOrder());
    }

    @Test
    public void testEquals() {
        assertFalse((new OrderDetailsDto()).equals("42"));
    }

    @Test
    public void testEquals10() {
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto(null, "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment");
        AdressDto adressFrom1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals11() {
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(adressFrom, null, new Date(1L), 10.0f, 1, "Comment");
        AdressDto adressFrom1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom1, adressTo, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals12() {
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Country");
        AdressDto adressFrom1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals13() {
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, null);
        AdressDto adressFrom1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals2() {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        assertTrue(orderDetailsDto.equals(new OrderDetailsDto()));
    }

    @Test
    public void testEquals3() {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals4() {
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment");
        AdressDto adressFrom1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertTrue(orderDetailsDto.equals(new OrderDetailsDto(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals5() {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetailsDto.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto()));
    }

    @Test
    public void testEquals6() {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();

        OrderDetailsDto orderDetailsDto1 = new OrderDetailsDto();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        orderDetailsDto1.setDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(orderDetailsDto.equals(orderDetailsDto1));
    }

    @Test
    public void testEquals7() {
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        orderDetailsDto.setTimeOnOrder(10.0f);
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals8() {
        AdressDto adressFrom = new AdressDto(null, "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment");
        AdressDto adressFrom1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom1, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testEquals9() {
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto(null, adressTo, new Date(1L), 10.0f, 1, "Comment");
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo1 = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(orderDetailsDto.equals(new OrderDetailsDto(adressFrom, adressTo1, new Date(1L), 10.0f, 1, "Comment")));
    }

    @Test
    public void testHashCode() {
        assertEquals(-760155759, (new OrderDetailsDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        AdressDto adressFrom = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        AdressDto adressTo = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertEquals(1325676740, (new OrderDetailsDto(adressFrom, adressTo, new Date(1L), 10.0f, 1, "Comment")).hashCode());
    }
}

