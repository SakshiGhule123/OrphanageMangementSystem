package com.anudip.training.dto;

import java.time.LocalDate;
import java.util.List;

import com.anudip.training.entity.Child;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AdopterDTO {
	
    private Long adoptionId;

   
    private String adopterName;

    
    private String adopterAdd;
    
   
    private String phoneNo;
    
   
    private LocalDate adoptionDate;
    
    private List<Child> adoptedChildren;

}
