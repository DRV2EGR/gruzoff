package ru.gruzoff.dto;

import java.util.Date;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.Adress;

/**
 * The type Order details dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    /**
     * The Adress from.
     */
    protected AdressDto adressFrom;
    /**
     * The Adress to.
     */
    protected AdressDto adressTo;

    /**
     * The Date time.
     */
    protected Date dateTime;
    /**
     * The Time on order.
     */
    protected float timeOnOrder;
    /**
     * The Loaders capacity.
     */
    protected int loadersCapacity;

    /**
     * The Comment.
     */
    protected String comment;
}
