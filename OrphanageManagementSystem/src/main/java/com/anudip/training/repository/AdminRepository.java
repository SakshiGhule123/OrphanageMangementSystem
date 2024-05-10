package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Admin;



public interface AdminRepository extends JpaRepository<Admin, Long> {
	List<Admin> findByOrphanage_OrphId(Long orphanageId);
	Admin findByUsername(String username);
}

