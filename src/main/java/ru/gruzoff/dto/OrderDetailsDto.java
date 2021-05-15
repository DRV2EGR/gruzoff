package ru.gruzoff.dto;

import java.util.Date;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.Adress;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    protected AdressDto adressFrom;
    protected AdressDto adressTo;

    protected Date dateTime;
    protected float timeOnOrder;

    protected String comment;
}
