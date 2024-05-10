package com.anudip.training.dto;

import java.time.LocalDate;

import com.anudip.training.entity.Orphanage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ChildDTO {

	    private Long childId;

	    private String childName;

	    
	    private int age;

	    private String healthStatus;

	    private String educationStatus;

	   
	    private String gender;

	 
	    private LocalDate dateAdmission;

	    private Orphanage orphanage;

	    private LocalDate dateofBirth;
}
