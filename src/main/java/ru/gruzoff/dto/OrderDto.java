package ru.gruzoff.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.*;

/**
 * The type Order dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    /**
     * The Id.
     */
    protected long id;

    /**
     * The Customer.
     */
    protected UserDto customer;
    /**
     * The Driver.
     */
    protected UserDto driver;

    /**
     * The Car.
     */
    protected CarDto car;

    /**
     * The Price.
     */
    protected float price;
    /**
     * The Status.
     */
    protected String status;
    /**
     * The Order details.
     */
    protected OrderDetailsDto orderDetails;

    /**
     * The Loaders.
     */
    protected List<UserDto> loaders;
    /**
     * The Extra customers.
     */
    protected List<UserDto> extraCustomers;
}
