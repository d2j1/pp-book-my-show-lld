package com.app.bookmyshow.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="shows")
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;
    private Date startTime;
    private int duration;

    @ManyToOne
    private Screen screen;


    private List<ShowSeat> showSeats;
    private List<ShowSeatType> showSeatTypes;

}
