package ru.gruzoff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Car;
import ru.gruzoff.entity.CarValidity;

public interface CarValidityRepository extends JpaRepository<CarValidity, Long> {
    Optional<CarValidity> findByCarId(Car car);
}
