package com.example.kinoxpproject.movie.service;

import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    public Movie findMovieById(Long id){
        return movieRepository.findById(id).orElseThrow(() -> new IllegalStateException("no beer with that" + id));
    }
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id){
        boolean checkIfMovieExists = movieRepository.existsById(id);
        if (!checkIfMovieExists){
            throw new IllegalStateException("does not exists" + id);
        }
        movieRepository.deleteById(id);
    }




}
