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

import com.anudip.training.dto.DonorDTO;
import com.anudip.training.entity.Donor;
import com.anudip.training.entity.Orphanage;
import com.anudip.training.service.DonorService;
import com.anudip.training.service.OrphanageService;
import com.anudip.training.util.AdminConverter;
import com.anudip.training.util.DonorConverter;

@RestController
@RequestMapping("/Donor")
@CrossOrigin("*")
public class DonorController {

	@Autowired
	DonorService donorService;
	
	@Autowired
    OrphanageService orphanageService;

	@Autowired
	DonorConverter donorConverter;
	
	// http://localhost:8080/Donor/getDonor/1
	@GetMapping("/getDonor/{donorId}")
	public ResponseEntity<DonorDTO>  getDonorById(@PathVariable Long donorId)
	{
			
		return new ResponseEntity<DonorDTO>(donorService.getDonorById(donorId),HttpStatus.OK);
			
	}
	
	// http://localhost:8080/Donor/getAllDonor
	@GetMapping("/getAllDonor")
	public ResponseEntity<List<DonorDTO>> getAllDonor() {
			
		return new ResponseEntity<List<DonorDTO>>(donorService.getAllDonor(),HttpStatus.OK);
		    
	}
		
	// http://localhost:8080/Donor/addDonor
	@PostMapping("/addDonor")
	public ResponseEntity<DonorDTO>  addDonor(@RequestBody DonorDTO donordto)
	{
		/*
		Orphanage orphanage = orphanageService.getOrphangaeById(donordto.getOrphanage().getOrphId());
	    donordto.setOrphanage(orphanage);*/
			
		return new ResponseEntity<DonorDTO>(donorService.addDonor(donordto),HttpStatus.CREATED);
			
	}	

	// http://localhost:8080/Donor/updateDonor/1
	@PutMapping("/updateDonor/{donorId}")
	public ResponseEntity<DonorDTO>  updateDonor(@PathVariable Long donorId,@RequestBody DonorDTO donordto)
	{
				
		return new ResponseEntity<DonorDTO>(donorService.updateDonor(donorId, donordto),HttpStatus.OK);
				
	}
	
	// http://localhost:8080/Donor/deleteDonor/1
	@DeleteMapping("/deleteDonor/{donorId}")
	public ResponseEntity<Donor>  deleteDonor(@PathVariable Long donorId)
	{
		donorService.deleteDonorByID(donorId);	
		return new ResponseEntity<Donor>(HttpStatus.NO_CONTENT);
					
	}
	
	// http://localhost:8080/Donor/getDonorByName/
    @GetMapping("/getDonorByName/{donorName}")
    public ResponseEntity<List<DonorDTO>> getDonorByName(@PathVariable String donorName) {
        return new ResponseEntity<>(donorService.getDonorByName(donorName), HttpStatus.OK);
    }

    // http://localhost:8080/Donor/getDonorByContactInfo/
    @GetMapping("/getDonorByContactInfo/{contactInfo}")
    public ResponseEntity<List<DonorDTO>> getDonorByContactInfo(@PathVariable String contactInfo) {
        return new ResponseEntity<>(donorService.getDonorByContactInfo(contactInfo), HttpStatus.OK);
    }
}
