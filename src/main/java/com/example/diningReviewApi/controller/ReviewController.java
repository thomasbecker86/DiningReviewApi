/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.controller;

import com.example.diningReviewApi.model.DiningReview;
import com.example.diningReviewApi.model.Restaurant;
import com.example.diningReviewApi.model.ReviewStatus;
import com.example.diningReviewApi.model.User;
import com.example.diningReviewApi.repository.*;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Thomas
 */

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {
    
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewController(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }
    
    //TODO: Input-Validierung, HttpStatus
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DiningReview addReview(@RequestBody DiningReview review, @PathVariable String userName) {
        this.validateReview(review);
        
        review.setReviewStatus(ReviewStatus.PENDING);
        return this.reviewRepository.save(review);
    }
    
    private void validateReview(DiningReview review) {
        Optional<User> optionalUser = this.userRepository.findById(review.getUser().getId());
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(review.getRestaurant().getId());
        if (optionalRestaurant.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (review.getPeanutScore() == null && review.getEggScore() == null && review.getDairyScore() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    
}
