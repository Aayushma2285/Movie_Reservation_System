package com.texas.MovieReservationSystem.dao;

import com.texas.MovieReservationSystem.dto.MovieDto;
import com.texas.MovieReservationSystem.enums.Status;
import com.texas.MovieReservationSystem.model.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from movie where status= ?1"
    )
    List<Movie> findByStatus(String status);
}
