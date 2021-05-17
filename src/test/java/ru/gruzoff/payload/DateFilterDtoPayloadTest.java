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

public class DateFilterDtoPayloadTest {
    @Test
    public void testCanEqual() {
        assertFalse((new DateFilterDtoPayload()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        assertTrue(dateFilterDtoPayload.canEqual(new DateFilterDtoPayload()));
    }

    @Test
    public void testConstructor() {
        DateFilterDtoPayload actualDateFilterDtoPayload = new DateFilterDtoPayload();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualDateFilterDtoPayload.setDate1(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant());
        actualDateFilterDtoPayload.setDate2(fromResult1);
        Date date1 = actualDateFilterDtoPayload.getDate1();
        assertSame(fromResult, date1);
        assertEquals(fromResult1, date1);
        Date date2 = actualDateFilterDtoPayload.getDate2();
        assertEquals(date1, date2);
        assertSame(fromResult1, date2);
    }

    @Test
    public void testConstructor2() {
        Date date1 = new Date(1L);
        DateFilterDtoPayload actualDateFilterDtoPayload = new DateFilterDtoPayload(date1, new Date(1L));
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualDateFilterDtoPayload.setDate1(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant());
        actualDateFilterDtoPayload.setDate2(fromResult1);
        Date date11 = actualDateFilterDtoPayload.getDate1();
        assertSame(fromResult, date11);
        assertEquals(fromResult1, date11);
        Date date2 = actualDateFilterDtoPayload.getDate2();
        assertSame(fromResult1, date2);
        assertEquals(date11, date2);
    }

    @Test
    public void testEquals() {
        assertFalse((new DateFilterDtoPayload()).equals("42"));
    }

    @Test
    public void testEquals2() {
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        assertTrue(dateFilterDtoPayload.equals(new DateFilterDtoPayload()));
    }

    @Test
    public void testEquals3() {
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        Date date1 = new Date(1L);
        assertFalse(dateFilterDtoPayload.equals(new DateFilterDtoPayload(date1, new Date(1L))));
    }

    @Test
    public void testEquals4() {
        Date date1 = new Date(1L);
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload(date1, new Date(1L));
        assertFalse(dateFilterDtoPayload.equals(new DateFilterDtoPayload()));
    }

    @Test
    public void testEquals5() {
        Date date1 = new Date(1L);
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload(date1, new Date(1L));
        Date date11 = new Date(1L);
        assertTrue(dateFilterDtoPayload.equals(new DateFilterDtoPayload(date11, new Date(1L))));
    }

    @Test
    public void testEquals6() {
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        assertFalse(dateFilterDtoPayload.equals(new DateFilterDtoPayload(null, new Date(1L))));
    }

    @Test
    public void testEquals7() {
        DateFilterDtoPayload dateFilterDtoPayload = new DateFilterDtoPayload();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        dateFilterDtoPayload.setDate2(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        assertFalse(dateFilterDtoPayload.equals(new DateFilterDtoPayload()));
    }

    @Test
    public void testHashCode() {
        assertEquals(6061, (new DateFilterDtoPayload()).hashCode());
    }

    @Test
    public void testHashCode2() {
        Date date1 = new Date(1L);
        assertEquals(3541, (new DateFilterDtoPayload(date1, new Date(1L))).hashCode());
    }
}

