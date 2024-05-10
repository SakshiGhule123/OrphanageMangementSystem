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

import com.anudip.training.dto.AdminDTO;
import com.anudip.training.entity.Admin;
import com.anudip.training.entity.Orphanage;
import com.anudip.training.service.AdminService;
import com.anudip.training.service.OrphanageService;
import com.anudip.training.util.AdminConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@RestController
@RequestMapping("/Admin")
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminConverter adminConverter;
	
	@Autowired
    OrphanageService   orphanageService;
	
	// http://localhost:8080/Admin/getAllAdmin
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<AdminDTO>> getAllAdmin()
	{
		
		return new  ResponseEntity<List<AdminDTO>>(adminService.getAllAdmin(),HttpStatus.OK);
	}
	
	// http://localhost:8080/Admin/getAdmin/1
	@GetMapping("/getAdmin/{adminId}")
	public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long adminId)
	
	{
			return new ResponseEntity<AdminDTO>(adminService.getAdminById(adminId),HttpStatus.OK);
	}
	
	// http://localhost:8080/Admin/getAdminsByOrphanage/1
	@GetMapping("/getAdminsByOrphanage/{orphanageId}")
	public ResponseEntity<List<AdminDTO>> getAdminsByOrphanageId(@PathVariable Long orphanageId)
	{
	    
		return new ResponseEntity<>(adminService.getAdminsByOrphanageId(orphanageId), HttpStatus.OK);
	}
	
	// http://localhost:8080/Admin/addAdmin
      @PostMapping("/addAdmin")
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody AdminDTO admindto)
	{
    	  /*
    	  Orphanage orphanage = orphanageService.getOrphangaeById(admindto.getOrphanage().getOrphId());
    	  admindto.setOrphanage(orphanage);
    	  */
    	  System.out.println("admin print"+admindto);

    	  	return new ResponseEntity<AdminDTO>(adminService.addAdmin(admindto),HttpStatus.CREATED);
    	  
 }
 
	
	
	// http://localhost:8080/Admin/updateAdmin/1 
	@PutMapping("/updateAdmin/{adminId}")
	public ResponseEntity<AdminDTO> updateAdmin(@PathVariable Long adminId,@RequestBody AdminDTO admindto)
	{
				
			return new ResponseEntity<AdminDTO>(adminService.updateAdminById(adminId, admindto),HttpStatus.OK);
	}
	
	// http://localhost:8080/Admin/deleteAdmin/1
	@DeleteMapping("/deleteAdmin/{adminId}")
	public ResponseEntity<String> deleteAdminById(@PathVariable Long adminId)
	{
		adminService.deleteAdminById(adminId);
		return new ResponseEntity<String>("admin data delete Successfully",HttpStatus.NO_CONTENT);
	}
	
	// http://localhost:8080/Admin/getAdminByUsername/{username}
	@GetMapping("/getAdminByUsername/{username}")
	public ResponseEntity<AdminDTO> getAdminByUsername(@PathVariable String username) {
	    return new ResponseEntity<>(adminService.getAdminByUsername(username), HttpStatus.OK);
	}
	
	
}

