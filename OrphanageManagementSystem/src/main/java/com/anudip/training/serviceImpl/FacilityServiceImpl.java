package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.AdminDTO;
import com.anudip.training.dto.FacilityDTO;
import com.anudip.training.entity.Admin;
import com.anudip.training.entity.Facility;
import com.anudip.training.exception.AdminIdNotFoundException;
import com.anudip.training.exception.FacilityIdNotFoundException;
import com.anudip.training.repository.FacilityRepository;
import com.anudip.training.service.FacilityService;
import com.anudip.training.util.AdminConverter;
import com.anudip.training.util.FacilityConverter;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Autowired
	FacilityRepository facilityRepository;
	
	@Autowired
	 FacilityConverter facilityConverter;
	
	@Override
	public List<FacilityDTO> getAllFacility() {
		
		List<Facility> allFacility=this.facilityRepository.findAll();
		List<FacilityDTO> collect=allFacility.stream().map((facility)->this.facilityConverter.convertToFacilityDTO(facility)).collect(Collectors.toList());
		return collect;	
		}

	@Override
	public FacilityDTO getFacilityById(Long facilityId) {
		
		Facility facility=facilityRepository.findById(facilityId).orElseThrow(() -> new FacilityIdNotFoundException("FacilityId is not correct"));
		return this.facilityConverter.convertToFacilityDTO(facility);	
		}

	@Override
	public FacilityDTO updatefacility(Long facilityId, FacilityDTO facilitydto) {

		Facility updatedFacility =facilityRepository.findById(facilityId).orElseThrow(() -> new FacilityIdNotFoundException("Facility Id not correct"));
		
		updatedFacility.setDescription(facilitydto.getDescription());
		updatedFacility.setFacilityName(facilitydto.getFacilityName());
		
        Facility saveFacility=facilityRepository.save(updatedFacility);

		
		
		return facilityConverter.convertToFacilityDTO(saveFacility);	
		}

	@Override
	public FacilityDTO addFacility(FacilityDTO facilitydto) {

		Facility facility = this.facilityConverter.convertToFacility(facilitydto);
		Facility saveFacility = this.facilityRepository.save(facility);
		return this.facilityConverter.convertToFacilityDTO(saveFacility);	}

	@Override
	public void deleteFacilityById(Long facilityId) {
		
		facilityRepository.findById(facilityId).orElseThrow(() -> new FacilityIdNotFoundException("Facility Id not correct"));
		
		facilityRepository.deleteById(facilityId);
		
		
	}

	   @Override
	    public FacilityDTO getFacilityByName(String facilityName) {
	        Facility facility = facilityRepository.findByFacilityNameIgnoreCase(facilityName)
	                .orElseThrow(() -> new FacilityIdNotFoundException("Facility not found with name: " + facilityName));
	        return facilityConverter.convertToFacilityDTO(facility);
	    }
}
