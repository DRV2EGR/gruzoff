package ru.gruzoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gruzoff.entity.Likes;

public interface LikesRepository extends JpaRepository<Likes, Long> {
}
