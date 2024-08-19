package com.app.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel{
    private String title;
    private String year;
    private String director;
    private List<String> actors;
    private String genre;
    private List<Languages> languages;


}
