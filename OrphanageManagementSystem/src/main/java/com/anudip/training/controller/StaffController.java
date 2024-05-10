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

import com.anudip.training.dto.StaffDTO;
import com.anudip.training.entity.Staff;
import com.anudip.training.service.StaffService;
import com.anudip.training.util.StaffConverter;

@RestController
@RequestMapping("/Staff")
@CrossOrigin("*")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@Autowired
	StaffConverter staffConverter;
	
	// http://localhost:8080/Staff/getStaffById/1
		@GetMapping("/getStaffById/{staffId}")
		public ResponseEntity<StaffDTO> getStaffeById(@PathVariable Long staffId)
		{
			return new ResponseEntity<StaffDTO>(staffService.getStaffById(staffId),HttpStatus.OK);
			
		}
		
		// http://localhost:8080/Staff/getAllStaff
		@GetMapping("/getAllStaff")
		public ResponseEntity<List<StaffDTO>> getAllStaff()
		{
			return new ResponseEntity<List<StaffDTO>>(staffService.getAllStaff(),HttpStatus.OK);
			
		}
		
		// http://localhost:8080/Staff/addStaff
		@PostMapping("/addStaff")
		public ResponseEntity <StaffDTO>  addOrphange(@RequestBody StaffDTO staffdto)
		{
			return new ResponseEntity<StaffDTO>(staffService.addStaff(staffdto),HttpStatus.CREATED	);
				
		}
		
		// http://localhost:8080/Staff/updateStaffById/1
		@PutMapping("/updateStaffById/{satffId}")
		public ResponseEntity <StaffDTO>  updateOrphangeById(@PathVariable Long satffId,@RequestBody StaffDTO staffdto)
		{
				return new ResponseEntity<StaffDTO>(staffService.updateStaffById(satffId, staffdto),HttpStatus.OK);
				
		}
		
		// http://localhost:8080/Staff/deleteStaffById/1
		@DeleteMapping("/deleteStaffById/{staffId}")
		public  ResponseEntity <Staff>  deleteOrphanageById(@PathVariable Long staffId)
		{
			         staffService.DeleteStaffById(staffId);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					
		}
		
		// http://localhost:8080/Staff/getStaffByName/
		@GetMapping("/getStaffByName/{staffName}")
	    public ResponseEntity<List<StaffDTO>> getStaffByName(@PathVariable String staffName) {
	        return new ResponseEntity<>(staffService.getStaffByName(staffName), HttpStatus.OK);
	    }
}
