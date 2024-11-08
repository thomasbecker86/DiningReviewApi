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
@Table(name = "reviews")
public class DiningReview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private Long restaurantId;
    
    private Integer peanutScore;
    
    private Integer eggScore;
    
    private Integer dairyScore;
    
    private String comment;    
    
    private ReviewStatus reviewStatus;
}
