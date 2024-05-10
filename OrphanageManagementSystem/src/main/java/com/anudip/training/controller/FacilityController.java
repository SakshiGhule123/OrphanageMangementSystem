package com.anudip.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.training.dto.FacilityDTO;
import com.anudip.training.dto.OrphanageDTO;
import com.anudip.training.entity.Facility;
import com.anudip.training.entity.Orphanage;
import com.anudip.training.service.FacilityService;
import com.anudip.training.service.OrphanageService;
import com.anudip.training.util.AdminConverter;
import com.anudip.training.util.FacilityConverter;

@RestController
@RequestMapping("/Facility")
@CrossOrigin("*")
public class FacilityController {

	@Autowired
	FacilityService facilityService;
	
	@Autowired
	OrphanageService orphanageService;
	
	@Autowired
	FacilityConverter facilityConverter;
	
	// http://localhost:8080/Facility/getAllFacility
	@GetMapping("/getAllFacility")
	public ResponseEntity<List<FacilityDTO>> getAllFacility()
	{
		return new ResponseEntity<List<FacilityDTO>>(facilityService.getAllFacility(),HttpStatus.OK);
		
	}
	
	// http://localhost:8080/Facility/getFacility/1
	@GetMapping("/getFacility/{facilityId}")
	public ResponseEntity<FacilityDTO> getFacilityById(@PathVariable Long facilityId)
	{
		return new ResponseEntity<FacilityDTO>(facilityService.getFacilityById(facilityId),HttpStatus.OK);
		
	}	
	
	// http://localhost:8080/Facility/addFacility
	@PostMapping("/addFacility")
	public ResponseEntity<FacilityDTO> addFacility(@RequestBody FacilityDTO facilitydto)
	{/*
		OrphanageDTO orphanage = orphanageService.getOrphangaeById(facilitydto.getOrphanage().getOrphId());
	    facilitydto.setOrphanage(orphanage);*/

		return new ResponseEntity<FacilityDTO>(facilityService.addFacility(facilitydto),HttpStatus.CREATED);
		
	}

	// http://localhost:8080/Facility/updateFacility/1
	@PutMapping("/updateFacility/{facilityId}")
	public ResponseEntity<FacilityDTO> addFacility(@PathVariable Long facilityId,@RequestBody FacilityDTO facilitydto)
	{
		return new ResponseEntity<FacilityDTO>(facilityService.updatefacility(facilityId, facilitydto),HttpStatus.OK);
		
	}	

	// http://localhost:8080/Facility/deleteFacility/1
	@DeleteMapping("/deleteFacility/{facilityId}")
	public ResponseEntity<Facility> deleteFacility(@PathVariable Long facilityId)
	{
		facilityService.deleteFacilityById(facilityId);
		return new ResponseEntity<Facility>(HttpStatus.NO_CONTENT);
		
	}
	
	// http://localhost:8080/Facility/getFacilityByName/
    @GetMapping("/getFacilityByName/{facilityName}")
    public ResponseEntity<FacilityDTO> getFacilityByName(@PathVariable String facilityName) {
        return new ResponseEntity<>(facilityService.getFacilityByName(facilityName), HttpStatus.OK);
    }


}
