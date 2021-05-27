package com.shop.dynamo.controller;

import com.shop.dynamo.model.UserDetail;
import com.shop.dynamo.repo.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @GetMapping("/ping")
    public ResponseEntity ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDetail> searchUserById(@PathVariable("userId") String userId) {
        Optional<UserDetail> userDetail = userDetailRepository.findById(userId);
        return ResponseEntity.ok(userDetail.get());
    }

    @PostMapping("/user")
    public ResponseEntity<UserDetail> searchUserById(@RequestBody UserDetail user) {
        UserDetail userDetail = userDetailRepository.save(user);
        return ResponseEntity.ok(userDetail);
    }

}
