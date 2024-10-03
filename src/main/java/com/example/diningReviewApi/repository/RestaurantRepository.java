/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.diningReviewApi.repository;

import com.example.diningReviewApi.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Thomas
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    
}
