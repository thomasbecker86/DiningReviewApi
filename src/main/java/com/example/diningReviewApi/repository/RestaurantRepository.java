/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.diningReviewApi.repository;

import com.example.diningReviewApi.model.Restaurant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Thomas
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    
    public Optional<Restaurant> findByNameAndZipCode(String name, Integer zipCode);
    public List<Restaurant> findByZipCodeAndPeanutScoreNotNull(Integer zipCode);
    public List<Restaurant> findByZipCodeAndEggScoreNotNull(Integer zipCode);
    public List<Restaurant> findByZipCodeAndDairyScoreNotNull(Integer zipCode);
}
