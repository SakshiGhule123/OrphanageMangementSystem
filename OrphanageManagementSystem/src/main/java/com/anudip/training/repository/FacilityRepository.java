package com.anudip.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Long>{
    Optional<Facility> findByFacilityNameIgnoreCase(String facilityName);

}
