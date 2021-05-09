package ru.gruzoff.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import ru.gruzoff.entity.*;

@Data
public class OrderDto {
    protected UserDto customer;
    protected UserDto driver;

    protected CarDto car;

    protected int price;
    protected String status;
    protected OrderDetailsDto orderDetails;

    protected List<UserDto> loaders;
    protected List<UserDto> extraCustomers;
}
