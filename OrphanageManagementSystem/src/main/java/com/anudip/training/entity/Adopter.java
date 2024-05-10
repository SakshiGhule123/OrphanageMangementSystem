package com.anudip.training.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Adoption")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Adopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id")
    private Long adoptionId;

    @NotBlank
    @Column(name="adopterName")
    private String adopterName;

    @NotBlank
    @Column(name="adopterAdd")
    private String adopterAdd;
    
    @NotBlank
    @Column(name = "phoneNo") 
    private String phoneNo;
    
    @Column(name = "adoption_date")
    private LocalDate adoptionDate;

   @OneToMany(mappedBy = "adopter",cascade = CascadeType.ALL)
    @JsonManagedReference("adopter-child")
    private List<Child> adoptedChildren;

}
