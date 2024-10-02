/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "restaurants")
public class Restaurant {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "zip_code", nullable = false)
    private int zipCode;
    
    @Column(name = "street", nullable = false)
    private String street;
    
    @OneToMany(mappedBy = "restaurant")
    private List<DiningReview> reviews;
    
    private double peanutScore;
    
    private double eggScore;
    
    private double dairyScore;
    
    private double totalScore;
}
