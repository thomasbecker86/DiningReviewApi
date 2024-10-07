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
import java.util.List;

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
    @GeneratedValue
//    @Column(name = "id")
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
    
    /*
    @OneToMany(mappedBy = "user")
    private List<DiningReview> reviews;
    */
    /*
    public User(Long id, String name, String city, int zipCode, boolean peanutAllergy, boolean eggAllergy, boolean dairyAllergy) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.peanutAllergy = peanutAllergy;
        this.eggAllergy = eggAllergy;
        this.dairyAllergy = dairyAllergy;
        this.reviews = new ArrayList<>();
    }
    */
   /*
    public void addReview(DiningReview review) {
        this.reviews.add(review);
    }
    */
}
