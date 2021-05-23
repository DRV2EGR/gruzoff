package ru.gruzoff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.Drivers;
import ru.gruzoff.entity.User;

/**
 * The interface Drivers repository.
 */
public interface DriversRepository extends JpaRepository<Drivers, Long> {
    /**
     * Find by user optional.
     *
     * @param user the user
     * @return the optional
     */
    Optional<Drivers> findByUser(User user);
}
