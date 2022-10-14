package com.example.kinoxpproject.movie.dto;

import com.example.kinoxpproject.movie.model.MovieGenre;
import com.example.kinoxpproject.theater.model.Theater;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;
    private String title;
    private String play_time;
    private MovieGenre movie_genre;
    private int pgrating;
    private String imgurl;
    private String description;
    private String date;
    private boolean tickets_available;
    private Theater theater_id;
}
