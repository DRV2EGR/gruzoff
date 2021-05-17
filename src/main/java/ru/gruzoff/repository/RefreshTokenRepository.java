package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.RefreshToken;

/**
 * The interface Refresh token repository.
 */
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
