package com.example.kinoxpproject.reservation.repository.ticket.repository;

import com.example.kinoxpproject.reservation.repository.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
