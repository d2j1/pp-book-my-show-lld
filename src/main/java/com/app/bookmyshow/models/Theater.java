package com.app.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel {

    private String name;
    private String address;

//    private List<Screen> screens;

    @ManyToOne
    private Region region;



}
