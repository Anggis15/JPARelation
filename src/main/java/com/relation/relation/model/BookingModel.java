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
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", unique = true)
    private CustomerModel customerId;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "seatId", referencedColumnName = "seatId", unique = true)
    private SeatModel seatId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "screeningId", referencedColumnName = "screeningId")
    private ScreeningModel screeningId;

//    referencedColumnName = "customerId"
}
