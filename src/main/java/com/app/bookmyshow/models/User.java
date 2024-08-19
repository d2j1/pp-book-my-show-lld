package com.app.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {

    private String name;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private List<Booking> bookings;
}
