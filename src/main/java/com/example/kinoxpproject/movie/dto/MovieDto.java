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
    private String playTime;
    private MovieGenre movieGenre;
    private int PGRating;
    private String imgURL;
    private String description;
    private String date;
    private boolean ticketsAvailable;
    @JsonIgnore
    private Theater theater;
}
