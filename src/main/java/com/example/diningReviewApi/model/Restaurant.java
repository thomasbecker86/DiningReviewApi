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
import java.util.ArrayList;
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
    
    @Column(name = "peanut_score")
    private Double peanutScore;
    
    @Column(name = "egg_score")
    private Double eggScore;
    
    @Column(name = "dairy_score")
    private Double dairyScore;
    
    @Column(name = "total_score")
    private Double totalScore;

    public Restaurant() {        
    }
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
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public List<DiningReview> getReviews() {
        return reviews;
    }

    public Double getPeanutScore() {
        return peanutScore;
    }

    public Double getEggScore() {
        return eggScore;
    }

    public Double getDairyScore() {
        return dairyScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }
    
    
    public void addReview(DiningReview review) {
        this.reviews.add(review);
        //TODO: update scores
    }
}
