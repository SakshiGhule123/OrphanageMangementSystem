package com.anudip.training.dto;

import com.anudip.training.entity.Orphanage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class StaffDTO {
	
    private Long staffId;

   
    private String sname;

   
  
    private String semail;

    
    private String phonenumber;


    
    private String sgender;
   
   
    private String sadd;
    
    private Orphanage orphanage;

}
