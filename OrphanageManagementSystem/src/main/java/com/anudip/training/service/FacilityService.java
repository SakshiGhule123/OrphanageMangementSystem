package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.FacilityDTO;

public interface FacilityService {

	List<FacilityDTO> getAllFacility();
	
	FacilityDTO getFacilityById(Long facilityId);
	
	FacilityDTO updatefacility(Long facilityId,FacilityDTO facilitydto);
	
	FacilityDTO addFacility(FacilityDTO facilitydto);
	
	void deleteFacilityById(Long facilityId );
	
	FacilityDTO getFacilityByName(String facilityName);
}
