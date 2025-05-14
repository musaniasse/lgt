package com.lgt.lgtservice.service;

import com.lgt.lgtservice.dto.VidangeDTO;
import com.lgt.lgtservice.model.Vidange;
import org.springframework.stereotype.Service;

@Service
public class VidangeMapperService {
    public VidangeDTO vidangeToDTO(Vidange vidange){
        return new VidangeDTO(
                vidange.getId(),
                vidange.getDateVdg(),
                vidange.getPartner(),
                vidange.getCurrentKm(),
                vidange.getNextKm(),
                vidange.getDiffKm(),
                vidange.getThresholdKm(),
                "Marque: "+ vidange.getCar().getMarque() + " - N° Plaque: " + vidange.getCar().getPlaque()
        );
    }
}
