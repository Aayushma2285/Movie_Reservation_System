package com.texas.MovieReservationSystem.Implementation;

import com.texas.MovieReservationSystem.dao.MovieRepo;
import com.texas.MovieReservationSystem.dao.TicketRepo;
import com.texas.MovieReservationSystem.dao.UserRepo;
import com.texas.MovieReservationSystem.dto.TicketDto;
import com.texas.MovieReservationSystem.exceptions.BookingNotAvailableException;
import com.texas.MovieReservationSystem.exceptions.UserNotFoundException;
import com.texas.MovieReservationSystem.model.Movie;
import com.texas.MovieReservationSystem.model.Ticket;
import com.texas.MovieReservationSystem.model.User;
import com.texas.MovieReservationSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void saveTicket(TicketDto ticketDto) {

        Ticket ticket = new Ticket();

        Movie movie = movieRepo.findById(ticketDto.getMovieId()).orElseThrow(
                () -> new RuntimeException("Movie not found")
        );
        List<String> timeSlotList = movie.getTimeSlotList();
        boolean validTimeSlot = timeSlotList.contains(ticketDto.getTime());
        if (!validTimeSlot){
            throw new RuntimeException("Movie Time is invalid");
        }
        Integer totalBookedSeat = ticketRepo.findTotalBookedSeatByMovieDateAndTime(ticketDto.getMovieId(), ticketDto.getDate(), ticketDto.getTime());
        Integer totalNumberOfSeats = movie.getTotalNumberOfSeats();
        Integer availableSeat = totalNumberOfSeats - totalBookedSeat;
        if(availableSeat<ticketDto.getNumberOfSeats()){
            throw new BookingNotAvailableException("Booking is only available for " +availableSeat+ "seats.");
        }
        ticket.setDate(ticketDto.getDate());
        ticket.setTime(ticketDto.getTime());
        ticket.setMovie(movie);
        ticket.setNumberOfSeats(ticketDto.getNumberOfSeats());
        ticket.setTotalPrice(movie.getPrice()*ticketDto.getNumberOfSeats());
        User bookedBy = userRepo.findById(ticketDto.getBookedBy()).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
        ticket.setBookedBy(bookedBy);
        ticketRepo.save(ticket);
    }

    @Override
    public List<TicketDto> findAllTickets() {
        List<Ticket> TicketList = ticketRepo.findAll();
        List<TicketDto> ticketDtoList = TicketList.stream()
                .map(ticket -> {
                    TicketDto ticketDto = new TicketDto(ticket);
                    return ticketDto;
                }).collect(Collectors.toList());
        return ticketDtoList;
    }

    @Override
    public List<TicketDto> findByUserId(Integer bookedBy){
        List<Ticket> ticketList = ticketRepo.findByBookedById(bookedBy);
        List<TicketDto> ticketDtoList = ticketList.stream()
                .map(ticket -> {
                    TicketDto ticketDto = new TicketDto(ticket);
                    return ticketDto;
                }).collect(Collectors.toList());
        return ticketDtoList;
    }

    @Override
    public TicketDto findById(Integer id) {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not found with id:"+id));

        return ConverToDto(ticket);
    }
    private TicketDto ConverToDto(Ticket ticket){
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setDate(ticket.getDate());
        String parsePrice = String.valueOf(ticket.getTotalPrice());
        ticketDto.setPrice(parsePrice);
        ticketDto.setTime(ticket.getTime());
        ticketDto.setNumberOfSeats(ticket.getNumberOfSeats());
        ticketDto.setBookedBy(ticket.getBookedBy().getId());
        ticketDto.setMovieId(ticket.getMovie().getId());
        ticketDto.setMovieName(ticket.getMovie().getName());
        ticketDto.setBookedByName(ticket.getBookedBy().getName());
        return (ticketDto);

    }
}
