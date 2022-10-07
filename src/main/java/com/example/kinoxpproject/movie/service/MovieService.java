package com.example.kinoxpproject.movie.service;

import com.example.kinoxpproject.movie.dto.MovieDto;
import com.example.kinoxpproject.movie.dto.MovieMapper;
import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDto> findAllMovies(){
        return movieRepository
                .findAll()
                .stream()
                .map(movieMapper::movieToDto)
                .collect(Collectors.toList());
    }

    public MovieDto findMovieById(Long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("no beer with that" + id));
        return movieMapper.movieToDto(movie);
    }

    public MovieDto createMovie(MovieDto movieDto){
        Movie movie = movieMapper.dtoToMovie(movieDto);
        return movieMapper.movieToDto(movieRepository.save(movie));
    }

    public MovieDto updateMovie(Long id, MovieDto movieDto){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("no beer with that" + id));
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movieRepository.save(movie);
        return movieMapper.movieToDto(movie);
    }

    public void deleteMovie(Long id){
        boolean checkIfMovieExists = movieRepository.existsById(id);
        if (!checkIfMovieExists){
            throw new IllegalStateException("does not exists" + id);
        }
        movieRepository.deleteById(id);
    }
}
