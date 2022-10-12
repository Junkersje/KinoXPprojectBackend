package com.example.kinoxpproject.theater.controller;

import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.theater.dto.TheaterDto;
import com.example.kinoxpproject.theater.model.Theater;
import com.example.kinoxpproject.theater.service.TheaterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/theaters")
public class TheaterController {

    private final TheaterService theaterService;
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public ResponseEntity<List<TheaterDto>> getAllTheaters(){
        return ResponseEntity.ok().body(theaterService.findAllTheaters());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TheaterDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(theaterService.findTheaterById(id));
    }

    @PostMapping
    public ResponseEntity<TheaterDto> createTheater(@Valid @RequestBody TheaterDto theaterDto){
        return ResponseEntity.ok().body(theaterService.createTheater(theaterDto));
    }

    @PutMapping (value = "/{id}")
    ResponseEntity<TheaterDto> updateTheater(@PathVariable("id") Long id, @Valid @RequestBody TheaterDto theaterDto){
        return ResponseEntity.ok().body(theaterService.updateTheater(id,theaterDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheater(@PathVariable("id") Long id){
        theaterService.deleteTheater(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
