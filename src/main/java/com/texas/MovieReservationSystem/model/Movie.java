package com.texas.MovieReservationSystem.model;

import com.texas.MovieReservationSystem.enums.Status;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq", allocationSize = 1, initialValue = 1, sequenceName = "movie_name")
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    @CollectionTable(name = "movie_time_slots")
    private List<String> timeSlotList;
    private Integer price;
    private Integer totalNumberOfSeats;

    public Movie() {
    }

    public Movie(Integer id, String name, Status status, List<String> timeSlotList, Integer price, Integer totalNumberOfSeats) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.timeSlotList = timeSlotList;
        this.price = price;
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<String> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(List<String> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }

    public Integer getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(Integer totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }
}
