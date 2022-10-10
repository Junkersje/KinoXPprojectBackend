package com.example.kinoxpproject.theater.dto;

import com.example.kinoxpproject.movie.dto.MovieDto;
import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.theater.model.Theater;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {

    private final ModelMapper modelMapper;

    public TheaterMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TheaterDto theaterToDto(Theater theater){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(theater,TheaterDto.class);
    }
    public Theater dtoToTheater(TheaterDto theaterDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(theaterDto,Theater.class);
    }
}
