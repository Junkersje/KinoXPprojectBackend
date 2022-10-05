package com.example.kinoxpproject.ticket.repository;

import com.example.kinoxpproject.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
