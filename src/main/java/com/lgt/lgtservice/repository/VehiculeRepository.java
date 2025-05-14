package com.lgt.lgtservice.repository;

import com.lgt.lgtservice.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    Optional<Vehicule> findByPlaque(String plaque);
}
