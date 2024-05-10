package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.AdopterDTO;
import com.anudip.training.entity.Adopter;

@Component
public class AdopterConverter {

	//Converting Adopter TO AdopterDTO 
	
		public AdopterDTO convertToAdopterDTO(Adopter adopter)
		{
			AdopterDTO aDto = new AdopterDTO();
			if(adopter != null)
			{
				BeanUtils.copyProperties(adopter, aDto);
			}
			return aDto;
			
		}
		
		//Converting AdopterDTO TO Adopter
		public Adopter convertToAdopter(AdopterDTO aDto)
		{
			Adopter adopter = new Adopter();
			if(aDto != null)
			{
				BeanUtils.copyProperties(aDto ,adopter);
			}
			return adopter;
			
		}
}
