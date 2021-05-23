package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Adress;

/**
 * The interface Adress repository.
 */
public interface AdressRepository extends JpaRepository<Adress, Long> {
}
