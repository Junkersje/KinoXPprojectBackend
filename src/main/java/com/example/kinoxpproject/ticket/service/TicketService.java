package com.example.kinoxpproject.ticket.service;

import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.ticket.model.Ticket;
import com.example.kinoxpproject.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public List<Ticket> findAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket findTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow(() -> new IllegalStateException("no beer with that" + id));
    }
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id){
        boolean checkIfMovieExists = ticketRepository.existsById(id);
        if (!checkIfMovieExists){
            throw new IllegalStateException("does not exists" + id);
        }
        ticketRepository.deleteById(id);
    }

    public List<Ticket> findAllTicketsForMovieID(Long id){
        return ticketRepository
             .findAll()
             .stream()
             .filter(ticket -> ticket.getMovie().getId().equals(id))
             .collect(Collectors.toList());

    }

}
