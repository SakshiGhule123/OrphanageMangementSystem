package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.AdminDTO;
import com.anudip.training.entity.Admin;
import com.anudip.training.exception.AdminIdNotFoundException;
import com.anudip.training.repository.AdminRepository;
import com.anudip.training.service.AdminService;
import com.anudip.training.util.AdminConverter;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	 AdminRepository adminRepository;
	
	@Autowired
	 AdminConverter adminConverter;
	
	@Override
	public List<AdminDTO> getAllAdmin() {
		List<Admin> allAdmin=this.adminRepository.findAll();
		List<AdminDTO> collect=allAdmin.stream().map((admin)->this.adminConverter.convertToAdminDTO(admin)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public AdminDTO getAdminById(Long adminId) {
		Admin admin=adminRepository.findById(adminId).orElseThrow(() -> new AdminIdNotFoundException("AdminId is not correct"));
		return this.adminConverter.convertToAdminDTO(admin);
	} 

	@Override
	public AdminDTO addAdmin(AdminDTO admindto) {
		Admin admin = this.adminConverter.convertToAdmin(admindto);
		Admin saveAdmin = this.adminRepository.save(admin);
		return this.adminConverter.convertToAdminDTO(saveAdmin);
	}

	@Override
	public AdminDTO updateAdminById(Long adminId, AdminDTO admindto) {
		Admin updatedAdmin = adminRepository.findById(adminId).orElseThrow(() -> new AdminIdNotFoundException("admin Id is not correct"));
		
		updatedAdmin.setUsername(admindto.getUsername());
		updatedAdmin.setPassword(admindto.getPassword());
		 
		Admin saveAdmin=adminRepository.save(updatedAdmin);

		
		
		return adminConverter.convertToAdminDTO(saveAdmin);
	}

	@Override
	public void deleteAdminById(Long adminId) {

		adminRepository.findById(adminId).orElseThrow(() -> new AdminIdNotFoundException("admin Id is not correct"));
		
		adminRepository.deleteById(adminId);
	}

	@Override
	public List<AdminDTO> getAdminsByOrphanageId(Long orphanageId) {
	    List<Admin> admins = adminRepository.findByOrphanage_OrphId(orphanageId);
	    return admins.stream()
	            .map(adminConverter::convertToAdminDTO)
	            .collect(Collectors.toList());
	}
	
	@Override
	public AdminDTO getAdminByUsername(String username) {
	    Admin admin = adminRepository.findByUsername(username);
	    if (admin == null) {
	        throw new AdminIdNotFoundException("Admin with username " + username + " not found");
	    }
	    return adminConverter.convertToAdminDTO(admin);
	}
	
}
