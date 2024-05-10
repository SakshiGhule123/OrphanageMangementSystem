package com.anudip.training.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Orphange_Info")
public class Orphanage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orphId;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String orphName;

    @Column(name = "location")
    private String location;

    private Long pincode;

    @OneToMany       //,fetch = FetchType.EAGER,cascade = CascadeType.ALL
    @JsonManagedReference("admin-orphanage")
    private List<Admin> admins;
   
    @OneToMany//(mappedBy = "orphanage")
    @JsonManagedReference("children-orphanage")
    private List<Child> children;
   
    @OneToMany  //(mappedBy = "orphanage",cascade = CascadeType.PERSIST)//,fetch = FetchType.EAGER)
    @JsonManagedReference("donor-orphanage")
    private List<Donor> donors;
    
   
    @OneToMany    //(mappedBy = "orphanage", cascade = CascadeType.ALL)//,fetch = FetchType.EAGER)
   @JsonManagedReference("facility-orphanage")
    private List<Facility> facilities;
    
    @OneToMany//(mappedBy = "orphanage", cascade = CascadeType.ALL)//,fetch = FetchType.EAGER)
    @JsonManagedReference("staff-orphanage")
    private List<Staff> staffMembers;
    
    @OneToMany//(mappedBy = "orphanage", cascade = CascadeType.ALL)//,fetch = FetchType.EAGER)
    @JsonManagedReference("user-orphanage")
    private List<User> users;
}
