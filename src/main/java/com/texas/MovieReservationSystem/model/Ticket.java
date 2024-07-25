package com.texas.MovieReservationSystem.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", allocationSize = 1, initialValue = 1, sequenceName = "ticket_name")
    private Integer id;
    private Integer numberOfSeats;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private String date;
    private String time;
    private Integer totalPrice;
    @ManyToOne
    @JoinColumn(name = "Booked_By")
    private User bookedBy;

    public Ticket(Integer id, Integer numberOfSeats, Movie movie, String date, String time, Integer totalPrice, User bookedBy) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.totalPrice = totalPrice;
        this.bookedBy = bookedBy;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
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

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer price) {
        this.totalPrice = price;
    }
}
