package com.lgt.lgtservice.repository;

import com.lgt.lgtservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(String email);
}
