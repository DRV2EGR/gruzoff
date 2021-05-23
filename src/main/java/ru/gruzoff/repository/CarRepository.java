package ru.gruzoff.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Car;
import ru.gruzoff.entity.CarType;

/**
 * The interface Car repository.
 */
public interface CarRepository extends JpaRepository<Car, Long> {
    /**
     * Find by id and type optional.
     *
     * @param id      the id
     * @param carType the car type
     * @return the optional
     */
    Optional<Car> findByIdAndType(long id, CarType carType);
}
