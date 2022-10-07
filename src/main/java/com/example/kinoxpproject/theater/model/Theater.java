package com.example.kinoxpproject.theater.model;

import com.example.kinoxpproject.movie.model.Movie;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfSeats;
    private int theaterNumber;
    private boolean isFull;

    public Theater(int numberOfSeats, int theaterNumber, boolean isFull) {
        this.numberOfSeats = numberOfSeats;
        this.theaterNumber = theaterNumber;
        this.isFull = isFull;
    }
}
