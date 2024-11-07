/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.controller;

import com.example.diningReviewApi.model.Restaurant;
import com.example.diningReviewApi.repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Thomas
 */

@RestController
@RequestMapping(path = "/restaurants")
public class RestaurantController {
    
    private final RestaurantRepository restaurantRepository;
    
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    
    @GetMapping
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }
    
    @GetMapping(path = "/{id}")
    public Restaurant getRestaurantDetails(@PathVariable Long id) {
        Optional<Restaurant> existingRestaurant = this.restaurantRepository.findById(id);
        if (existingRestaurant.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A restaurant with this id was not found in the database.");
        }
        return existingRestaurant.get();
    }
    
    @GetMapping(path = "/search")
    public List<Restaurant> searchRestaurants(@RequestParam Integer zipcode, @RequestParam String allergy) {
        if (allergy.equalsIgnoreCase("peanut")) {
            return this.restaurantRepository.findByZipCodeAndPeanutScoreNotNull(zipcode);
        } else if(allergy.equalsIgnoreCase("egg")) {
            return this.restaurantRepository.findByZipCodeAndEggScoreNotNull(zipcode);
        } else if (allergy.equalsIgnoreCase("dairy")) {
            return this.restaurantRepository.findByZipCodeAndDairyScoreNotNull(zipcode);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {        
        /*
        Iterable<Restaurant> restaurants = this.restaurantRepository.findAll();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(newRestaurant.getName()) && restaurant.getZipCode() == newRestaurant.getZipCode()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "An restaurant with this name and zipcode already exists!");
            }
        }
        */
        this.validateNewRestaurant(restaurant);
        return this.restaurantRepository.save(restaurant);
    }
    
    private void validateNewRestaurant(Restaurant restaurant) {        
        Optional<Restaurant> existingRestaurant = this.restaurantRepository.findByNameAndZipCode(restaurant.getName(), restaurant.getZipCode());
        if (existingRestaurant.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "An restaurant with this name and zipcode already exists!");
        }
    }
}
