package com.app.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel {
    private List<ShowSeat> showSeats;
    private int amount;
    private List<Payment> payments;
    private User bookedBy;
    private Date bookingDate;
    private BookingStatus bookingStatus;


}
