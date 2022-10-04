package com.example.kinoxpproject.seat.model;

import com.example.kinoxpproject.ticket.model.Ticket;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Seat {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    private boolean isReserved;
    private int seatNumber;
    private int row;
     */
    @OneToOne(mappedBy = "seat")
    private Ticket ticket;


}
