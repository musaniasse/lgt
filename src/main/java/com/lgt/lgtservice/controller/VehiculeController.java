package com.lgt.lgtservice.controller;

import com.lgt.lgtservice.model.Vehicule;
import com.lgt.lgtservice.service.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/vehicules")
public class VehiculeController {
    private final VehiculeService vehiculeService;

    @GetMapping("/all")
    public List<Vehicule> getVehicules() {
        return vehiculeService.getVehicules();
    }
    @GetMapping("{id}")
    public Vehicule getVehicule(@PathVariable long id) {
        return vehiculeService.getVehicule(id);
    }
    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }
    @PutMapping("{id}")
    public Vehicule updateVehicule(@PathVariable long id, @RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(id, vehicule);
    }
    @DeleteMapping("{id}")
    public String deleteVehicule(@PathVariable long id) {
        return vehiculeService.deleteVehicule(id);
    }
}
