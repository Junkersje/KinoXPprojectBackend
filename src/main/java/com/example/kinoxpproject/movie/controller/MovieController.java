package com.example.kinoxpproject.movie.controller;

import com.example.kinoxpproject.movie.dto.MovieDto;
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
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok().body(movieService.findAllMovies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(movieService.findMovieById(id));
    }

    @GetMapping("/availabletickets/{id}")
    public ResponseEntity<Boolean> checkAvailabletickets(@PathVariable("id") Long id){

        return ResponseEntity.ok().body(movieService.checkTicketsAvailable(id));
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto){
        return ResponseEntity.ok().body(movieService.createMovie(movieDto));
    }

    @PutMapping (value = "/{id}")
    ResponseEntity<MovieDto> update(@PathVariable("id") Long id, @Valid @RequestBody MovieDto movieDto){
        return ResponseEntity.ok().body(movieService.updateMovie(id,movieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id){
         movieService.deleteMovie(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }


}
