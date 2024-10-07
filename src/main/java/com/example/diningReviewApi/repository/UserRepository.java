/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.diningReviewApi.repository;

import com.example.diningReviewApi.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Thomas
 */
public interface UserRepository extends CrudRepository<User, Long> {
    
    public Optional<User> findByName(String name);
}
