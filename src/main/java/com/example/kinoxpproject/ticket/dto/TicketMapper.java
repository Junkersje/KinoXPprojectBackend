package com.example.kinoxpproject.ticket.dto;

import com.example.kinoxpproject.movie.dto.MovieDto;
import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.ticket.model.Ticket;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    private final ModelMapper modelMapper;

    public TicketMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TicketDto ticketToDto(Ticket ticket){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(ticket,TicketDto.class);
    }
    public Ticket dtoToTicket(TicketDto ticketDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(ticketDto,Ticket.class);
    }
}
