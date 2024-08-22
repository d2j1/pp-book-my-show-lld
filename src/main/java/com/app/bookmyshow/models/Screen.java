package com.app.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;

    @ManyToOne
    private Theater theater;
    @Enumerated(value = EnumType.STRING)
    @Element
    private List<Feature> features;


}
