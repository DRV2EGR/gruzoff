package ru.gruzoff.payload;

import java.util.Date;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.Adress;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDtoPayload {
    protected Adress adressFrom;
    protected Adress adressTo;

    protected Date dateTime;
    protected float timeOnOrder;
    protected int loadersCapacity;

    protected String comment;
}
