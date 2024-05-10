package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.OrphanageDTO;

public interface OrphanageService {

	List<OrphanageDTO> getAllOrphanage();
	
	OrphanageDTO getOrphangaeById(Long orphId);
	
	OrphanageDTO addOrphange(OrphanageDTO orphanagedto);
	
	OrphanageDTO updateOrphangeById(Long orphId,OrphanageDTO orphanagedto);
	
	void deleteOrphanageById(Long orphId);

	 List<OrphanageDTO> getOrphanageByLocation(String location);

	    List<OrphanageDTO> getOrphanageByName(String orphName);

	    List<OrphanageDTO> getOrphanageByPincode(Long pincode);
	
}
