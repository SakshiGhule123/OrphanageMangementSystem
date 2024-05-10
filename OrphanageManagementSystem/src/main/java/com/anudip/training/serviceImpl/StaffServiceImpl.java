package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.AdminDTO;
import com.anudip.training.dto.StaffDTO;
import com.anudip.training.entity.Admin;
import com.anudip.training.entity.Staff;
import com.anudip.training.exception.AdminIdNotFoundException;
import com.anudip.training.exception.StaffIdNotFoundException;
import com.anudip.training.repository.StaffRepository;
import com.anudip.training.service.StaffService;
import com.anudip.training.util.AdminConverter;
import com.anudip.training.util.StaffConverter;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	 StaffConverter staffConverter;
	
	@Override
	public List<StaffDTO> getAllStaff() {
	
		List<Staff> allStaff=this.staffRepository.findAll();
		List<StaffDTO> collect=allStaff.stream().map((staff)->this.staffConverter.convertToStaffDTO(staff)).collect(Collectors.toList());
		return collect;	
		}

	@Override
	public StaffDTO getStaffById(Long staffId) {
	
		Staff staff=staffRepository.findById(staffId).orElseThrow(() -> new StaffIdNotFoundException("StaffId is not correct"));
		return this.staffConverter.convertToStaffDTO(staff);
	}

	@Override
	public StaffDTO addStaff(StaffDTO staffdto) {
		Staff staff = this.staffConverter.convertToStaff(staffdto);
		Staff saveStaff = this.staffRepository.save(staff);
		return this.staffConverter.convertToStaffDTO(saveStaff);
	}

	@Override
	public StaffDTO updateStaffById(Long staffId, StaffDTO staffdto) {

		Staff updateStaff=staffRepository.findById(staffId).orElseThrow(() -> new StaffIdNotFoundException("Staff id not correct"));
		
		updateStaff.setPhonenumber(staffdto.getPhonenumber());
		updateStaff.setSadd(staffdto.getSadd());
		updateStaff.setSemail(staffdto.getSemail());
		updateStaff.setSgender(staffdto.getSgender());
		updateStaff.setSname(staffdto.getSname());
		
       Staff saveStaff=staffRepository.save(updateStaff);

		
		
		return staffConverter.convertToStaffDTO(saveStaff);
	}

	@Override
	public void DeleteStaffById(Long staffId) {
		
		staffRepository.findById(staffId).orElseThrow(() -> new StaffIdNotFoundException("Staff id not correct"));
		
		staffRepository.deleteById(staffId);
		
	}
	
	@Override
	public List<StaffDTO> getStaffByName(String staffName) {
		List<Staff> staffList = staffRepository.findBySnameIgnoreCase(staffName);
		return staffList.stream().map(this.staffConverter::convertToStaffDTO).collect(Collectors.toList());
	}
}
