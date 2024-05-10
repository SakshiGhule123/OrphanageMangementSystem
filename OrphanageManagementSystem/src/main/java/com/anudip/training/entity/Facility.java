package com.anudip.training.entity;



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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@Table(name="Facility_Info")
public class Facility {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="facilityId")
     private Long facilityId;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String facilityName;

    @Column(name = "description")
    private String description;


    @ManyToOne    //(cascade = CascadeType.ALL)
    @JoinColumn(name = "orph_Id",referencedColumnName = "orphId") 
    @JsonBackReference("facility-orphanage")
    private Orphanage orphanage; 

}
