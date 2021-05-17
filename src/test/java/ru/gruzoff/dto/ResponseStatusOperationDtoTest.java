package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ResponseStatusOperationDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new ResponseStatusOperationDto("Response")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        ResponseStatusOperationDto responseStatusOperationDto = new ResponseStatusOperationDto("Response");
        assertTrue(responseStatusOperationDto.canEqual(new ResponseStatusOperationDto("Response")));
    }

    @Test
    public void testConstructor() {
        ResponseStatusOperationDto actualResponseStatusOperationDto = new ResponseStatusOperationDto();
        actualResponseStatusOperationDto.setResponse("Response");
        assertEquals("Response", actualResponseStatusOperationDto.getResponse());
        assertEquals("ResponseStatusOperationDto(response=Response)", actualResponseStatusOperationDto.toString());
    }

    @Test
    public void testConstructor2() {
        ResponseStatusOperationDto actualResponseStatusOperationDto = new ResponseStatusOperationDto("Response");
        actualResponseStatusOperationDto.setResponse("Response");
        assertEquals("Response", actualResponseStatusOperationDto.getResponse());
        assertEquals("ResponseStatusOperationDto(response=Response)", actualResponseStatusOperationDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new ResponseStatusOperationDto("Response")).equals("42"));
    }

    @Test
    public void testEquals2() {
        ResponseStatusOperationDto responseStatusOperationDto = new ResponseStatusOperationDto("Response");
        assertTrue(responseStatusOperationDto.equals(new ResponseStatusOperationDto("Response")));
    }

    @Test
    public void testEquals3() {
        ResponseStatusOperationDto responseStatusOperationDto = new ResponseStatusOperationDto("Response");
        assertFalse(responseStatusOperationDto.equals(new ResponseStatusOperationDto()));
    }

    @Test
    public void testEquals4() {
        ResponseStatusOperationDto responseStatusOperationDto = new ResponseStatusOperationDto(null);
        assertFalse(responseStatusOperationDto.equals(new ResponseStatusOperationDto("Response")));
    }

    @Test
    public void testEquals5() {
        ResponseStatusOperationDto responseStatusOperationDto = new ResponseStatusOperationDto(null);
        assertTrue(responseStatusOperationDto.equals(new ResponseStatusOperationDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-275679076, (new ResponseStatusOperationDto("Response")).hashCode());
        assertEquals(102, (new ResponseStatusOperationDto(null)).hashCode());
    }
}

