package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.AdopterDTO;
import com.anudip.training.entity.Adopter;
import com.anudip.training.exception.AdopterIdNotFoundException;
import com.anudip.training.repository.AdopterRepository;
import com.anudip.training.repository.ChildRepository;
import com.anudip.training.service.AdopterService;
import com.anudip.training.util.AdopterConverter;

@Service
public class AdopterServiceImpl implements AdopterService {

	@Autowired
    AdopterRepository  adopterRepository;
	
	@Autowired
	 AdopterConverter adopterConverter;

	@Autowired
   ChildRepository  childRepository;
	
	@Override
	public List<AdopterDTO> getAllAdopter() {
		List<Adopter> allAdopter=this.adopterRepository.findAll();
		List<AdopterDTO> collect=allAdopter.stream().map((adopter)->this.adopterConverter.convertToAdopterDTO(adopter)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public AdopterDTO getAdopterById(Long adoptionId) {

		Adopter adopter=adopterRepository.findById(adoptionId).orElseThrow(() -> new AdopterIdNotFoundException("Adopter is not correct"));
		return this.adopterConverter.convertToAdopterDTO(adopter);	
		}

	@Override
	public AdopterDTO updatAdopter(Long adoptionId, AdopterDTO adopterdto) {
		Adopter updatedAdopter = adopterRepository.findById(adoptionId).orElseThrow(() -> new AdopterIdNotFoundException("Adopter id not correct"));
		
		updatedAdopter.setAdopterAdd(adopterdto.getAdopterAdd());
		updatedAdopter.setAdopterName(adopterdto.getAdopterName());
		updatedAdopter.setAdoptionDate(adopterdto.getAdoptionDate());
		updatedAdopter.setPhoneNo(adopterdto.getPhoneNo());
		
		Adopter saveAdopter=adopterRepository.save(updatedAdopter);
		
		return adopterConverter.convertToAdopterDTO(saveAdopter);
	}

	@Override
	public AdopterDTO addAdopter(AdopterDTO adopterdto) {
		Adopter adopter = this.adopterConverter.convertToAdopter(adopterdto);
		Adopter saveAdopter = this.adopterRepository.save(adopter);
		return this.adopterConverter.convertToAdopterDTO(saveAdopter);
	}


	@Override
	public void DeleteAdopter(Long adoptionId) {

		adopterRepository.findById(adoptionId).orElseThrow(() -> new AdopterIdNotFoundException("Adopter id not correct"));
		adopterRepository.deleteById(adoptionId);;
	}

	@Override
	public AdopterDTO getAdopterByPhoneNo(String phoneNo) {
	    Adopter adopter = adopterRepository.findByPhoneNo(phoneNo);
	    if (adopter == null) {
	        throw new AdopterIdNotFoundException("Adopter with phone number " + phoneNo + " not found");
	    }
	    return adopterConverter.convertToAdopterDTO(adopter);
	}
	
	 @Override
	    public List<AdopterDTO> getAdopterByName(String adopterName) {
	        List<Adopter> adopters = adopterRepository.findByAdopterName(adopterName);
	        return adopters.stream().map(adopterConverter::convertToAdopterDTO).collect(Collectors.toList());
	    }
}
