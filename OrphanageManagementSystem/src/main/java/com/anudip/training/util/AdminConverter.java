package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.AdminDTO;
import com.anudip.training.entity.Admin;

@Component
public class AdminConverter {

	//Converting Admin TO AdminDTO 
	
	public AdminDTO convertToAdminDTO(Admin admin)
	{
		AdminDTO aDto = new AdminDTO();
		if(admin != null)
		{
			BeanUtils.copyProperties(admin, aDto);
		}
		return aDto;
		
	}
	
	//Converting AdminDTO TO Admin
	public Admin convertToAdmin(AdminDTO aDto)
	{
		Admin admin = new Admin();
		if(aDto != null)
		{
			BeanUtils.copyProperties(aDto ,admin);
		}
		return admin;
		
	}
}
