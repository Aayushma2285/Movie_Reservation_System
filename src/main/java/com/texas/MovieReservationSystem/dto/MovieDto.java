package com.texas.MovieReservationSystem.dto;

import com.texas.MovieReservationSystem.enums.Status;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class MovieDto {
    private Integer id;
    private String name;
    private Status status;
    private List<String> timeSlotList;
    private Integer totalNumberOfSeats;

    private Integer price;

    public MovieDto(Integer id, String name, Status status, List<String> timeSlotList, Integer price, Integer totalNumberOfSeats) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.timeSlotList = timeSlotList;
        this.price = price;
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public MovieDto() {
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
