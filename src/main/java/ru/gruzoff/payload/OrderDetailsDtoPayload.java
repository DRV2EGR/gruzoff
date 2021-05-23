package ru.gruzoff.payload;

import java.util.Date;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.Adress;

/**
 * The type Order details dto payload.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDtoPayload {
    /**
     * The Adress from.
     */
    protected Adress adressFrom;
    /**
     * The Adress to.
     */
    protected Adress adressTo;

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
