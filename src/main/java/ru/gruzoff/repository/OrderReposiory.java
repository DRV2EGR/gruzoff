package ru.gruzoff.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.User;

public interface OrderReposiory extends JpaRepository<Order, Long> {
    Optional<Order> findByIdAndCustomerId(long id, Customers customerId);

    Optional<Order> findAllByCustomerIdAndOrderDetailsDateTimeBetween(Customers customer, Date date1, Date date2);
}
