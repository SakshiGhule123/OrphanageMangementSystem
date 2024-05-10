package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

	 List<Donor> findByDonorNameIgnoreCase(String donorName);

	    List<Donor> findByContactInfo(String contactInfo);
}
