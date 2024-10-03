/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "reviews")
public class DiningReview {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private Long userId;
    
    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    
//    private Long restaurantId;
    
    @Column(name = "peanut_score")
    private double peanutScore;
    
    @Column(name = "egg_score")
    private double eggScore;
    
    @Column(name = "dairy_score")
    private double dairyScore;
    
    @Column(name = "comment")
    private String comment;
    
    public DiningReview() {        
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public double getPeanutScore() {
        return peanutScore;
    }

    public double getEggScore() {
        return eggScore;
    }

    public double getDairyScore() {
        return dairyScore;
    }

    public String getComment() {
        return comment;
    }
    
    
}
