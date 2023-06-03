package ru.damirikus.cinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "film_session")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaSession {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Double price;
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "f_id")
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "h_id")
    private Hall hall;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaSession that = (CinemaSession) o;
        return getId().equals(that.getId()) && getPrice().equals(that.getPrice()) && Objects.equals(getFilm(), that.getFilm()) && Objects.equals(getHall(), that.getHall());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getFilm(), getHall());
    }

    @Override
    public String toString() {
        return "CinemaSession{" +
                "id=" + id +
                ", price=" + price +
                ", film=" + film +
                ", hall=" + hall +
                '}';
    }
}
