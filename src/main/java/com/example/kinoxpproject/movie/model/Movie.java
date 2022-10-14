package com.example.kinoxpproject.movie.model;



import com.example.kinoxpproject.theater.model.Theater;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

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
    private String play_time;
    @Enumerated(EnumType.STRING)
    private MovieGenre movie_genre;
    private int pgrating;
    private String imgurl;
    private String description;
    private String date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "theater_id")
    @Nullable
    private Theater theater_id;

    private boolean tickets_available;

    public Movie(String title, String play_time, MovieGenre movie_genre, int pgrating, String imgurl, String description, String date, Theater theater_id, boolean tickets_available) {
        this.title = title;
        this.play_time = play_time;
        this.movie_genre = movie_genre;
        this.pgrating = pgrating;
        this.imgurl = imgurl;
        this.description = description;
        this.date = date;
        this.theater_id = theater_id;
        this.tickets_available = tickets_available;
    }
}
