package com.anudip.training.dto;

import com.anudip.training.entity.Orphanage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserDTO {
	
	    private Long userId;

	    
	    private String username;

	    private String password;

	    private String email;
	    
	    private Orphanage orphanage;

}
