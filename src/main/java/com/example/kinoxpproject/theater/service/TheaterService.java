package com.example.kinoxpproject.theater.service;

import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.reservation.repository.ReservationRepository;
import com.example.kinoxpproject.theater.model.Theater;
import com.example.kinoxpproject.theater.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> findAllTheaters(){
        return theaterRepository.findAll();
    }

    public Theater findTheaterById(Long id){
        return theaterRepository.findById(id).orElseThrow(() -> new IllegalStateException("no beer with that" + id));
    }
    public Theater createTheater(Theater theater){
        return theaterRepository.save(theater);
    }

    public Theater updateTheater(Long id, Theater theater){
        return theaterRepository.save(theater);
    }

    public void deleteTheater(Long id){
        boolean checkIfMovieExists = theaterRepository.existsById(id);
        if (!checkIfMovieExists){
            throw new IllegalStateException("does not exists" + id);
        }
        theaterRepository.deleteById(id);
    }
}
