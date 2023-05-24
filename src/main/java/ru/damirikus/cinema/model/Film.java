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
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private int year;
    private int age;
    private String filename;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return getYear() == film.getYear() && getAge() == film.getAge() && getId().equals(film.getId()) && getTitle().equals(film.getTitle()) && Objects.equals(getFilename(), film.getFilename()) && Objects.equals(getDescription(), film.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getYear(), getAge(), getFilename(), getDescription());
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", age=" + age +
                ", filename='" + filename + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
