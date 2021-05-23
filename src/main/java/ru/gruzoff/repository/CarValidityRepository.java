package ru.gruzoff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Car;
import ru.gruzoff.entity.CarValidity;

/**
 * The interface Car validity repository.
 */
public interface CarValidityRepository extends JpaRepository<CarValidity, Long> {
    /**
     * Find by car id optional.
     *
     * @param car the car
     * @return the optional
     */
    Optional<CarValidity> findByCarId(Car car);
}
