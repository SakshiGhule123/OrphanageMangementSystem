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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.training.dto.AdopterDTO;
import com.anudip.training.entity.Adopter;
import com.anudip.training.service.AdopterService;
import com.anudip.training.util.AdopterConverter;

@RequestMapping("/Adopter")
@RestController
@CrossOrigin("*")
public class AdopterController {

	@Autowired
	AdopterService adopterService;
	

	@Autowired
	AdopterConverter adopterConverter;
	
	// http://localhost:8080/Adopter/getAllAdopter
	@GetMapping("/getAllAdopter")
	public ResponseEntity<List<AdopterDTO>> getAllAdopter()
	{
		return new ResponseEntity<List<AdopterDTO>>(adopterService.getAllAdopter(),HttpStatus.OK);
		
	}
	
	// http://localhost:8080/Adopter/getAdopter/1
	@GetMapping("/getAdopter/{adoptionId}")
	public ResponseEntity<AdopterDTO> getAdopter(@PathVariable Long adoptionId)
	{
		return new ResponseEntity<AdopterDTO>(adopterService.getAdopterById(adoptionId),HttpStatus.OK);
		
	}
	
	// http://localhost:8080/Adopter/addAdopter
	@PostMapping("/addAdopter")
	public ResponseEntity<AdopterDTO> addAdopter(@RequestBody AdopterDTO adopterdto)
	{
     	return new ResponseEntity<AdopterDTO>(adopterService.addAdopter(adopterdto),HttpStatus.CREATED);
			
	}
	
	// http://localhost:8080/Adopter/updateAdopter/1
	@PutMapping("/updateAdopter/{adoptionId}")
	public ResponseEntity<AdopterDTO> updateAdopter(@PathVariable Long adoptionId,@RequestBody AdopterDTO adopterdto)
	{
	   	return new ResponseEntity<AdopterDTO>(adopterService.updatAdopter(adoptionId, adopterdto),HttpStatus.OK);
				
	}
	
	// http://localhost:8080/Adopter/deleteAdopter/1
	@DeleteMapping("/deleteAdopter/{adoptionId}")
	public ResponseEntity<Adopter> deleteAdopter(@PathVariable Long adoptionId)
	{
		 adopterService.DeleteAdopter(adoptionId);
	 	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					
	}
	
	// http://localhost:8080/Adopter/getAdopterByPhoneNo/{phoneNo}
	@GetMapping("/getAdopterByPhoneNo/{phoneNo}")
	public ResponseEntity<AdopterDTO> getAdopterByPhoneNo(@PathVariable String phoneNo) {
	    return new ResponseEntity<>(adopterService.getAdopterByPhoneNo(phoneNo), HttpStatus.OK);
	}
	
	// http://localhost:8080/Adopter/getAdopterByName/Mr. Smith doe
    @GetMapping("/getAdopterByName/{adopterName}")
    public ResponseEntity<List<AdopterDTO>> getAdopterByName(@PathVariable String adopterName) {
        return new ResponseEntity<>(adopterService.getAdopterByName(adopterName), HttpStatus.OK);
    }
}
