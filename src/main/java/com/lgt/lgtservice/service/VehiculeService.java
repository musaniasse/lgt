package com.lgt.lgtservice.service;

import com.lgt.lgtservice.exceptions.VehiculeNotFoundException;
import com.lgt.lgtservice.model.Vehicule;
import com.lgt.lgtservice.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehiculeService {
    private final VehiculeRepository vehiculeRepository;

    public String deleteVehicule(long id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isEmpty()){
            throw new VehiculeNotFoundException("Vehicule not found");
        }
        vehiculeRepository.deleteById(id);
        return "Vehicule deleted successfully";
    }

    public Vehicule addVehicule(Vehicule vehicule) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findByPlaque(vehicule.getPlaque());
        if(optionalVehicule.isPresent()){
            throw new VehiculeNotFoundException("Vehicule already exists");
        }
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule updateVehicule(long id, Vehicule vehicule) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isEmpty()){
            throw new VehiculeNotFoundException("Vehicule not found");
        }
        Vehicule existingVehicule = optionalVehicule.get();
        existingVehicule.setMarque(vehicule.getMarque());
        existingVehicule.setPlaque(vehicule.getPlaque());
        existingVehicule.setYear(vehicule.getYear());

        return vehiculeRepository.save(existingVehicule);
    }

    public Vehicule getVehicule(long id) {
        Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
        if (optionalVehicule.isEmpty()){
            throw new VehiculeNotFoundException("Vehicule not found");
        }
        return optionalVehicule.get();
    }

    public List<Vehicule> getVehicules() {
        List<Vehicule> vehiculeList = vehiculeRepository.findAll();
        if (vehiculeList.isEmpty()){
            throw new VehiculeNotFoundException("Any vehicule found in database");
        }
        return vehiculeList;
    }
}
