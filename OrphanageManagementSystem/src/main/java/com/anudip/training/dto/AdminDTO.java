package com.anudip.training.dto;

import com.anudip.training.entity.Orphanage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AdminDTO {

    private Long adminId;

    
    private String username;

   
    private String password;
    
    private Orphanage orphanage;


}
