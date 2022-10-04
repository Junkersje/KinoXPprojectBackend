package com.example.kinoxpproject.reservation.repository;

import com.example.kinoxpproject.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
