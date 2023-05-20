package ru.damirikus.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.damirikus.cinema.model.Hall;
import ru.damirikus.cinema.service.HallService;

import java.util.List;

@Controller
@RequestMapping("/admin/panel")
public class CinemaController {

    private final HallService hallService;

    public CinemaController(HallService hallService) {
        this.hallService = hallService;
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
    public String deleteHall(Model model,
                             @PathVariable Long id){
        System.out.println("ID = " + id);
        hallService.deleteHall(id);
        List<Hall> halls = hallService.getHalls();
        model.addAttribute("halls", halls);
        return "halls";
    }

    @GetMapping("/films")
    public String getFilms(Model model){
//        List<Film> halls = service.getHalls();
//        model.addAttribute("halls", halls);
        return "films";
    }
}
