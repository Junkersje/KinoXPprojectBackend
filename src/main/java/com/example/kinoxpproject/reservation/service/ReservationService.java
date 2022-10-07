package com.example.kinoxpproject.reservation.service;

import com.example.kinoxpproject.reservation.dto.ReservationDto;
import com.example.kinoxpproject.reservation.dto.ReservationMapper;
import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

   private final ReservationRepository reservationRepository;
   private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }
    public List<ReservationDto> findAllReservations(){
        return reservationRepository
                .findAll()
                .stream()
                .map(reservationMapper::reservationToDto)
                .collect(Collectors.toList());
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
