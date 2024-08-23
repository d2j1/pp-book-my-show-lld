package com.app.bookmyshow.dtos;

import com.app.bookmyshow.models.ResponseStatusL;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookTicketResponseDto {
    private int bookingId;
    private int amountl;
    private ResponseStatusL responseStatus;
}
