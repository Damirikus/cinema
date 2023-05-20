package ru.damirikus.cinema.service;

import ru.damirikus.cinema.model.Hall;

import java.util.List;

public interface HallService {

    List<Hall> getHalls();

    boolean createHall(Hall hall);

    void deleteHall(Long id);


}
