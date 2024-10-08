/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.controller;

import com.example.diningReviewApi.model.DiningReview;
import com.example.diningReviewApi.model.ReviewStatus;
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

    public AdminController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    
    @GetMapping(path = "/pending")
    public List<DiningReview> getPendingReviews() {
        List<DiningReview> pendingReviews = this.reviewRepository.findByReviewStatus(ReviewStatus.PENDING);
        return pendingReviews;
    }
    
    @PutMapping(path = "/reviews/{id}")
    public DiningReview performReviewAction(@RequestBody DiningReview review, @PathVariable Long id, @PathVariable ReviewStatus status) {
        Optional<DiningReview> optionalReview = this.reviewRepository.findById(id);
        if (optionalReview.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The dining review was not found in the database.");
        }
        DiningReview reviewToUpdate = optionalReview.get();
        reviewToUpdate.setReviewStatus(status);
        return this.reviewRepository.save(reviewToUpdate);
    }
}
