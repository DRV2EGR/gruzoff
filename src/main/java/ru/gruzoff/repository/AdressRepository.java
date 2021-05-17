package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long> {
}
