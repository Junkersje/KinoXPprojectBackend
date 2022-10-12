package com.example.kinoxpproject.ticket.repository;

import com.example.kinoxpproject.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findTicketBySeatNumber(int number);
}
