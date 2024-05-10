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

import com.anudip.training.dto.OrphanageDTO;
import com.anudip.training.entity.Orphanage;
import com.anudip.training.service.OrphanageService;
import com.anudip.training.util.AdminConverter;
import com.anudip.training.util.OrphanageConverter;

@RestController
@CrossOrigin("*")
@RequestMapping("/Orphanage")
public class OrphanageController {
	@Autowired
	private OrphanageService orphanageService;
	
	@Autowired
	OrphanageConverter orphanageConverter;
	
   // http://localhost:8080/Orphanage/getOrphangaeById/1
	@GetMapping("/getOrphangaeById/{orphId}")
	public ResponseEntity<OrphanageDTO> getOrphangaeById(@PathVariable Long orphId)
	{
		return new ResponseEntity<OrphanageDTO>(orphanageService.getOrphangaeById(orphId),HttpStatus.OK);
		
	}
	
	// http://localhost:8080/Orphanage/getAllOrphangae
	@GetMapping("/getAllOrphangae")
	public ResponseEntity<List<OrphanageDTO>> getAllOrphanage()
	{
		return new ResponseEntity<List<OrphanageDTO>> (orphanageService.getAllOrphanage(),HttpStatus.OK);
		
	}
	
	// http://localhost:8080/Orphanage/addOrphangae
	@PostMapping("/addOrphangae")
	public ResponseEntity <OrphanageDTO>  addOrphange(@RequestBody OrphanageDTO orphanagedto)
	{
		return new ResponseEntity<OrphanageDTO>(orphanageService.addOrphange(orphanagedto),HttpStatus.CREATED);
			
	}
	
	// http://localhost:8080/Orphanage/updateOrphangeById/1
	@PutMapping("/updateOrphangeById/{orphId}")
	public ResponseEntity <OrphanageDTO>  updateOrphangeById(@PathVariable Long orphId,@RequestBody OrphanageDTO updatedorphanage)
	{
			return new ResponseEntity<OrphanageDTO>(orphanageService.updateOrphangeById(orphId, updatedorphanage),HttpStatus.OK);
			
	}
	
	// http://localhost:8080/Orphanage/deleteOrphanageById/1
	@DeleteMapping("/deleteOrphanageById/{orphId}")
	public  ResponseEntity <Orphanage>  deleteOrphanageById(@PathVariable Long orphId)
	{
		         orphanageService.deleteOrphanageById(orphId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
	}
	
	// http://localhost:8080/Orphanage/getOrphanageByLocation/
    @GetMapping("/getOrphanageByLocation/{location}")
    public ResponseEntity<List<OrphanageDTO>> getOrphanageByLocation(@PathVariable String location) {
        return new ResponseEntity<>(orphanageService.getOrphanageByLocation(location), HttpStatus.OK);
    }

    // http://localhost:8080/Orphanage/getOrphanageByName/
    @GetMapping("/getOrphanageByName/{orphName}")
    public ResponseEntity<List<OrphanageDTO>> getOrphanageByName(@PathVariable String orphName) {
        return new ResponseEntity<>(orphanageService.getOrphanageByName(orphName), HttpStatus.OK);
    }

    // http://localhost:8080/Orphanage/getOrphanageByPincode/
    @GetMapping("/getOrphanageByPincode/{pincode}")
    public ResponseEntity<List<OrphanageDTO>> getOrphanageByPincode(@PathVariable Long pincode) {
        return new ResponseEntity<>(orphanageService.getOrphanageByPincode(pincode), HttpStatus.OK);
    }
}
