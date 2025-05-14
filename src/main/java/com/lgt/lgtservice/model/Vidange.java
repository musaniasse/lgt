package com.lgt.lgtservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vidange")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vidange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dateVdg;
    private String partner;
    private String currentKm;
    private String nextKm;
    private String diffKm;
    private String thresholdKm;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Vehicule car;

    @OneToMany(mappedBy = "vidange", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Kilometrage> kilometrageList;
}
