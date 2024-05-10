package com.anudip.training.dto;

import com.anudip.training.entity.Orphanage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class FacilityDTO {
	 
	     private Long facilityId;

	    
	    private String facilityName;

	    
	    private String description;

	    private Orphanage orphanage;

}
