package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.DonorDTO;
import com.anudip.training.entity.Donor;

public interface DonorService {

	
	
	DonorDTO getDonorById(Long donorId);
	
	DonorDTO updateDonor(Long donorId,DonorDTO donordto);
	
	DonorDTO addDonor(DonorDTO donorDTO);
	
	void deleteDonorByID(Long donorId);
	
	List<DonorDTO> getAllDonor();
	
	List<DonorDTO> getDonorByName(String donorName);

    List<DonorDTO> getDonorByContactInfo(String contactInfo);
}
