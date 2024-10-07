/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.controller;

import com.example.diningReviewApi.model.DiningReview;
import com.example.diningReviewApi.model.User;
import com.example.diningReviewApi.repository.ReviewRepository;
import com.example.diningReviewApi.repository.UserRepository;
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

    public ReviewController(ReviewRepository reviewRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }
    
    //TODO: Input-Validierung, HttpStatus
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiningReview addReview(@RequestBody DiningReview review, @PathVariable String userName) {
        Optional<User> optionalUser = this.userRepository.findByName(userName);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You don't have permission to submit a review.");
        }
        return this.reviewRepository.save(review);
    }
    
}
