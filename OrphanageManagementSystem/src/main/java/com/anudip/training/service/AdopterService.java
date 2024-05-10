package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.AdopterDTO;

public interface AdopterService {

	List<AdopterDTO> getAllAdopter();
	
	AdopterDTO getAdopterById(Long adoptionId);
	
	AdopterDTO updatAdopter(Long adoptionId,AdopterDTO adopterdto);
	
	AdopterDTO addAdopter(AdopterDTO adopterdto);
	
	void DeleteAdopter(Long adoptionId);
	
	AdopterDTO getAdopterByPhoneNo(String phoneNo);
	

	
	 List<AdopterDTO> getAdopterByName(String adopterName);
}
