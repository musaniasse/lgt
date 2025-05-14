package com.lgt.lgtservice.dto;

import java.time.LocalDate;

public record KilometrageDTO(
        Long id,
        String km,
        LocalDate date,
        Long vidange
) {
}
