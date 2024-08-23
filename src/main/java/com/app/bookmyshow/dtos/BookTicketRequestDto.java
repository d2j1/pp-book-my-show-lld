package com.app.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class BookTicketRequestDto {
    private List<Integer> showSeatIds;
    private int showId;
    private int userId;


}
