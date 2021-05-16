package ru.gruzoff.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<Optional<User>> findAllByActivationCodeNotNull();

    Optional<User> findByActivationCode(String encodedUserActivationCode);
}
