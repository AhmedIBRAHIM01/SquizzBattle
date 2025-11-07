package com.example.squizzbattle.service;

import com.example.squizzbattle.model.User;
import com.example.squizzbattle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public Optional<User> getUserByName(String userName){
        return userRepository.findByUsername(userName);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }


}
