package com.relation.relation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "film")
public class FilmModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long filmId;
    private String filmName;
    private String category;
    private String subTitle;
}
