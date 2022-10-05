package com.example.kinoxpproject.ticket.model;
import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.seat.model.Seat;
import com.example.kinoxpproject.show.model.Show;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "ticket")
    private List<Reservation> reservations;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
}
