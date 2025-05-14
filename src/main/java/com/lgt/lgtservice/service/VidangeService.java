package com.lgt.lgtservice.service;

import com.lgt.lgtservice.model.Vidange;
import com.lgt.lgtservice.repository.VidangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VidangeService {

    private final VidangeRepository vidangeRepository;


    public Vidange updateVidange(long id, Vidange newVidange) {
        Optional<Vidange> optionalVidange = vidangeRepository.findById(id);
        if(optionalVidange.isEmpty()) {
            throw new RuntimeException("Vidange not found");
        }
        Vidange vidangeToUpdate = optionalVidange.get();
        vidangeToUpdate.setCurrentKm(newVidange.getCurrentKm());
        vidangeToUpdate.setNextKm(newVidange.getNextKm());
        vidangeToUpdate.setPartner(newVidange.getPartner());
        vidangeToUpdate.setDiffKm(newVidange.getDiffKm());
        vidangeToUpdate.setThresholdKm(newVidange.getThresholdKm());
        vidangeToUpdate.setDateVdg(newVidange.getDateVdg());

        return vidangeRepository.save(vidangeToUpdate);
    }

    public Vidange addVidange(Vidange vidange) {
        return vidangeRepository.save(vidange);
    }

    public String deleteVidange(long id) {
        Optional<Vidange> optionalVidange = vidangeRepository.findById(id);
        if(optionalVidange.isEmpty()) {
            throw new RuntimeException("Vidange not found");
        }
        vidangeRepository.deleteById(id);
        return "Deleted successfully";
    }

    public Vidange getVidangeById(long id) {
        Optional<Vidange> optionalVidange = vidangeRepository.findById(id);
        if(optionalVidange.isEmpty()) {
            throw new RuntimeException("Vidange not found");
        }
        return optionalVidange.get();
    }

    public List<Vidange> getVidangeList() {
        return vidangeRepository.findAll();
    }
}
