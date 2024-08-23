package com.app.bookmyshow.dtos;

import com.app.bookmyshow.models.ResponseStatusL;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {

    private int userId;
    private ResponseStatusL responseStatus;
    private String message;


}
