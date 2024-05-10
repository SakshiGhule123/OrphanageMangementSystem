package com.anudip.training.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "donor") 
@AllArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="donorId")
	private Long donorId;
    
   // @NotBlank
   @Column(name="name",nullable = false)
    private String donorName;
    
    @NotBlank
    @Column(name="contactInfo",nullable = false)
    private String contactInfo;
    
   
    private Long donationAmount;
    
    @NotNull
    private LocalDate donationDate;
    
   @ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orph_Id",referencedColumnName = "orphId") 
    @JsonBackReference("donor-orphanage")
    private Orphanage orphanage;
   

}
