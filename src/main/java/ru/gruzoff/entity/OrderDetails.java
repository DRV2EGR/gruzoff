package ru.gruzoff.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_details")
@Data
public class OrderDetails extends BaseEntity {
    protected String country;
    protected String town;
    protected String street;
    protected String houseNomber;
    protected String extraHouseDefinition;

    protected Date dateTime;
    protected int timeOnOrder;

    @Column(columnDefinition = "TEXT")
    protected String comment;
}
