package ru.gruzoff.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.Loaders;
import ru.gruzoff.entity.User;

/**
 * The interface Loaders repository.
 */
public interface LoadersRepository extends JpaRepository<Loaders, Long> {
    /**
     * Find by user optional.
     *
     * @param user the user
     * @return the optional
     */
    Optional<Loaders> findByUser(User user);

    /**
     * Find all by user list.
     *
     * @param user the user
     * @return the list
     */
    List<Optional<Object>> findAllByUser(User user);
}
