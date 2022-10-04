package com.example.kinoxpproject.movie.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Movie {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String playTime;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private Long PGRating;
    private String imgURL;
    private String description;

}
