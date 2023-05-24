package ru.damirikus.cinema.service;

import org.springframework.stereotype.Service;
import ru.damirikus.cinema.model.Film;
import ru.damirikus.cinema.repository.FilmRepository;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film createFilm(Film film) {
        if (filmRepository.findByTitle(film.getTitle()) != null){
            throw new RuntimeException("Film is already exists!");
        }
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Long id) {

    }
}
