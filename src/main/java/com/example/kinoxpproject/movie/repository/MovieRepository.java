package com.example.kinoxpproject.movie.repository;

import com.example.kinoxpproject.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
