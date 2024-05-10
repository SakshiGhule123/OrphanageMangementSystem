package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {

	 List<Child> findByChildNameIgnoreCase(String childName);

	    List<Child> findByAge(int age);

	    List<Child> findByGenderIgnoreCase(String gender);
}
