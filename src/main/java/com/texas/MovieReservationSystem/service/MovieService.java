package com.texas.MovieReservationSystem.service;

import com.texas.MovieReservationSystem.dto.MovieDto;
import com.texas.MovieReservationSystem.dto.UserDto;
import com.texas.MovieReservationSystem.enums.Status;
import com.texas.MovieReservationSystem.model.Movie;

import java.util.List;

public interface MovieService {
    public void saveUser(MovieDto movieDto);
    public List<MovieDto> findAllMovies();
    public MovieDto findById(Integer id);
    public List<MovieDto> findByFlag(Status status);
    public void updateById(Integer id, MovieDto movieDto);
}
