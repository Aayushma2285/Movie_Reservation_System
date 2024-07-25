package com.texas.MovieReservationSystem.Implementation;

import com.texas.MovieReservationSystem.dao.MovieRepo;
import com.texas.MovieReservationSystem.dto.MovieDto;
import com.texas.MovieReservationSystem.dto.UserDto;
import com.texas.MovieReservationSystem.enums.Status;
import com.texas.MovieReservationSystem.exceptions.UserNotFoundException;
import com.texas.MovieReservationSystem.model.Movie;
import com.texas.MovieReservationSystem.model.User;
import com.texas.MovieReservationSystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieImpl implements MovieService {
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public void saveUser(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setName(movieDto.getName());
        movie.setStatus(movieDto.getStatus());
        movie.setTimeSlotList(movieDto.getTimeSlotList());
        movie.setPrice(movieDto.getPrice());
        movie.setTotalNumberOfSeats(movieDto.getTotalNumberOfSeats());
        movieRepo.save(movie);
    }
    @Override
    public List<MovieDto> findAllMovies() {
        List<Movie> MovieList = movieRepo.findAll();
        List<MovieDto> movieDtoList = MovieList.stream()
                .map(movie -> {
                    MovieDto movieDto = new MovieDto(
                            movie.getId(), movie.getName(), movie.getStatus(), movie.getTimeSlotList(), movie.getPrice(), movie.getTotalNumberOfSeats()
                    );
                    return movieDto;
                }).collect(Collectors.toList());
        return movieDtoList;
    }

    @Override
    public MovieDto findById(Integer id) {
        Movie movie = movieRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Movie with id "+id+"not found."));

        return ConverToDto(movie);
    }

    @Override
    public List<MovieDto> findByFlag(Status status) {
        List<Movie> movieList = movieRepo.findByStatus(status.name());
        List<MovieDto> movieDtoList = movieList.stream()
                .map(movie -> ConverToDto(movie))
                .collect(Collectors.toList());
        return movieDtoList;
    }

    @Override
    public void updateById(Integer id, MovieDto movieDto) {
        Optional<Movie> movieOptional = movieRepo.findById(id);
        if(movieOptional.isPresent()){
            Movie movie = movieOptional.get();
            movie.setName(movieDto.getName());
            movie.setStatus(movieDto.getStatus());
            movie.setTimeSlotList(movieDto.getTimeSlotList());
            movie.setTotalNumberOfSeats(movie.getTotalNumberOfSeats());
            movieRepo.save(movie);
            System.out.println("Movie saved successfully.");
        }else {
            throw new UserNotFoundException("Movie with "+id+"does not exist in database.");
        }
    }

    private MovieDto ConverToDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setName(movie.getName());
        movieDto.setStatus(movie.getStatus());
        movieDto.setTimeSlotList(movie.getTimeSlotList());
        movieDto.setPrice(movie.getPrice());
        movieDto.setTotalNumberOfSeats(movie.getTotalNumberOfSeats());
        return (movieDto);
    }
}
