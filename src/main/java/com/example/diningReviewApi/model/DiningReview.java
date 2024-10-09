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
@Table(name = "reviews")
public class DiningReview {
    
    @Id
    @GeneratedValue
    private Long id;
    
//    @ManyToOne()
//    @JoinColumn(name = "user_id")
//    private User user;
    private String userName;
    
//    @ManyToOne()
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant;
    
    private Long restaurantId;
    
    private Integer peanutScore;
    
    private Integer eggScore;
    
    private Integer dairyScore;
    
    private String comment;    
    
    private ReviewStatus reviewStatus;
}
