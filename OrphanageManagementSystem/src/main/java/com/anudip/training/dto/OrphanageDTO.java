package com.anudip.training.dto;

import java.util.List;

import com.anudip.training.entity.Admin;
import com.anudip.training.entity.Child;
import com.anudip.training.entity.Donor;
import com.anudip.training.entity.Facility;
import com.anudip.training.entity.Staff;
import com.anudip.training.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class OrphanageDTO {

    private Long orphId;

   
    private String orphName;

    
    private String location;

    private Long pincode;

    private List<Admin> admins;
   
    
    private List<Child> children;
   
   
    private List<Donor> donors;
    
    private List<Facility> facilities;
    
    
    private List<Staff> staffMembers;
    
   
    private List<User> users;
}
