package com.anudip.training.dto;

import java.time.LocalDate;

import com.anudip.training.entity.Orphanage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DonorDTO {
	
	private Long donorId;
    
    
    private String donorName;
    
  
    private String contactInfo;
    
   
    private Long donationAmount;
    
   
    private LocalDate donationDate;
    
    private Orphanage orphanage;

}
