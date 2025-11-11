package com.example.squizzbattle.controller;


import com.example.squizzbattle.model.User;
import com.example.squizzbattle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService= userService;
    }

    // post Methods
    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestParam User user){
        userService.saveUser(user);
        return ResponseEntity.noContent().build();
    }

    // get Methods

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(){
        List<User> users= userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        Optional<User> user= userService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName){
        Optional<User> user= userService.getUserByName(userName);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // delete Methods

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
