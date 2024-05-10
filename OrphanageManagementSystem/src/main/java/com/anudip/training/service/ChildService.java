package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.ChildDTO;

public interface ChildService {

	 ChildDTO addChild(ChildDTO childdto);
	
     ChildDTO getChildrenById(Long childId);
	
	 ChildDTO updateChildrenById(Long childId,ChildDTO childDTO);
	
	 void deleteChildrenById(Long childId);

	 List<ChildDTO> getAllChildren();
	 
	 List<ChildDTO> getChildrenByChildName(String childName);

	    List<ChildDTO> getChildrenByAge(int age);

	    List<ChildDTO> getChildrenByGender(String gender);
}
