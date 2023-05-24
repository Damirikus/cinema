package ru.damirikus.cinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "seats_num", nullable = false)
    private int seatsNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return getSeatsNumber() == hall.getSeatsNumber() && Objects.equals(getName(), hall.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSeatsNumber());
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatsNumber=" + seatsNumber +
                '}';
    }
}
