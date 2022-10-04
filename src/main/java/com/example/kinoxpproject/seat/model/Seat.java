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

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    private int seatNumber;
    private int seatRow;
    private boolean isReserved;


}
