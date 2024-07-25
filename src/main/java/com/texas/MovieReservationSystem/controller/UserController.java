package com.texas.MovieReservationSystem.controller;

import com.texas.MovieReservationSystem.dto.UserDto;
import com.texas.MovieReservationSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@Valid @RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return "User Saved succesfully";
    }

    @GetMapping("/list")
    public List<UserDto> findAll(){
        List<UserDto> list = userService.findAllUsers();
        return list;
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Integer id){
        UserDto user = userService.findById(id);
        return user;
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Integer id, @RequestBody UserDto userDto){
        userService.updateById(id, userDto);
        return "User saved successfully.";
    }
}
