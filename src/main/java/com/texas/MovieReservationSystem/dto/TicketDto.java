package com.texas.MovieReservationSystem.dto;

import com.texas.MovieReservationSystem.model.Movie;
import com.texas.MovieReservationSystem.model.Ticket;
import com.texas.MovieReservationSystem.model.User;

public class TicketDto {
    private Integer id;
    private Integer movieId;
    private Integer numberOfSeats;
    private String date;
    private String time;
    private String price;
    private Integer bookedBy;

    private String movieName;

    private String bookedByName;


    public TicketDto(Integer id, Integer movieId, Integer numberOfSeats, String date, String time, String price, Integer bookedBy, String movieName, String bookedByName) {
        this.id = id;
        this.movieId = movieId;
        this.numberOfSeats = numberOfSeats;
        this.date = date;
        this.time = time;
        this.price = price;
        this.bookedBy = bookedBy;
        this.movieName = movieName;
        this.bookedByName = bookedByName;
    }

    public TicketDto(Ticket ticket){
        this.id=ticket.getId();
        this.movieId=ticket.getMovie().getId();
        this.date=ticket.getDate();
        this.time=ticket.getTime();
        this.numberOfSeats=ticket.getNumberOfSeats();
        this.price=String.valueOf(ticket.getTotalPrice());
        this.bookedBy=ticket.getBookedBy().getId();
        this.bookedByName=ticket.getBookedBy().getName();
        this.movieName=ticket.getMovie().getName();
    }

    public TicketDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(Integer bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getBookedByName() {
        return bookedByName;
    }

    public void setBookedByName(String bookedByName) {
        this.bookedByName = bookedByName;
    }
}
