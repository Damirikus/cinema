package ru.damirikus.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.damirikus.cinema.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByTitle(String title);
}
