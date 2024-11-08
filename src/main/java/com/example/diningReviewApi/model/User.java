/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Thomas
 */

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
//    @Column(name = "city", nullable = false)
    private String city;
    
//    @Column(name = "zip_code", nullable = false)
    private Integer zipCode;
    
//    @Column(name = "peanut_allergy", nullable = false)
    private Boolean peanutAllergy;
    
//    @Column(name = "egg_allergy", nullable = false)
    private Boolean eggAllergy;
    
//    @Column(name = "dairy_allergy", nullable = false)
    private Boolean dairyAllergy;

}
