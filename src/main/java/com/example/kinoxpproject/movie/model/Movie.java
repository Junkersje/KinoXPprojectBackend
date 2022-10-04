package com.example.kinoxpproject.movie.model;


import com.example.kinoxpproject.show.model.Show;
import lombok.*;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    private int PGRating;
    private String imgURL;
    private String description;

    @OneToMany(mappedBy = "movie")
    private List<Show> showList;

}
