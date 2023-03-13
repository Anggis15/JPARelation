package com.relation.relation.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne(cascade = CascadeType.ALL)
    private long customerId;
    private String fristName;
    private String lastName;
    private String noHp;
    private String addres;
    private String email;
    private Date birthDate;
}
