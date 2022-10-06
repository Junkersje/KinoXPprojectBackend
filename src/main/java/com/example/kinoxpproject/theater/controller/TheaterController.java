package com.example.kinoxpproject.theater.controller;

import com.example.kinoxpproject.reservation.model.Reservation;
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
    public ResponseEntity<List<Theater>> getAllTheaters(){
        return ResponseEntity.ok().body(theaterService.findAllTheaters());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Theater> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(theaterService.findTheaterById(id));
    }

    @PostMapping
    public ResponseEntity<Theater> createTheater(@Valid @RequestBody Theater theater){
        return ResponseEntity.ok().body(theaterService.createTheater(theater));
    }

    @PutMapping (value = "/{id}")
    ResponseEntity<Theater> updateTheater(@PathVariable("id") Long id, @Valid @RequestBody Theater theater){
        return ResponseEntity.ok().body(theaterService.updateTheater(id,theater));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheater(@PathVariable("id") Long id){
        theaterService.deleteTheater(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
