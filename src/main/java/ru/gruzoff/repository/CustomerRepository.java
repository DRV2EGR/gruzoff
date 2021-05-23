package ru.gruzoff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.User;

/**
 * The interface Customer repository.
 */
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    /**
     * Find by user optional.
     *
     * @param user the user
     * @return the optional
     */
    Optional<Customers> findByUser(User user);
}
