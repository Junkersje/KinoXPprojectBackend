package com.example.kinoxpproject.movie.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;
    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;

}
