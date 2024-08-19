package com.app.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseModel{
    private SeatType seatType;
    private Show show;
    private int price;

}
