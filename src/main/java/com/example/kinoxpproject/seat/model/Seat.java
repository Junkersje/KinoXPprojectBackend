package com.example.kinoxpproject.seat.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Seat {

    @Id
    @GeneratedValue (GeneratedValue)

}
