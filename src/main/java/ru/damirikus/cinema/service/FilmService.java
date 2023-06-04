package ru.damirikus.cinema.service;

import ru.damirikus.cinema.model.Film;
import ru.damirikus.cinema.model.Hall;

import java.util.List;

public interface FilmService {

    List<Film> getFilms();

    Film createFilm(Film film);

    Film getFilmByTitle(String title);

    void deleteFilm(Long id);
}
