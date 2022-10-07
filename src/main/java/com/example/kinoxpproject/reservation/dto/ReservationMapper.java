package com.example.kinoxpproject.reservation.dto;

import com.example.kinoxpproject.movie.dto.MovieDto;
import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.reservation.model.Reservation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    private final ModelMapper modelMapper;

    public ReservationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ReservationDto reservationToDto(Reservation reservation){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(reservation,ReservationDto.class);
    }
    public Reservation dtoToReservation(ReservationDto reservationDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(reservationDto,Reservation.class);
    }
}
