package com.example.kinoxpproject.theater.service;

import com.example.kinoxpproject.theater.dto.TheaterDto;
import com.example.kinoxpproject.theater.dto.TheaterMapper;
import com.example.kinoxpproject.theater.model.Theater;
import com.example.kinoxpproject.theater.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;

    public TheaterService(TheaterRepository theaterRepository, TheaterMapper theaterMapper) {
        this.theaterRepository = theaterRepository;
        this.theaterMapper = theaterMapper;
    }

    public List<TheaterDto> findAllTheaters(){
        return theaterRepository
                .findAll()
                .stream()
                .map(theaterMapper::theaterToDto)
                .collect(Collectors.toList());
    }

    public TheaterDto findTheaterById(Long id){
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new IllegalStateException("no theater with that" + id));
        return theaterMapper.theaterToDto(theater);
    }
    public TheaterDto createTheater(TheaterDto theaterDto) {
        Theater theater = theaterMapper.dtoToTheater(theaterDto);
        return theaterMapper.theaterToDto(theaterRepository.save(theater));
    }

    public TheaterDto updateTheater(Long id, TheaterDto theaterDto){
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new IllegalStateException("no theater with that" + id));
        theaterRepository.save(theater);
        return theaterMapper.theaterToDto(theater);
    }

    public void deleteTheater(Long id){
        boolean checkIfTheaterExists = theaterRepository.existsById(id);
        if (!checkIfTheaterExists){
            throw new IllegalStateException("does not exists" + id);
        }
        theaterRepository.deleteById(id);
    }
}
