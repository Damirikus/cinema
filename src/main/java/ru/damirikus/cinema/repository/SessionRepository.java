package ru.damirikus.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.damirikus.cinema.model.CinemaSession;

public interface SessionRepository extends JpaRepository<CinemaSession, Long> {
}
