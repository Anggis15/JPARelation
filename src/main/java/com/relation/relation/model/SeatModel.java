package com.relation.relation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "seat")
public class SeatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomSeatId", referencedColumnName = "roomId")
    private RoomModel roomSeatId;
}
