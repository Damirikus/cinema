package ru.damirikus.cinema.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.damirikus.cinema.model.CinemaSession;
import ru.damirikus.cinema.model.Film;
import ru.damirikus.cinema.model.Hall;
import ru.damirikus.cinema.service.FilmService;
import ru.damirikus.cinema.service.HallService;
import ru.damirikus.cinema.service.SessionService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/panel")
public class CinemaController {

    @Value("${upload.path.posters}")
    private String path;

    private final HallService hallService;
    private final FilmService filmService;
    private final SessionService sessionService;

    public CinemaController(HallService hallService, FilmService filmService, SessionService sessionService) {
        this.hallService = hallService;
        this.filmService = filmService;
        this.sessionService = sessionService;
    }

    @GetMapping("/halls")
    public String getHallList(Model model){
        List<Hall> halls = hallService.getHalls();
        model.addAttribute("halls", halls);
        return "halls";
    }

    @PostMapping("/halls")
    public String addHall(Model model, Hall hall){
        hallService.createHall(hall);
        List<Hall> halls = hallService.getHalls();
        model.addAttribute("halls", halls);
        return "halls";
    }

    @PostMapping("/halls/{id}")
    public String deleteHall(Model model, @PathVariable Long id){
        System.out.println("ID = " + id);
        hallService.deleteHall(id);
        List<Hall> halls = hallService.getHalls();
        model.addAttribute("halls", halls);
        return "halls";
    }

    @GetMapping("/films")
    public String getFilms(Model model){
        model.addAttribute("films", filmService.getFilms());
        return "films";
    }

    @PostMapping("/films")
    public String addFilm(Film film, @RequestParam("poster") MultipartFile file) throws IOException {
        System.out.println("Film - " + film);


        if (!Files.isDirectory(Paths.get(path))){
            Files.createDirectory(Paths.get(path));
        }

        String result = UUID.randomUUID() + "." + file.getOriginalFilename();
        film.setFilename(result);
        file.transferTo(new File(path + "/" + result));

        System.out.println("Film with filename - " + film);

        Film addedFilm = filmService.createFilm(film);
        System.out.println("Added file - " + addedFilm);
        return "redirect:films";
    }



    @GetMapping("/sessions")
    public String getSessions(Model model){
        model.addAttribute("sessions", sessionService.getSessions());
        model.addAttribute("films", filmService.getFilms());
        model.addAttribute("halls", hallService.getHalls());
        return "sessions";
    }


    @PostMapping("/sessions")
    public String createSession(CinemaSession session){
        sessionService.createSession(session);
        return "redirect:sessions";
    }
}
