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
@Table(name = "restaurants")
public class Restaurant {
    
    @Id
    @GeneratedValue
    private Long id;
    
//    @Column(name = "name", nullable = false)
    private String name;
    
//    @Column(name = "city", nullable = false)
    private String city;
    
//    @Column(name = "zip_code", nullable = false)
    private Integer zipCode;
    
//    @Column(name = "street", nullable = false)
    private String street;
    
//    @OneToMany(mappedBy = "restaurant")
//    private List<DiningReview> reviews;
    
    private Double peanutScore;
    
    private Double eggScore;
    
    private Double dairyScore;
    
    private Double totalScore;

}
