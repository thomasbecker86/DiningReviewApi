/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
//    @Column(name = "id")
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
    
//    @Column(name = "peanut_score")
    private Double peanutScore;
    
//    @Column(name = "egg_score")
    private Double eggScore;
    
//    @Column(name = "dairy_score")
    private Double dairyScore;
    
//    @Column(name = "total_score")
    private Double totalScore;

    /*
    public Restaurant(Long id, String name, String city, int zipCode, String street) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.reviews = new ArrayList<>();        
        this.peanutScore = null;
        this.eggScore = null;
        this.dairyScore = null;
        this.totalScore = null;
    }
    
    /*
    public void addReview(DiningReview review) {
        this.reviews.add(review);
        //TODO: update scores
    }
    */
}
