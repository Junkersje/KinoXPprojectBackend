package com.example.kinoxpproject.ticket.controller;

import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.ticket.model.Ticket;
import com.example.kinoxpproject.ticket.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets(){
        return ResponseEntity.ok().body(ticketService.findAllTickets());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(ticketService.findTicketById(id));
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket){
        return ResponseEntity.ok().body(ticketService.createTicket(ticket));
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Ticket> updateTicket(@PathVariable("id") Long id, @Valid @RequestBody Ticket ticket){
        return ResponseEntity.ok().body(ticketService.updateTicket(id,ticket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
