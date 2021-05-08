package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
