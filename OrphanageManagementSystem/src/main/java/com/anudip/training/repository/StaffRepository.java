package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findBySnameIgnoreCase(String staffName);


}
