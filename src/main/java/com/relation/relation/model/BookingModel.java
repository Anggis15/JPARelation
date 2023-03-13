package com.relation.relation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "booking")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private CustomerModel customerId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seatId", referencedColumnName = "seatId")
    private SeatModel seatId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screeningId", referencedColumnName = "screeningId")
    private ScreeningModel screeningId;

//    referencedColumnName = "customerId"
}
