package com.example.kinoxpproject.ticket.controller;

import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.ticket.dto.TicketDto;
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
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        return ResponseEntity.ok().body(ticketService.findAllTickets());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(ticketService.findTicketById(id));
    }

    @GetMapping("/ticketlisttest/{id}")
    public ResponseEntity<List<TicketDto>> getAllTicketsByMovieId(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(ticketService.findAllTicketsForMovieID(id));
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody TicketDto ticketDto){
        return ResponseEntity.ok().body(ticketService.createTicket(ticketDto));
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<TicketDto> updateTicket(@PathVariable("id") Long id, @Valid @RequestBody TicketDto ticketDto){
        return ResponseEntity.ok().body(ticketService.updateTicket(id,ticketDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
