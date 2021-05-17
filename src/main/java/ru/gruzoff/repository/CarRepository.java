package ru.gruzoff.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Car;
import ru.gruzoff.entity.CarType;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByIdAndType(long id, CarType carType);
}
