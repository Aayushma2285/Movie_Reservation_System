package com.texas.MovieReservationSystem.service;

import com.texas.MovieReservationSystem.dto.TicketDto;
import com.texas.MovieReservationSystem.dto.UserDto;

import java.util.List;

public interface TicketService {
    public void saveTicket(TicketDto ticketDto);
    public List<TicketDto> findAllTickets();
    public List<TicketDto> findByUserId(Integer bookedBy);
    public TicketDto findById(Integer id);
}
