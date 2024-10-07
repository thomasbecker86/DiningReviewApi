/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.diningReviewApi.controller;

import com.example.diningReviewApi.model.User;
import com.example.diningReviewApi.repository.UserRepository;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Thomas
 */

@RestController
@RequestMapping(path = "/users")
public class UserController {
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping(path = "/{name}")
    public User getUserDetails(@PathVariable String name) {
        this.validateIfUserNameNotEmpty(name);
        Optional<User> optionalUser = this.userRepository.findByName(name);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A user with this name was not found in the database.");
        }
        return optionalUser.get();        
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        this.validateNewUser(user);
        return this.userRepository.save(user);
    }
    
    @PutMapping(path = "/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User updateUser(@RequestBody User user, @PathVariable String userName) {
        this.validateIfUserNameNotEmpty(userName);
        Optional<User> optionalUser = this.userRepository.findByName(userName);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A user with this name was not found in the database.");
        }
        User userToUpdate = optionalUser.get();
        
        if (user.getName() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (user.getCity() != null) {
            userToUpdate.setCity(user.getCity());
        }
        if (user.getZipCode() != null) {
            userToUpdate.setZipCode(user.getZipCode());
        }
        if (user.getPeanutAllergy() != null) {
            userToUpdate.setPeanutAllergy(user.getPeanutAllergy());
        }
        if (user.getEggAllergy() != null) {
            userToUpdate.setEggAllergy(user.getEggAllergy());
        }
        if (user.getDairyAllergy() != null) {
            userToUpdate.setDairyAllergy(user.getDairyAllergy());
        }
        return this.userRepository.save(userToUpdate);
    }

    private void validateNewUser(User user) {
        this.validateIfUserNameNotEmpty(user.getName());
        Optional<User> optionalUser = this.userRepository.findByName(user.getName());
        if (optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This username is already in use.");
        }        
    }
    
    private void validateIfUserNameNotEmpty(String userName) {
        if (userName == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
