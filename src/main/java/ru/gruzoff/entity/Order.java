package ru.gruzoff.entity;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Order.
 */
@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {
    /**
     * The Customer id.
     */
    @OneToOne
    @JoinColumn(name = "customerId")
    Customers customerId;

    /**
     * The Driver id.
     */
    @OneToOne
    @JoinColumn(name = "driverId")
    Drivers driverId;

    /**
     * The Car id.
     */
    @OneToOne
    @JoinColumn(name = "carId")
    Car carId;

    /**
     * The Price.
     */
    float price;

    /**
     * The Status.
     */
    protected String status;

    /**
     * The Order details.
     */
    @ManyToOne
    @JoinColumn(name = "order_details_id", referencedColumnName = "id")
    protected OrderDetails orderDetails;

    /**
     * The Loaders.
     */
    @ManyToMany
    @JoinColumn(name = "loaders_id", referencedColumnName = "id")
    protected List<Loaders> loaders;

    /**
     * The Extra customers.
     */
    @ManyToMany
    @JoinColumn(name = "extra_people_on_order_id", referencedColumnName = "id")
    protected List<Customers> extraCustomers;

    /**
     * The Sended.
     */
    protected boolean sended;


}
