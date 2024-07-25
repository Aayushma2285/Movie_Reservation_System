package com.texas.MovieReservationSystem.controller;

import com.texas.MovieReservationSystem.dto.TicketDto;
import com.texas.MovieReservationSystem.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public String saveUser(@Valid @RequestBody TicketDto ticketDto){
        ticketService.saveTicket(ticketDto);
        return "Ticket Saved Successfully";
    }

    @GetMapping("/list")
    public List<TicketDto> findAll(){
        List<TicketDto> list = ticketService.findAllTickets();
        return list;
    }

    @GetMapping("/user-id/{bookedBy}")
    public List<TicketDto> findByUserId(@PathVariable Integer bookedBy){
        List<TicketDto> dtoList = ticketService.findByUserId(bookedBy);
        return dtoList;
    }

    @GetMapping("/{id}")
    public TicketDto findById(@PathVariable Integer id){
        TicketDto ticket = ticketService.findById(id);
        return ticket;
    }
}
