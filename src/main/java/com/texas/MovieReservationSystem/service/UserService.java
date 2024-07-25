package com.texas.MovieReservationSystem.service;

import com.texas.MovieReservationSystem.dto.UserDto;
import com.texas.MovieReservationSystem.model.User;

import java.util.List;

public interface UserService {
    public void saveUser(UserDto userDTO);
    public List<UserDto> findAllUsers();
    public UserDto findById(Integer id);
    public String updateById(Integer id, UserDto userDto);
}
