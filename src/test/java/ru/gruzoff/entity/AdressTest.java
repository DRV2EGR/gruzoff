package ru.gruzoff.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AdressTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f))
                .canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertTrue(adress.canEqual(adress1));
    }

    @Test
    public void testConstructor() {
        Adress actualAdress = new Adress();
        actualAdress.setCountry("Country");
        actualAdress.setExtraHouseDefinition("Extra House Definition");
        actualAdress.setHouseNomber("House Nomber");
        actualAdress.setLatitude(10.0f);
        actualAdress.setLongitude(10.0f);
        actualAdress.setStreet("Street");
        actualAdress.setTown("Oxford");
        assertEquals("Country", actualAdress.getCountry());
        assertEquals("Extra House Definition", actualAdress.getExtraHouseDefinition());
        assertEquals("House Nomber", actualAdress.getHouseNomber());
        assertEquals(10.0f, actualAdress.getLatitude());
        assertEquals(10.0f, actualAdress.getLongitude());
        assertEquals("Street", actualAdress.getStreet());
        assertEquals("Oxford", actualAdress.getTown());
        assertEquals("Country,Oxford,Street,House Nomber,Extra House Definition", actualAdress.toString());
    }

    @Test
    public void testConstructor2() {
        Adress actualAdress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f,
                10.0f);
        actualAdress.setCountry("Country");
        actualAdress.setExtraHouseDefinition("Extra House Definition");
        actualAdress.setHouseNomber("House Nomber");
        actualAdress.setLatitude(10.0f);
        actualAdress.setLongitude(10.0f);
        actualAdress.setStreet("Street");
        actualAdress.setTown("Oxford");
        assertEquals("Country", actualAdress.getCountry());
        assertEquals("Extra House Definition", actualAdress.getExtraHouseDefinition());
        assertEquals("House Nomber", actualAdress.getHouseNomber());
        assertEquals(10.0f, actualAdress.getLatitude());
        assertEquals(10.0f, actualAdress.getLongitude());
        assertEquals("Street", actualAdress.getStreet());
        assertEquals("Oxford", actualAdress.getTown());
        assertEquals("Country,Oxford,Street,House Nomber,Extra House Definition", actualAdress.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f))
                .equals("42"));
    }

    @Test
    public void testEquals10() {
        Adress adress = new Adress("Country", "Oxford", "Street", "Country", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals11() {
        Adress adress = new Adress("Country", "Oxford", "Street", null, "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals12() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Country", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals13() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", null, 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals14() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 0.5f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals15() {
        Adress adress = new Adress(null, "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry(null);
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertTrue(adress.equals(adress1));
    }

    @Test
    public void testEquals16() {
        Adress adress = new Adress("Country", null, "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown(null);
        adress1.setStreet("Street");
        assertTrue(adress.equals(adress1));
    }

    @Test
    public void testEquals17() {
        Adress adress = new Adress("Country", "Oxford", null, "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet(null);
        assertTrue(adress.equals(adress1));
    }

    @Test
    public void testEquals2() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertTrue(adress.equals(adress1));
    }

    @Test
    public void testEquals3() {
        Adress adress = new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);
        assertFalse(adress.equals(new Adress()));
    }

    @Test
    public void testEquals4() {
        Adress adress = new Adress(null, "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals5() {
        Adress adress = new Adress("Oxford", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals6() {
        Adress adress = new Adress("Country", "Country", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals7() {
        Adress adress = new Adress("Country", null, "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals8() {
        Adress adress = new Adress("Country", "Oxford", "Country", "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testEquals9() {
        Adress adress = new Adress("Country", "Oxford", null, "House Nomber", "Extra House Definition", 10.0f, 10.0f);

        Adress adress1 = new Adress();
        adress1.setLatitude(10.0f);
        adress1.setExtraHouseDefinition("Extra House Definition");
        adress1.setCountry("Country");
        adress1.setLongitude(10.0f);
        adress1.setId(123L);
        adress1.setHouseNomber("House Nomber");
        adress1.setTown("Oxford");
        adress1.setStreet("Street");
        assertFalse(adress.equals(adress1));
    }

    @Test
    public void testHashCode() {
        assertEquals(-199797932,
                (new Adress("Country", "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f)).hashCode());
        assertEquals(1977130041,
                (new Adress(null, "Oxford", "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f)).hashCode());
        assertEquals(-1251164983,
                (new Adress("Country", null, "Street", "House Nomber", "Extra House Definition", 10.0f, 10.0f)).hashCode());
        assertEquals(1748886556,
                (new Adress("Country", "Oxford", null, "House Nomber", "Extra House Definition", 10.0f, 10.0f)).hashCode());
        assertEquals(703206924,
                (new Adress("Country", "Oxford", "Street", null, "Extra House Definition", 10.0f, 10.0f)).hashCode());
        assertEquals(137864892, (new Adress("Country", "Oxford", "Street", "House Nomber", null, 10.0f, 10.0f)).hashCode());
    }
}

