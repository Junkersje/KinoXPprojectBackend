package com.example.kinoxpproject.movie.controller;

import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok().body(movieService.findAllMovies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(movieService.findMovieById(id));
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie){
        return ResponseEntity.ok().body(movieService.createMovie(movie));
    }

    @PutMapping (value = "/{id}")
    ResponseEntity<Movie> update(@PathVariable("id") Long id, @Valid @RequestBody Movie movie){
        return ResponseEntity.ok().body(movieService.updateMovie(id,movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id){
         movieService.deleteMovie(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }


}
