package com.anudip.training.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Data
@Setter 
@Getter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password",nullable = true)
    private String password;

    
    @ManyToOne             //(fetch = FetchType.EAGER) (cascade = CascadeType.ALL)  
    @JoinColumn(name = "orphanage_id",referencedColumnName = "orphId") 
    @JsonBackReference("admin-orphanage")
    private Orphanage orphanage;
    
}
