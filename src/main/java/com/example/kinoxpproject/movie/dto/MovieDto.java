package com.example.kinoxpproject.movie.dto;

import com.example.kinoxpproject.movie.model.MovieGenre;
import com.example.kinoxpproject.theater.model.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private Theater theater;
    private boolean ticketsAvailable;
}
