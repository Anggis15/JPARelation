package com.relation.relation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "screening")
public class ScreeningModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long screeningId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "filmId", referencedColumnName = "filmId")
    private FilmModel filmId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    private RoomModel roomId;
    private Date screeningDate;
}
