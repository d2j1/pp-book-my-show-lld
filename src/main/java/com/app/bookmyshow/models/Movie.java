package com.app.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String title;
    private String year;
    private String director;

    @ElementCollection
    private List<String> actors;
    private String genre;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Languages> languages;


}
