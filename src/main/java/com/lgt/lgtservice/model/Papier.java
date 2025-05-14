package com.lgt.lgtservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "papier")
@Builder
public class Papier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private LocalDate dateObt;
    private String observation;
    private String partner;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Vehicule car;


}
