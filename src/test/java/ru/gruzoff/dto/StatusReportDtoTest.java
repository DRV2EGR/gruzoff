package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StatusReportDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new StatusReportDto((byte) 'A')).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        StatusReportDto statusReportDto = new StatusReportDto((byte) 'A');
        assertTrue(statusReportDto.canEqual(new StatusReportDto((byte) 'A')));
    }

    @Test
    public void testConstructor() {
        StatusReportDto actualStatusReportDto = new StatusReportDto((byte) 'A');
        actualStatusReportDto.setStatus("Status");
        assertEquals("Status", actualStatusReportDto.getStatus());
        assertEquals("StatusReportDto(status=Status)", actualStatusReportDto.toString());
    }

    @Test
    public void testConstructor2() {
        assertEquals("error", (new StatusReportDto((byte) 'A')).getStatus());
    }

    @Test
    public void testConstructor3() {
        assertEquals("working", (new StatusReportDto((byte) 1)).getStatus());
    }

    @Test
    public void testEquals() {
        assertFalse((new StatusReportDto((byte) 'A')).equals("42"));
    }

    @Test
    public void testEquals2() {
        StatusReportDto statusReportDto = new StatusReportDto((byte) 'A');
        assertTrue(statusReportDto.equals(new StatusReportDto((byte) 'A')));
    }

    @Test
    public void testEquals3() {
        StatusReportDto statusReportDto = new StatusReportDto((byte) 1);
        assertFalse(statusReportDto.equals(new StatusReportDto((byte) 'A')));
    }

    @Test
    public void testHashCode() {
        assertEquals(96784963, (new StatusReportDto((byte) 'A')).hashCode());
    }

    @Test
    public void testHashCode2() {
        StatusReportDto statusReportDto = new StatusReportDto((byte) 'A');
        statusReportDto.setStatus(null);
        assertEquals(102, statusReportDto.hashCode());
    }
}

