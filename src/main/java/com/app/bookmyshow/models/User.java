package com.app.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends BaseModel {

    private String name;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private List<Booking> bookings;


    private
}
