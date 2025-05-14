package com.lgt.lgtservice.service;

import com.lgt.lgtservice.dto.KilometrageDTO;
import com.lgt.lgtservice.model.Kilometrage;
import org.springframework.stereotype.Service;

@Service
public class KilometrageMapperService {

    public KilometrageDTO toDTO(Kilometrage ke) {
        return new KilometrageDTO(
                ke.getId(),
                ke.getKilometre(),
                ke.getDate(),
                ke.getVidange().getId()
        );
    }
}
