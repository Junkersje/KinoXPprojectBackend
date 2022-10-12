package com.example.kinoxpproject.movie.model;



import com.example.kinoxpproject.theater.model.Theater;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String playTime;
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;
    private int PGRating;
    private String imgURL;
    private String description;
    private String date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private boolean ticketsAvailable;

    public Movie(String title, String playTime, MovieGenre movieGenre, int PGRating, String imgURL, String description, String date, Theater theater, boolean ticketsAvailable) {
        this.title = title;
        this.playTime = playTime;
        this.movieGenre = movieGenre;
        this.PGRating = PGRating;
        this.imgURL = imgURL;
        this.description = description;
        this.date = date;
        this.theater = theater;
        this.ticketsAvailable = ticketsAvailable;
    }
}
