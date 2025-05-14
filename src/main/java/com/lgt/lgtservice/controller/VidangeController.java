package com.lgt.lgtservice.controller;

import com.lgt.lgtservice.dto.VidangeDTO;
import com.lgt.lgtservice.model.Vidange;
import com.lgt.lgtservice.service.VidangeMapperService;
import com.lgt.lgtservice.service.VidangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vidanges")
public class VidangeController {
    private final VidangeService vidangeService;
    private final VidangeMapperService vidangeMapperService;

    @GetMapping("/all")
    public List<VidangeDTO> getVidangeList(){
        return vidangeService.getVidangeList().stream()
                .map(vidangeMapperService::vidangeToDTO)
                .toList();
    }
    @GetMapping("/{id}")
    public Vidange getVidangeById(@PathVariable long id){
        return vidangeService.getVidangeById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteVidange(@PathVariable long id) {
        return vidangeService.deleteVidange(id);
    }
    @PostMapping
    public Vidange addVidange(@Valid @PathVariable Vidange vidange) {
        return vidangeService.addVidange(vidange);
    }
    @PutMapping("/{id}")
    public Vidange updateViange(@PathVariable long id, Vidange vidange) {
        return vidangeService.updateVidange(id, vidange);
    }
}
