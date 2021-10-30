package com.sda.moviedb.controller;


import com.sda.moviedb.repository.UserRepository;
import com.sda.moviedb.vo.UserRatingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserRatingVo> getAllUsers() {
        return userService.getAllUsersWIthMovieRatings();
    }
}
