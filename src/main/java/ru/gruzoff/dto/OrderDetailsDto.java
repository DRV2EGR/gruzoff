package ru.gruzoff.dto;

import java.util.Date;

import javax.persistence.Column;
import lombok.Data;

@Data
public class OrderDetailsDto {
    protected String country;
    protected String town;
    protected String street;
    protected String houseNomber;
    protected String extraHouseDefinition;

    protected Date dateTime;
    protected int timeOnOrder;

    protected String comment;
}
