package com.lgt.lgtservice.model;

import com.lgt.lgtservice.validator.ValidYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 10, message = "Marque must be between 2 and 10 characters")
    private String marque;

    @NotBlank
    @Size(min = 5, max = 8, message = "Plaque must be between 5 and 8 characters")
    private String plaque;

    @ValidYear(message = "Year must be between and 2025")
    private int year;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "car")
    private Set<Vidange> vidangeList;

    @OneToMany(mappedBy = "car")
    private Set<Papier> papierList;
}
