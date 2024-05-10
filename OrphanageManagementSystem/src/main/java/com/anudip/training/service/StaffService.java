package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.StaffDTO;

public interface StaffService {

	List<StaffDTO> getAllStaff();
	
	StaffDTO getStaffById(Long staffId);
	
	StaffDTO addStaff(StaffDTO staffdto);
	
	StaffDTO updateStaffById(Long staffId, StaffDTO staffdto);
	
	void DeleteStaffById(Long staffId);
	
	List<StaffDTO> getStaffByName(String staffName);


}
