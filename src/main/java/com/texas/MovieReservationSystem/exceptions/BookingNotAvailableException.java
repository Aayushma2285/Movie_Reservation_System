package com.texas.MovieReservationSystem.exceptions;

import java.awt.print.Book;

public class BookingNotAvailableException extends RuntimeException{
    public BookingNotAvailableException(String message){
        super(message);
    }
}
