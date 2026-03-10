package com.example.demo.controller;

import com.example.demo.repository.model.UserEntity;
import com.example.demo.repository.model.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserInfo> resultUsers = new ArrayList<>();
        for (UserEntity user : users) {
            resultUsers.add(new UserInfo(user.getId(), user.getFirstName(), user.getLastName()));
        }

        return ResponseEntity.ok(resultUsers);
    }

    @PostMapping("/users")
    public ResponseEntity<UserInfo> createUser(@RequestBody UserInfo userInfo) {
        UserEntity user = userRepository.save(new UserEntity(userInfo.getFirstName(), userInfo.getLastName()));
        return ResponseEntity.ok(new UserInfo(user.getId(), userInfo.getFirstName(), userInfo.getLastName()));

    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUser() {
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/firstname")
    public ResponseEntity<Void> updateFirstNameUsers(){
        List<UserEntity> entity = userRepository.findAll();
        for(UserEntity user : entity){
            user.setFirstName("Ekaterina");
        }
        userRepository.saveAll(entity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/lastname")
    public ResponseEntity<Void> updateLastNameUsers(){
        List<UserEntity> entity = userRepository.findAll();
        for(UserEntity user : entity){
            user.setLastName("Volkonskaya");
        }
        userRepository.saveAll(entity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("users/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") long userId){
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("users/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") long userId, @RequestBody UserInfo userInfo){
        UserEntity user = userRepository.findById(userId).get();
        user.setFirstName(userInfo.getFirstName());
        user.setLastName(userInfo.getLastName());
        return ResponseEntity.ok().build();
    }
}
