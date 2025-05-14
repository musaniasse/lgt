package com.lgt.lgtservice.dto;

import java.time.LocalDate;

public record VidangeDTO(
        Long id,
        LocalDate date,
        String currentKM,
        String partner,
        String nextKM,
        String diffKM,
        String thresholdKm,
        String car
) {

}
