package com.lgt.lgtservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "profile")
@NoArgsConstructor
@AllArgsConstructor

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 12, message = "Firstname must be between 5 and 12 characters")
    private String firstname;

    @NotBlank
    @Size(min = 5, max = 12, message = "Lastname must be between 5 and 12 characters")
    private String lastName;

    private String telephone;
    private String email;
    private String image;
    private String bio;
}
