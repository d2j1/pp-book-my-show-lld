package com.app.bookmyshow.services;

import com.app.bookmyshow.models.*;
import com.app.bookmyshow.repository.BookingRepository;
import com.app.bookmyshow.repository.ShowRepository;
import com.app.bookmyshow.repository.ShowSeatRepository;
import com.app.bookmyshow.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository  bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                           BookingRepository bookingRepository
    ) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }


        public Booking bookTicket(List<Integer> showSeatIds, int showId, int userId){

        // get the user using the user id.
        Optional<User> userOpt = userRepository.findById(userId);

        if( userOpt.isEmpty() ){
            throw new RuntimeException("User not found");
        }

        User user = userOpt.get();

        // get show using show id
        Optional<Show> showOpt = showRepository.findById(showId);

        if( showOpt.isEmpty() ){
            throw new RuntimeException("Show not found");
        }

        Show show = showOpt.get();

//         put below till ending the transaction in separate method and annotate it with below
//            @Transactional(isolation = Isolation.SERIALIZABLE)
//      
//        --------- Start Transaction to get the shared lock -------------
        // get show seats via showSeatId's
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for( ShowSeat showSeat : showSeats ){

            //  if seat is not available then we should not proceed further
            if( ! showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ){
                // if not available the return with an error message
                throw new RuntimeException("Selected  seats not available");
            }
        }
        // check if all the seats are available
        for( ShowSeat showSeat : showSeats ){

            //  if seat is not available then we should not proceed further
            if( ! showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ){
                // if yes mark all the seats as available
                showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
                showSeat.setBlockedAt(new Date());

            }
        }
        //  save the seats in the database
        showSeatRepository.saveAll(showSeats);

        //        --------- Stop The Transaction -----------


        // calculate the price

        // using show get all the showSeatTypes
        // traverse the list of selected seats and add the price according to the seat type


        // properly create the booking object save and return it
        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setBookingDate(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(-1);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);

        return bookingRepository.save(booking);
    }

}
