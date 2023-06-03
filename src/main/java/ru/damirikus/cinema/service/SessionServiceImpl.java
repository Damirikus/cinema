package ru.damirikus.cinema.service;

import org.springframework.stereotype.Service;
import ru.damirikus.cinema.model.CinemaSession;
import ru.damirikus.cinema.repository.SessionRepository;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<CinemaSession> getSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public boolean createSession(CinemaSession session) {
        sessionRepository.save(session);
        return true;
    }
}
