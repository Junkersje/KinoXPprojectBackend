package com.example.kinoxpproject.reservation.dto;
import com.example.kinoxpproject.ticket.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long id;
    private String email;
    private int numberOfPersons;
    private List<Ticket> ticketList;
}
