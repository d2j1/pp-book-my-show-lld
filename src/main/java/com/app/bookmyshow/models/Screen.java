package com.app.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen extends BaseModel{
    private String name;
    private List<Seat> seats;
    private Theater theater;
    private List<Feature> features;


}
