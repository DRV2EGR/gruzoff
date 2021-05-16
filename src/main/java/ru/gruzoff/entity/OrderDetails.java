package ru.gruzoff.entity;

import java.util.Date;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails extends BaseEntity {
    @ManyToOne
    protected Adress adressFrom;
    @ManyToOne
    protected Adress adressTo;

    protected Date dateTime;
    protected float timeOnOrder;

    protected int loadersCapacity;

    @ManyToOne
    protected CarType carType;

    @Column(columnDefinition = "TEXT")
    protected String comment;
}
