package com.app.bookmyshow.controller;

import com.app.bookmyshow.dtos.BookTicketRequestDto;
import com.app.bookmyshow.dtos.BookTicketResponseDto;
import com.app.bookmyshow.models.Booking;
import com.app.bookmyshow.models.ResponseStatusL;
import com.app.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto requestDto){
        BookTicketResponseDto responseDto = new BookTicketResponseDto();

        try{
            Booking booking = bookingService.bookTicket(requestDto.getShowSeatIds(), requestDto.getShowId(), requestDto.getUserId());

            responseDto.setBookingId(booking.getId());
            responseDto.setAmountl(booking.getAmount());
            responseDto.setResponseStatus(ResponseStatusL.SUCCESS);

        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatusL.FAILURE);
        }

        return responseDto;
    }

}
