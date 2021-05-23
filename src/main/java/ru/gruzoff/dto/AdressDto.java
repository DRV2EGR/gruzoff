package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Adress dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressDto {
    /**
     * The Country.
     */
    protected String country;
    /**
     * The Town.
     */
    protected String town;
    /**
     * The Street.
     */
    protected String street;
    /**
     * The House nomber.
     */
    protected String houseNomber;
    /**
     * The Extra house definition.
     */
    protected String extraHouseDefinition;
}
