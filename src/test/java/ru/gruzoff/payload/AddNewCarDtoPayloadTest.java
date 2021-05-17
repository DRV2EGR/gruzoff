package ru.gruzoff.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AddNewCarDtoPayloadTest {
    @Test
    public void testCanEqual() {
        assertFalse((new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber");
        assertTrue(addNewCarDtoPayload.canEqual(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testConstructor() {
        AddNewCarDtoPayload actualAddNewCarDtoPayload = new AddNewCarDtoPayload();
        actualAddNewCarDtoPayload.setDriverId(123L);
        actualAddNewCarDtoPayload.setGosNomber("Gos Nomber");
        actualAddNewCarDtoPayload.setHeight(1);
        actualAddNewCarDtoPayload.setLength(3);
        actualAddNewCarDtoPayload.setMaxPeopleCapacity(3);
        actualAddNewCarDtoPayload.setMax_weight(3);
        actualAddNewCarDtoPayload.setSize(3);
        actualAddNewCarDtoPayload.setType(1L);
        actualAddNewCarDtoPayload.setWidth(1);
        assertEquals(123L, actualAddNewCarDtoPayload.getDriverId());
        assertEquals("Gos Nomber", actualAddNewCarDtoPayload.getGosNomber());
        assertEquals(1, actualAddNewCarDtoPayload.getHeight());
        assertEquals(3, actualAddNewCarDtoPayload.getLength());
        assertEquals(3, actualAddNewCarDtoPayload.getMaxPeopleCapacity());
        assertEquals(3, actualAddNewCarDtoPayload.getMax_weight());
        assertEquals(3, actualAddNewCarDtoPayload.getSize());
        assertEquals(1L, actualAddNewCarDtoPayload.getType());
        assertEquals(1, actualAddNewCarDtoPayload.getWidth());
        assertEquals(
                "AddNewCarDtoPayload(driverId=123, max_weight=3, length=3, width=1, height=1, size=3, maxPeopleCapacity=3,"
                        + " type=1, gosNomber=Gos Nomber)",
                actualAddNewCarDtoPayload.toString());
    }

    @Test
    public void testConstructor2() {
        AddNewCarDtoPayload actualAddNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber");
        assertEquals(123L, actualAddNewCarDtoPayload.getDriverId());
        assertEquals(1, actualAddNewCarDtoPayload.getWidth());
        assertEquals(1L, actualAddNewCarDtoPayload.getType());
        assertEquals(3, actualAddNewCarDtoPayload.getSize());
        assertEquals(3, actualAddNewCarDtoPayload.getMax_weight());
        assertEquals(3, actualAddNewCarDtoPayload.getMaxPeopleCapacity());
        assertEquals(3, actualAddNewCarDtoPayload.getLength());
        assertEquals(1, actualAddNewCarDtoPayload.getHeight());
        assertEquals("Gos Nomber", actualAddNewCarDtoPayload.getGosNomber());
    }

    @Test
    public void testEquals() {
        assertFalse((new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")).equals("42"));
    }

    @Test
    public void testEquals10() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 0L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals11() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, null);
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals12() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L,
                "ru.gruzoff.payload.AddNewCarDtoPayload");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals13() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload();
        assertTrue(addNewCarDtoPayload.equals(new AddNewCarDtoPayload()));
    }

    @Test
    public void testEquals2() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber");
        assertTrue(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals3() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload()));
    }

    @Test
    public void testEquals4() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 0, 3, 1, 1, 3, 3, 1L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals5() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 0, 1, 1, 3, 3, 1L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals6() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 0, 1, 3, 3, 1L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals7() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 0, 3, 3, 1L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals8() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 0, 3, 1L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testEquals9() {
        AddNewCarDtoPayload addNewCarDtoPayload = new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 0, 1L, "Gos Nomber");
        assertFalse(addNewCarDtoPayload.equals(new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1718831027, (new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, "Gos Nomber")).hashCode());
        assertEquals(-1121293120, (new AddNewCarDtoPayload(123L, 3, 3, 1, 1, 3, 3, 1L, null)).hashCode());
    }
}

