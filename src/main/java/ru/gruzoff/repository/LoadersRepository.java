package ru.gruzoff.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.Loaders;
import ru.gruzoff.entity.User;

public interface LoadersRepository extends JpaRepository<Loaders, Long> {
    Optional<Loaders> findByUser(User user);

    List<Optional<Object>> findAllByUser(User user);
}
