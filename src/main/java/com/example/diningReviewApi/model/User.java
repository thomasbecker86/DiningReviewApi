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
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "zip_code", nullable = false)
    private int zipCode;
    
    @Column(name = "peanut_allergy", nullable = false)
    private boolean peanutAllergy;
    
    @Column(name = "egg_allergy", nullable = false)
    private boolean eggAllergy;
    
    @Column(name = "dairy_allergy", nullable = false)
    private boolean dairyAllergy;
    
    @OneToMany(mappedBy = "user")
    private List<DiningReview> reviews;

    public User(Long id, String name, String city, int zipCode, boolean peanutAllergy, boolean eggAllergy, boolean dairyAllergy) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.peanutAllergy = peanutAllergy;
        this.eggAllergy = eggAllergy;
        this.dairyAllergy = dairyAllergy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isPeanutAllergy() {
        return peanutAllergy;
    }

    public void setPeanutAllergy(boolean peanutAllergy) {
        this.peanutAllergy = peanutAllergy;
    }

    public boolean isEggAllergy() {
        return eggAllergy;
    }

    public void setEggAllergy(boolean eggAllergy) {
        this.eggAllergy = eggAllergy;
    }

    public boolean isDairyAllergy() {
        return dairyAllergy;
    }

    public void setDairyAllergy(boolean dairyAllergy) {
        this.dairyAllergy = dairyAllergy;
    }  
    
}
