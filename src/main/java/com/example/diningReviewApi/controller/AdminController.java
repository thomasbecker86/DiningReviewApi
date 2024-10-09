/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.controller;

import com.example.diningReviewApi.model.AdminReviewAction;
import com.example.diningReviewApi.model.DiningReview;
import com.example.diningReviewApi.model.Restaurant;
import com.example.diningReviewApi.model.ReviewStatus;
import com.example.diningReviewApi.repository.RestaurantRepository;
import com.example.diningReviewApi.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Thomas
 */

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public AdminController(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository =  restaurantRepository;
    }
    
    @GetMapping(path = "/pending")
    public List<DiningReview> getPendingReviews() {
        List<DiningReview> pendingReviews = this.reviewRepository.findByReviewStatus(ReviewStatus.PENDING);
        return pendingReviews;
    }
    
    @PutMapping(path = "/reviews/{id}")
    public DiningReview performReviewAction(@PathVariable Long id, @RequestBody AdminReviewAction adminReviewAction) {
        Optional<DiningReview> optionalReview = this.reviewRepository.findById(id);
        if (optionalReview.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The dining review was not found in the database.");
        }        
        DiningReview reviewToUpdate = optionalReview.get();
        
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(reviewToUpdate.getRestaurantId());
        if (optionalRestaurant.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The restaurant was not found in the database.");
        }
        
        if (adminReviewAction.isAccept()) {
            reviewToUpdate.setReviewStatus(ReviewStatus.ACCEPTED);
        } else {
            reviewToUpdate.setReviewStatus(ReviewStatus.REJECTED);
        }
        DiningReview updatedReview = this.reviewRepository.save(reviewToUpdate);
        this.updateRestaurantReviewScores(optionalRestaurant.get());
        return updatedReview;
    }

    private void updateRestaurantReviewScores(Restaurant restaurant) {
        List<DiningReview> reviews = this.reviewRepository.findByRestaurantIdAndReviewStatus(restaurant.getId(), ReviewStatus.ACCEPTED);
        System.out.println(reviews.size());
        int peanutSum = 0;
        int peanutCount = 0;
        int eggSum = 0;
        int eggCount = 0;
        int dairySum = 0;
        int dairyCount = 0;
        for (DiningReview review: reviews) {
            if (review.getPeanutScore() != null) {
                peanutSum += review.getPeanutScore();
                peanutCount++;
            }
            if (review.getEggScore() != null) {
                eggSum += review.getEggScore();
                eggCount++;
            }
            if (review.getDairyScore() != null) {
                dairySum += review.getDairyScore();
                dairyCount++;
            }
        }
        if (peanutCount != 0) {
            double peanutScore = (double) peanutSum / peanutCount;
            restaurant.setPeanutScore(peanutScore);
        }
        if (eggCount != 0) {
            double eggScore = (double) eggSum / eggCount;
            restaurant.setEggScore(eggScore);
        }
        if (dairyCount != 0) {
            double dairyScore = (double) dairySum / dairyCount;
            restaurant.setDairyScore(dairyScore);
        }
        double totalScore = (peanutSum + eggSum + dairySum) / (peanutCount + eggCount + dairyCount);
        restaurant.setTotalScore(totalScore);
        this.restaurantRepository.save(restaurant);        
    }
}
