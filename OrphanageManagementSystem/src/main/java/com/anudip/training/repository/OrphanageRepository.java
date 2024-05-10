package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Orphanage;

public interface OrphanageRepository extends JpaRepository<Orphanage, Long>{
	List<Orphanage> findByLocationIgnoreCase(String location);
    List<Orphanage> findByOrphNameIgnoreCase(String orphName);
    List<Orphanage> findByPincode(Long pincode);
}

