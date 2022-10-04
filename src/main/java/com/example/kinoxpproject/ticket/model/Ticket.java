package com.example.kinoxpproject.ticket.model;

import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.seat.model.Seat;
import com.example.kinoxpproject.theater.model.Theater;
import lombok.*;

import javax.persistence.*;
import java.security.PrivateKey;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Reservation reservation;


    //sal sæde id voksen pris
}
