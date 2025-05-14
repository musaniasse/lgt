package com.lgt.lgtservice.service;

import com.lgt.lgtservice.model.Profile;
import com.lgt.lgtservice.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile addProfil(Profile profile) {
        Optional<Profile> optionalProfile = profileRepository.findByEmail(profile.getEmail());
        if (optionalProfile.isPresent()) {
            throw new RuntimeException("Profile already exists");
        }

        return profileRepository.save(profile);
    }

    public Profile updateProfile(long id, Profile profile) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if(optionalProfile.isEmpty()){
            throw new RuntimeException("Profile not found");
        }
        Profile profileToUpdate = optionalProfile.get();
        profileToUpdate.setFirstname(profile.getFirstname());
        profileToUpdate.setLastName(profile.getLastName());
        profileToUpdate.setEmail(profile.getEmail());
        profileToUpdate.setTelephone(profile.getTelephone());
        profileToUpdate.setBio(profile.getBio());
        profileToUpdate.setImage(profile.getImage());

        return profileRepository.save(profileToUpdate);
    }

    public String deleteProfile(long id) {

        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if(optionalProfile.isEmpty()){
            throw new RuntimeException("Profile not found");
        }

        profileRepository.deleteById(id);

        return "Profile deleted successfully";
    }

    public Profile getProfile(long id) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if(optionalProfile.isEmpty()){
            throw new RuntimeException("Profile not found");
        }

        return optionalProfile.get();
    }

    public List<Profile> getProfiles() {
        List<Profile> profileList = profileRepository.findAll();
        if (profileList.isEmpty()) {
            throw new RuntimeException("Any profile found in the database");
        }
        return profileList;
    }
}
