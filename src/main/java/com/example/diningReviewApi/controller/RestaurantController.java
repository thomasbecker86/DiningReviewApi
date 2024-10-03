/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.controller;

import com.example.diningReviewApi.model.Restaurant;
import com.example.diningReviewApi.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Thomas
 */

@RestController
public class RestaurantController {
    
    private final RestaurantRepository restaurantRepository;
    
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    
    @GetMapping(path = "/restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }
    
    //TODO: Validierung
    @PostMapping(path = "/restaurants")
    public Restaurant createNewRestaurant(@RequestBody Restaurant newRestaurant) {
        Iterable<Restaurant> restaurants = this.restaurantRepository.findAll();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(newRestaurant.getName()) && restaurant.getZipCode() == newRestaurant.getZipCode()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "An restaurant with this name and zipcode already exists!");
            }
        }
        return this.restaurantRepository.save(newRestaurant);
    }
}
