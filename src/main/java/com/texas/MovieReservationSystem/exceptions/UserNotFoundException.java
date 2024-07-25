package com.texas.MovieReservationSystem.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }

}
