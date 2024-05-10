package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.AdminDTO;

public interface AdminService {

	List <AdminDTO> getAllAdmin();
	
	AdminDTO getAdminById(Long adminId);
	
	AdminDTO addAdmin(AdminDTO admin);
	
	AdminDTO updateAdminById(Long adminId,AdminDTO admin);
	
	void deleteAdminById(Long adminId);
	
	List<AdminDTO> getAdminsByOrphanageId(Long orphanageId);
	
	AdminDTO getAdminByUsername(String username);
	
	
}
