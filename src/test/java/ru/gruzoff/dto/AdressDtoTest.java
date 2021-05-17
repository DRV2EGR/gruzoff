package ru.gruzoff.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AdressDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse(
                (new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertTrue(
                adressDto.canEqual(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testConstructor() {
        AdressDto actualAdressDto = new AdressDto();
        actualAdressDto.setCountry("Country");
        actualAdressDto.setExtraHouseDefinition("Extra House Definition");
        actualAdressDto.setHouseNomber("House Nomber");
        actualAdressDto.setStreet("Street");
        actualAdressDto.setTown("Oxford");
        assertEquals("Country", actualAdressDto.getCountry());
        assertEquals("Extra House Definition", actualAdressDto.getExtraHouseDefinition());
        assertEquals("House Nomber", actualAdressDto.getHouseNomber());
        assertEquals("Street", actualAdressDto.getStreet());
        assertEquals("Oxford", actualAdressDto.getTown());
        assertEquals(
                "AdressDto(country=Country, town=Oxford, street=Street, houseNomber=House Nomber, extraHouseDefinition=Extra"
                        + " House Definition)",
                actualAdressDto.toString());
    }

    @Test
    public void testConstructor2() {
        AdressDto actualAdressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        actualAdressDto.setCountry("Country");
        actualAdressDto.setExtraHouseDefinition("Extra House Definition");
        actualAdressDto.setHouseNomber("House Nomber");
        actualAdressDto.setStreet("Street");
        actualAdressDto.setTown("Oxford");
        assertEquals("Country", actualAdressDto.getCountry());
        assertEquals("Extra House Definition", actualAdressDto.getExtraHouseDefinition());
        assertEquals("House Nomber", actualAdressDto.getHouseNomber());
        assertEquals("Street", actualAdressDto.getStreet());
        assertEquals("Oxford", actualAdressDto.getTown());
        assertEquals(
                "AdressDto(country=Country, town=Oxford, street=Street, houseNomber=House Nomber, extraHouseDefinition=Extra"
                        + " House Definition)",
                actualAdressDto.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")).equals("42"));
    }

    @Test
    public void testEquals10() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", null, "Extra House Definition");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals11() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Country");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals12() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", null);
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals13() {
        AdressDto adressDto = new AdressDto(null, "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(adressDto.equals(new AdressDto()));
    }

    @Test
    public void testEquals14() {
        AdressDto adressDto = new AdressDto();
        assertTrue(adressDto.equals(new AdressDto()));
    }

    @Test
    public void testEquals2() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertTrue(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals3() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(adressDto.equals(new AdressDto()));
    }

    @Test
    public void testEquals4() {
        AdressDto adressDto = new AdressDto(null, "Oxford", "Street", "House Nomber", "Extra House Definition");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals5() {
        AdressDto adressDto = new AdressDto("Country", "Country", "Street", "House Nomber", "Extra House Definition");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals6() {
        AdressDto adressDto = new AdressDto("Country", null, "Street", "House Nomber", "Extra House Definition");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals7() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Country", "House Nomber", "Extra House Definition");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals8() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", null, "House Nomber", "Extra House Definition");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testEquals9() {
        AdressDto adressDto = new AdressDto("Country", "Oxford", "Street", "Country", "Extra House Definition");
        assertFalse(
                adressDto.equals(new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")));
    }

    @Test
    public void testHashCode() {
        assertEquals(1225008588,
                (new AdressDto("Country", "Oxford", "Street", "House Nomber", "Extra House Definition")).hashCode());
        assertEquals(-893030735,
                (new AdressDto(null, "Oxford", "Street", "House Nomber", "Extra House Definition")).hashCode());
        assertEquals(173641537,
                (new AdressDto("Country", null, "Street", "House Nomber", "Extra House Definition")).hashCode());
        assertEquals(-1121274220,
                (new AdressDto("Country", "Oxford", null, "House Nomber", "Extra House Definition")).hashCode());
        assertEquals(2128013444, (new AdressDto("Country", "Oxford", "Street", null, "Extra House Definition")).hashCode());
        assertEquals(1562671412, (new AdressDto("Country", "Oxford", "Street", "House Nomber", null)).hashCode());
    }
}

