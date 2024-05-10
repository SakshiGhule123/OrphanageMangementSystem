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

import com.anudip.training.dto.AdopterDTO;
import com.anudip.training.dto.ChildDTO;
import com.anudip.training.entity.Adopter;
import com.anudip.training.entity.Child;
import com.anudip.training.service.AdopterService;
import com.anudip.training.service.ChildService;
import com.anudip.training.service.OrphanageService;
import com.anudip.training.util.ChildConverter;

@RestController
@RequestMapping("/Child")
@CrossOrigin("*")
public class ChildController {

	@Autowired
	private ChildService childService;
	
	@Autowired
	ChildConverter childConverter;
	
	
	
	
    // http://localhost:8080/Child/addChild
	@PostMapping("/addChild")
	public ResponseEntity<ChildDTO> addChild(@RequestBody ChildDTO childdto)
	{
	    
	  /* Adopter adopter=adopterService.getAdopterById(childdto.getAdopter().getAdoptionId());
	    childdto.setAdopter(adopter);
	    Orphanage orphanage = orphanageService.getOrphangaeById(childdto.getOrphanage().getOrphId());
	    childdto.setOrphanage(orphanage);*/
		
		return new ResponseEntity<ChildDTO>(childService.addChild(childdto),HttpStatus.CREATED);
		
	}
	
    // http://localhost:8080/Child/getAllChildren
	@GetMapping("/getAllChildren")
	public ResponseEntity<List<ChildDTO>> getAllChildren()
	{
		return new ResponseEntity<List<ChildDTO>>(childService.getAllChildren(),HttpStatus.OK);
		
	}
	
    // http://localhost:8080/Child/getChildrenById/1
	@GetMapping("/getChildrenById/{childId}")
	public ResponseEntity<ChildDTO> getChildrenById(@PathVariable Long childId)
	{
		return new ResponseEntity<ChildDTO>(childService.getChildrenById(childId),HttpStatus.OK);
		
	}
	
    // http://localhost:8080/Child/updateChildrenById/1
	@PutMapping("/updateChildrenById/{childId}")
	public ResponseEntity<ChildDTO> updateChildrenById(@PathVariable Long childId, @RequestBody ChildDTO updatedChild) {
		
		return new ResponseEntity<ChildDTO>(childService.updateChildrenById(childId, updatedChild), HttpStatus.OK);
	}

	
	 // http://localhost:8080/Child/deleteChildrenById/1
	@DeleteMapping("/deleteChildrenById/{childId}")
	public ResponseEntity<Child> deleteChildrenById(@PathVariable Long childId)
	{
	   childService.deleteChildrenById(childId);
	   return new ResponseEntity<Child>(HttpStatus.NO_CONTENT);
			
	}
	
    // http://localhost:8080/Child/getChildrenByChildName/
    @GetMapping("/getChildrenByChildName/{childName}")
    public ResponseEntity<List<ChildDTO>> getChildrenByChildName(@PathVariable String childName) {
        return new ResponseEntity<>(childService.getChildrenByChildName(childName), HttpStatus.OK);
    }

    // http://localhost:8080/Child/getChildrenByAge/
    @GetMapping("/getChildrenByAge/{age}")
    public ResponseEntity<List<ChildDTO>> getChildrenByAge(@PathVariable int age) {
        return new ResponseEntity<>(childService.getChildrenByAge(age), HttpStatus.OK);
    }

    // http://localhost:8080/Child/getChildrenByGender/
    @GetMapping("/getChildrenByGender/{gender}")
    public ResponseEntity<List<ChildDTO>> getChildrenByGender(@PathVariable String gender) {
        return new ResponseEntity<>(childService.getChildrenByGender(gender), HttpStatus.OK);
    }
    
    
}



