package ru.damirikus.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.damirikus.cinema.model.Hall;

public interface HallRepository extends JpaRepository<Hall, Long> {

    Hall findByName(String name);

}
