package ru.gruzoff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.CarType;

/**
 * The interface Car type repository.
 */
public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}
