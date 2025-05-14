package com.lgt.lgtservice.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "kilometrage")
@NoArgsConstructor
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private String kilometre;
    @ManyToOne
    @JoinColumn(name = "vidange_id")
    private Vidange vidange;

}
