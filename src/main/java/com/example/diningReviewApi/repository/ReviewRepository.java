/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.diningReviewApi.repository;

import com.example.diningReviewApi.model.DiningReview;
import com.example.diningReviewApi.model.ReviewStatus;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Thomas
 */
public interface ReviewRepository extends CrudRepository<DiningReview, Long> {
    
    public List<DiningReview> findByReviewStatus(ReviewStatus status);
    public List<DiningReview> findByRestaurantIdAndReviewStatus(Long restaurantId, ReviewStatus status);
}
