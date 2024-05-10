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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="staffId")
    private Long staffId;

    @NotBlank(message = "Name must not be blank")
    @Column(name = "first_name",length = 25, nullable = false)
    private String sname;

   
    @NotBlank(message = " email must not be blank")
    @Column(name = "email",length = 25, unique = true)
    private String semail;

    @NotBlank(message = "phone number must not be blank")
    @Column(name = "phone_number",nullable = false, unique = true)
    private String phonenumber;


    @NotBlank(message = "Gender must not be blank")
    @Column(name="Gender",length = 25, nullable = false)
    private String sgender;
   
    @NotBlank(message = "Address must not be blank")
    @Column(name="sAdd", nullable = false)
    private String sadd;
 
   @ManyToOne// (cascade = CascadeType.ALL)
    @JoinColumn(name = "orph_Id",referencedColumnName = "orphId") 
    @JsonBackReference("staff-orphanage")
    private Orphanage orphanage;

    }