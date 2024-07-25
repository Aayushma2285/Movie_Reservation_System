package com.texas.MovieReservationSystem.controller;

import com.texas.MovieReservationSystem.dto.MovieDto;
import com.texas.MovieReservationSystem.enums.Status;
import com.texas.MovieReservationSystem.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/save")
    public String saveUser(@Valid @RequestBody MovieDto movieDto){
        movieService.saveUser(movieDto);
        return "Movie Saved successfully";
    }

    @GetMapping("/list")
    public List<MovieDto> findAll(){
        List<MovieDto> list = movieService.findAllMovies();
        return list;
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable Integer id){
        MovieDto movie = movieService.findById(id);
        return movie;
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable Integer id, @RequestBody MovieDto movieDto){
        movieService.updateById(id, movieDto);
    }

    @GetMapping("/getList/{status}")
    public List<MovieDto> findByStatus(@PathVariable Status status){
        List<MovieDto> movieList = movieService.findByFlag(status);
        return movieList;
    }
}
