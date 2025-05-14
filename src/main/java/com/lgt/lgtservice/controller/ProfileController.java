package com.lgt.lgtservice.controller;

import com.lgt.lgtservice.model.Profile;
import com.lgt.lgtservice.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping
    public Profile addProfile(@RequestBody Profile profile) {
        return profileService.addProfil(profile);
    }

    @PutMapping("{id}")
    public Profile updateProfile(@PathVariable long id, @RequestBody Profile profile) {
        return profileService.updateProfile(id, profile);
    }

    @GetMapping("/all")
    public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }

    @GetMapping("{id}")
    public Profile getProfile(@PathVariable long id) {
        return profileService.getProfile(id);
    }

    @DeleteMapping("{id}")
    public String deleteProfile(@PathVariable long id) {
        return profileService.deleteProfile(id);
    }


}
