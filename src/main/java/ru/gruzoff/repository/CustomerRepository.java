package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.User;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
