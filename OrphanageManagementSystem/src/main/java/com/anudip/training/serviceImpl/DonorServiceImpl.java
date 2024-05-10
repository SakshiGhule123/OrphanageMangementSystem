package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.AdminDTO;
import com.anudip.training.dto.DonorDTO;
import com.anudip.training.entity.Admin;
import com.anudip.training.entity.Donor;
import com.anudip.training.exception.AdminIdNotFoundException;
import com.anudip.training.exception.DonorIdNotFoundException;
import com.anudip.training.repository.DonorRepository;
import com.anudip.training.service.DonorService;
import com.anudip.training.util.AdminConverter;
import com.anudip.training.util.DonorConverter;

@Service
public class DonorServiceImpl implements DonorService{

	@Autowired
	DonorRepository donorRepository;
	
	@Autowired
	 DonorConverter donorConverter;
	@Override
	public List<DonorDTO> getAllDonor() {
		List<Donor> allDonor=this.donorRepository.findAll();
		List<DonorDTO> collect=allDonor.stream().map((donor)->this.donorConverter.convertToDonorDTO(donor)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public DonorDTO getDonorById(Long donorId) {
		
		Donor donor=donorRepository.findById(donorId).orElseThrow(() -> new DonorIdNotFoundException("DonorId is not correct"));
		return this.donorConverter.convertToDonorDTO(donor);	}

	@Override
	public DonorDTO updateDonor(Long donorId, DonorDTO donordto) {
		Donor updatedDonor = donorRepository.findById(donorId).orElseThrow(() -> new DonorIdNotFoundException("Donor id is not correct"));
		
		updatedDonor.setContactInfo(donordto.getContactInfo());
		updatedDonor.setDonationAmount(donordto.getDonationAmount());
		updatedDonor.setDonationDate(donordto.getDonationDate());
		updatedDonor.setDonorName(donordto.getDonorName());
		
       Donor saveDonor=donorRepository.save(updatedDonor);

		
		
		return donorConverter.convertToDonorDTO(saveDonor);
	}

	@Override
	public DonorDTO addDonor(DonorDTO donordto) {
		
		Donor donor = this.donorConverter.convertToDonor(donordto);
		Donor saveDonor = this.donorRepository.save(donor);
		return this.donorConverter.convertToDonorDTO(saveDonor);	}

	@Override
	public void deleteDonorByID(Long donorId) {
		donorRepository.findById(donorId).orElseThrow(() -> new DonorIdNotFoundException("Donor id is not correct"));
	
		donorRepository.deleteById(donorId);
	}
	
	 @Override
	    public List<DonorDTO> getDonorByName(String donorName) {
	        List<Donor> donors = donorRepository.findByDonorNameIgnoreCase(donorName);
	        return donors.stream().map(donorConverter::convertToDonorDTO).collect(Collectors.toList());
	    }

	    @Override
	    public List<DonorDTO> getDonorByContactInfo(String contactInfo) {
	        List<Donor> donors = donorRepository.findByContactInfo(contactInfo);
	        return donors.stream().map(donorConverter::convertToDonorDTO).collect(Collectors.toList());
	    }
}
