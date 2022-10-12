package com.example.kinoxpproject.theater.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterDto {
    private Long id;
    private int numberOfSeats;
    private int theaterNumber;
}
