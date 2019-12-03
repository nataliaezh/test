package com.entrytest.test.controllers;

import com.entrytest.test.entities.User;
import com.entrytest.test.errors_handlers.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.entrytest.test.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserRestController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/list")
    @ResponseBody
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public User findByOne(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User hasn't been found:" +id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User addProduct(@RequestBody User user){
        user.setId(null);
        return userRepository.save(user);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }



}
