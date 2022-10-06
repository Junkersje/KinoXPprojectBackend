package com.example.kinoxpproject.reservation.controller;

import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.reservation.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return ResponseEntity.ok().body(reservationService.findAllReservations());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(reservationService.findReservationById(id));
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation){
        return ResponseEntity.ok().body(reservationService.createReservation(reservation));
    }

    @PutMapping (value = "/{id}")
    ResponseEntity<Reservation> updateReservation(@PathVariable("id") Long id, @Valid @RequestBody Reservation reservation){
        return ResponseEntity.ok().body(reservationService.updateReservation(id,reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
