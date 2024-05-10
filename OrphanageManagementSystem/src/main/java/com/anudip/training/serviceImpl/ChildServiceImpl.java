package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.ChildDTO;
import com.anudip.training.entity.Child;
import com.anudip.training.exception.AdminIdNotFoundException;
import com.anudip.training.exception.ChildIdNotFoundException;
import com.anudip.training.repository.ChildRepository;
import com.anudip.training.service.ChildService;
import com.anudip.training.util.ChildConverter;

@Service
public class ChildServiceImpl implements ChildService{

	@Autowired
	private ChildRepository  childRepository;
	
	@Autowired
	 ChildConverter childConverter;
	
	@Override
	public ChildDTO addChild(ChildDTO childdto) {
		Child child = this.childConverter.convertToChild(childdto);
		Child savechild = this.childRepository.save(child);
		return this.childConverter.convertToChildDTO(savechild);
	}

	@Override
	public List<ChildDTO> getAllChildren() {
		List<Child> allchild=this.childRepository.findAll();
		List<ChildDTO> collect=allchild.stream().map((child)->this.childConverter.convertToChildDTO(child)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public ChildDTO getChildrenById(Long childId) {
		
		Child child=childRepository.findById(childId).orElseThrow(() -> new AdminIdNotFoundException("child id is not correct"));
		return this.childConverter.convertToChildDTO(child);
	}

	@Override
	public ChildDTO updateChildrenById(Long childId, ChildDTO childdto) {
		Child updatedChild =childRepository.findById(childId).orElseThrow(() -> new ChildIdNotFoundException ("Child not found"));
		
		updatedChild.setAge(childdto.getAge());
		//updatedChild.setChildId(childdto.getChildId());
		updatedChild.setChildName(childdto.getChildName());
		updatedChild.setDateAdmission(childdto.getDateAdmission());
		updatedChild.setDateofBirth(childdto.getDateofBirth());
		updatedChild.setEducationStatus(childdto.getEducationStatus());
		updatedChild.setGender(childdto.getGender());
		updatedChild.setHealthStatus(childdto.getHealthStatus());
		
		Child saveChild=childRepository.save(updatedChild);
		
		return childConverter.convertToChildDTO(updatedChild);
	}

	@Override
	public void deleteChildrenById(Long childId) {
		
		childRepository.findById(childId).orElseThrow(() -> new ChildIdNotFoundException ("Child not found"));
 
		childRepository.deleteById(childId);
	}
	 @Override
	    public List<ChildDTO> getChildrenByChildName(String childName) {
	        List<Child> children = childRepository.findByChildNameIgnoreCase(childName);
	        return children.stream().map(childConverter::convertToChildDTO).collect(Collectors.toList());
	    }

	    @Override
	    public List<ChildDTO> getChildrenByAge(int age) {
	        List<Child> children = childRepository.findByAge(age);
	        return children.stream().map(childConverter::convertToChildDTO).collect(Collectors.toList());
	    }

	    @Override
	    public List<ChildDTO> getChildrenByGender(String gender) {
	        List<Child> children = childRepository.findByGenderIgnoreCase(gender);
	        return children.stream().map(childConverter::convertToChildDTO).collect(Collectors.toList());
	    }

}
