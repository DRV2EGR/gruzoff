package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressDto {
    protected String country;
    protected String town;
    protected String street;
    protected String houseNomber;
    protected String extraHouseDefinition;
}
