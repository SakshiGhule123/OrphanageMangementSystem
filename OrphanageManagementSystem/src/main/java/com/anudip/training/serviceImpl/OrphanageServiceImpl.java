package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.AdminDTO;
import com.anudip.training.dto.OrphanageDTO;
import com.anudip.training.entity.Admin;
import com.anudip.training.entity.Orphanage;
import com.anudip.training.exception.AdminIdNotFoundException;
import com.anudip.training.exception.OrphanageIdNotFoundException;
import com.anudip.training.repository.OrphanageRepository;
import com.anudip.training.service.OrphanageService;
import com.anudip.training.util.AdminConverter;
import com.anudip.training.util.OrphanageConverter;

@Service
public class OrphanageServiceImpl implements OrphanageService {

	@Autowired
	OrphanageRepository orphanageRepository;
	
	@Autowired
	OrphanageConverter orphanageConverter;
	
	@Override
	public List<OrphanageDTO> getAllOrphanage()
	{
		List<Orphanage> allOrphanage=this.orphanageRepository.findAll();
		List<OrphanageDTO> collect=allOrphanage.stream().map((orphanage)->this.orphanageConverter.convertToOrphanageDTO(orphanage)).collect(Collectors.toList());
		return collect;	
	}

	@Override
	public OrphanageDTO getOrphangaeById(Long orphId) {
		
		Orphanage orphanage=orphanageRepository.findById(orphId).orElseThrow(() -> new OrphanageIdNotFoundException("OrphanageId is not correct"));
		return this.orphanageConverter.convertToOrphanageDTO(orphanage);	}

	@Override
	public OrphanageDTO addOrphange(OrphanageDTO orphanagedto) {
		Orphanage orphanage = this.orphanageConverter.convertToOrphanage(orphanagedto);
		Orphanage saveOrphanage = this.orphanageRepository.save(orphanage);
		return this.orphanageConverter.convertToOrphanageDTO(saveOrphanage);	}

	@Override
	public OrphanageDTO updateOrphangeById(Long orphId, OrphanageDTO orphanagedto) {

		Orphanage updateOrphanage = orphanageRepository.findById(orphId).orElseThrow(() -> new OrphanageIdNotFoundException("Orphanage Not found exceptin"));
		
		updateOrphanage.setLocation(orphanagedto.getLocation());
		updateOrphanage.setOrphName(orphanagedto.getOrphName());
		updateOrphanage.setPincode(orphanagedto.getPincode());
		
		Orphanage saveOrphanage=orphanageRepository.save(updateOrphanage);

		
		
		return orphanageConverter.convertToOrphanageDTO(saveOrphanage);
	}

	@Override
	public void deleteOrphanageById(Long orphId) {
		
		orphanageRepository.findById(orphId).orElseThrow(() -> new OrphanageIdNotFoundException("Orphanage Not found exceptin"));
		
		orphanageRepository.deleteById(orphId);
	}
	 @Override
	    public List<OrphanageDTO> getOrphanageByLocation(String location) {
	        List<Orphanage> orphanages = orphanageRepository.findByLocationIgnoreCase(location);
	        return orphanages.stream()
	                .map(orphanage -> orphanageConverter.convertToOrphanageDTO(orphanage))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public List<OrphanageDTO> getOrphanageByName(String orphName) {
	        List<Orphanage> orphanages = orphanageRepository.findByOrphNameIgnoreCase(orphName);
	        return orphanages.stream()
	                .map(orphanage -> orphanageConverter.convertToOrphanageDTO(orphanage))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public List<OrphanageDTO> getOrphanageByPincode(Long pincode) {
	        List<Orphanage> orphanages = orphanageRepository.findByPincode(pincode);
	        return orphanages.stream()
	                .map(orphanage -> orphanageConverter.convertToOrphanageDTO(orphanage))
	                .collect(Collectors.toList());
        }
}