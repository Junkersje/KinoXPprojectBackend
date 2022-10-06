package com.example.kinoxpproject.reservation.service;

import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

   private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation findReservationById(Long id){
        return reservationRepository.findById(id).orElseThrow(() -> new IllegalStateException("no beer with that" + id));
    }
    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id){
        boolean checkIfMovieExists = reservationRepository.existsById(id);
        if (!checkIfMovieExists){
            throw new IllegalStateException("does not exists" + id);
        }
        reservationRepository.deleteById(id);
    }
}
