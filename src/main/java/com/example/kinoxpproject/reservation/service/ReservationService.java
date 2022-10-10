package com.example.kinoxpproject.reservation.service;

import com.example.kinoxpproject.movie.model.Movie;
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

    public ReservationDto findReservationById(Long id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new IllegalStateException("no reservation with that" + id));
        return reservationMapper.reservationToDto(reservation);
    }
    public ReservationDto createReservation(ReservationDto reservationDto){
        Reservation reservation = reservationMapper.dtoToReservation(reservationDto);
        return reservationMapper.reservationToDto(reservationRepository.save(reservation));
    }

    public ReservationDto updateReservation(Long id, ReservationDto reservationDto){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("no reservation with that" + id));
        reservationRepository.save(reservation);
        return reservationMapper.reservationToDto(reservation);
    }

    public void deleteReservation(Long id){
        boolean checkIfMovieExists = reservationRepository.existsById(id);
        if (!checkIfMovieExists){
            throw new IllegalStateException("does not exists" + id);
        }
        reservationRepository.deleteById(id);
    }
}
