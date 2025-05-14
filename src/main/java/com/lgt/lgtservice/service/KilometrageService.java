package com.lgt.lgtservice.service;

import com.lgt.lgtservice.model.Kilometrage;
import com.lgt.lgtservice.repository.KilometrageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KilometrageService {
    private KilometrageRepository kilometrageRepository;

    public Kilometrage create(Kilometrage kilometrage) {
        return kilometrageRepository.save(kilometrage);
    }
    public Kilometrage update(long id, Kilometrage kilometrage){
        Optional<Kilometrage> optionalKilometrage = kilometrageRepository.findById(id);
        if (optionalKilometrage.isEmpty()){
            throw new RuntimeException("Kilometrage not found");
        }
        Kilometrage existingKilometrage = optionalKilometrage.get();
        existingKilometrage.setKilometre(kilometrage.getKilometre());
        existingKilometrage.setDate(kilometrage.getDate());
        return kilometrageRepository.save(existingKilometrage);
    }

    public Kilometrage getKilometrage(long id){
        Optional<Kilometrage> optionalKilometrage = kilometrageRepository.findById(id);
        if (optionalKilometrage.isEmpty()) {
            throw new RuntimeException("Kilometrage not found");
        }
        return optionalKilometrage.get();
    }

    public List<Kilometrage> getKilometrages() {
        List<Kilometrage> kilometrageList = kilometrageRepository.findAll();
        if (kilometrageList.isEmpty()){
            throw new RuntimeException("Any kilometrage found");
        }
        return kilometrageList;
    }

    public String deleteKilometrage(long id) {
        Optional<Kilometrage> optionalKilometrage = kilometrageRepository.findById(id);
        if (optionalKilometrage.isEmpty()) {
            throw new RuntimeException("Kilometrage not found");
        }
        kilometrageRepository.deleteById(id);

        return "Kilometrage deleted successfully";
    }
}
