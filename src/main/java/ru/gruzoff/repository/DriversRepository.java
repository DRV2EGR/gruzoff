package ru.gruzoff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.Drivers;
import ru.gruzoff.entity.User;

public interface DriversRepository extends JpaRepository<Drivers, Long> {
    Optional<Drivers> findByUser(User user);
}
