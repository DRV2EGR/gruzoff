package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.OrderDetails;

public interface OrderDetailsReposirory extends JpaRepository<OrderDetails, Long> {
}
