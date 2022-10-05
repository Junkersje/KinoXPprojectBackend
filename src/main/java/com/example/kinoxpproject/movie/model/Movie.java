package com.example.kinoxpproject.movie.model;



import com.example.kinoxpproject.theater.model.Theater;
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

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToMany(cascade = {
            CascadeType.MERGE
    })
    @JoinTable(name = "movie_theater_id",
            joinColumns = @JoinColumn(name = "theater_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Theater> theaterList = new ArrayList<>();








}
