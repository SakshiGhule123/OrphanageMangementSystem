package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.dto.AdopterDTO;
import com.anudip.training.entity.Adopter;

public interface AdopterRepository extends JpaRepository<Adopter, Long>
{
	Adopter findByPhoneNo(String phoneNo);
    List<Adopter> findByAdopterName(String adopterName);

}