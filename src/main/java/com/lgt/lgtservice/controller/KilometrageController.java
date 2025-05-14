package com.lgt.lgtservice.controller;

import com.lgt.lgtservice.dto.KilometrageDTO;
import com.lgt.lgtservice.model.Kilometrage;
import com.lgt.lgtservice.repository.KilometrageRepository;
import com.lgt.lgtservice.service.KilometrageMapperService;
import com.lgt.lgtservice.service.KilometrageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kilometrages")
public class KilometrageController {
    private final KilometrageService kilometrageService;
    private final KilometrageRepository kilometrageRepository;
    private final KilometrageMapperService kilometrageMapperService;

    @GetMapping("{id}")
    public Kilometrage getKilometrage(@PathVariable long id){
        return kilometrageService.getKilometrage(id);
    }

    @GetMapping("/all")
    public List<KilometrageDTO> getKilometrages() {
        return kilometrageRepository.findAll().stream()
                .map(kilometrageMapperService::toDTO)
                .toList();
    }

    @PostMapping
    public Kilometrage addKilometrage(@RequestBody Kilometrage kilometrage) {
        return kilometrageService.create(kilometrage);
    }

    @PutMapping("{id}")
    public Kilometrage updateKilometrage(@PathVariable long id, @RequestBody Kilometrage kilometrage) {
        return kilometrageService.update(id, kilometrage);
    }

    @DeleteMapping("{id}")
    public String deleteKilometrage(@PathVariable long id) {
        return kilometrageService.deleteKilometrage(id);
    }
}
