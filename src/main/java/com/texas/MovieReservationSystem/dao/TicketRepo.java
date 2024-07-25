package com.texas.MovieReservationSystem.dao;

import com.texas.MovieReservationSystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByBookedById(Integer bookedBy);
    @Query(
            nativeQuery = true,
            value = "select sum(number_of_seats) from ticket where movie_id=?1 and date = ?2 and time = ?3;"
    )
    Integer findTotalBookedSeatByMovieDateAndTime(Integer movieId, String date, String time);
}
