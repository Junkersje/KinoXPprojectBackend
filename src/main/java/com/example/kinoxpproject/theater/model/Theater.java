package com.example.kinoxpproject.theater.model;

import com.example.kinoxpproject.movie.model.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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


    @ManyToMany(mappedBy = "theaterList")
    private List<Movie> movieList = new ArrayList<>();












}
