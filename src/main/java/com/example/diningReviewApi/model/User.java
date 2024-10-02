/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Thomas
 */

@Entity
@Table(name = "USER")
public class User {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private int zipCode;
    
    @Column(nullable = false)
    private boolean peanutAllergy;
    
    @Column(nullable = false)
    private boolean eggAllergy;
    
    @Column(nullable = false)
    private boolean dairyAllergy;

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