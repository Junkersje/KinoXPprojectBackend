package com.example.kinoxpproject.ticket.model;
import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.reservation.model.Reservation;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int seatNumber;
    private int price;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToMany(mappedBy = "ticketList")
    private List<Reservation> reservations = new ArrayList<>();

    public Ticket(int seatNumber, int price, Movie movie, List<Reservation> reservations) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.movie = movie;
        this.reservations = reservations;
    }
}
