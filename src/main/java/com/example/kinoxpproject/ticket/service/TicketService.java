package com.example.kinoxpproject.ticket.service;

import com.example.kinoxpproject.ticket.dto.TicketDto;
import com.example.kinoxpproject.ticket.dto.TicketMapper;
import com.example.kinoxpproject.ticket.model.Ticket;
import com.example.kinoxpproject.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;


    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }


    public List<TicketDto> findAllTickets(){
        return ticketRepository
                .findAll()
                .stream()
                .map(ticketMapper::ticketToDto)
                .collect(Collectors.toList());
    }

    public TicketDto findTicketById(Long id){
        Ticket ticket =  ticketRepository.findById(id).orElseThrow(() -> new IllegalStateException("no ticket with that" + id));
        return ticketMapper.ticketToDto(ticket);
    }
    public TicketDto createTicket(TicketDto ticketDto){
        Ticket ticket = ticketMapper.dtoToTicket(ticketDto);
        return ticketMapper.ticketToDto(ticketRepository.save(ticket));
    }

    public TicketDto updateTicket(Long id, TicketDto ticketDto){
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new IllegalStateException("no ticket with that" + id));
        ticketRepository.save(ticket);
        return ticketMapper.ticketToDto(ticket);
    }

    public void deleteTicket(Long id){
        boolean checkIfMovieExists = ticketRepository.existsById(id);
        if (!checkIfMovieExists){
            throw new IllegalStateException("does not exists" + id);
        }
        ticketRepository.deleteById(id);
    }

    public List<TicketDto> findAllTicketsForMovieID(Long id){
        return findAllTickets()
                .stream()
                .filter(ticketDto -> ticketDto.getMovie().getId().equals(id))
                .collect(Collectors.toList());

    }

}
