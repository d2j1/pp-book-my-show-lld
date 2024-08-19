package com.app.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Show extends BaseModel {
    private Movie movie;
    private Date startTime;
    private int duration;
    private Screen screen;
    private List<ShowSeat> showSeats;
    private List<ShowSeatType> showSeatTypes;

}
