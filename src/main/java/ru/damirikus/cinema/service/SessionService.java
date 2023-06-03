package ru.damirikus.cinema.service;

import ru.damirikus.cinema.model.CinemaSession;
import ru.damirikus.cinema.model.Hall;

import java.util.List;

public interface SessionService {
    List<CinemaSession> getSessions();

    boolean createSession(CinemaSession session);
}
