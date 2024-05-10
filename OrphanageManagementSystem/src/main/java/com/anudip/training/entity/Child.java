package com.anudip.training.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "children")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "childId")
    private Long childId;

    @NotBlank
    @Column(name = "name")
    private String childName;

    @NotNull
    private int age;

    private String healthStatus;

    private String educationStatus;

    @NotBlank
    private String gender;

    @NotNull
    @Column(name = "date_admission")
    private LocalDate dateAdmission;

    @NotNull
    @Column(name = "dateofBirth")
    private LocalDate dateofBirth;

    @ManyToOne   (cascade = CascadeType.ALL)
    @JoinColumn(name = "adopterid",referencedColumnName = "adoption_id") 
    @JsonBackReference("adopter-child")
    private Adopter adopter;
    
    @ManyToOne  //(cascade = CascadeType.ALL)
    @JoinColumn(name = "orph_Id",referencedColumnName = "orphId")  
    @JsonBackReference("children-orphanage")
    private Orphanage orphanage;
  
}