package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
