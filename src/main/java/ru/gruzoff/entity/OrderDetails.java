package ru.gruzoff.entity;

import java.util.Date;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Order details.
 */
@Entity
@Table(name = "order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails extends BaseEntity {
    /**
     * The Adress from.
     */
    @ManyToOne
    protected Adress adressFrom;
    /**
     * The Adress to.
     */
    @ManyToOne
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
     * The Car type.
     */
    @ManyToOne
    protected CarType carType;

    /**
     * The Comment.
     */
    @Column(columnDefinition = "TEXT")
    protected String comment;
}
