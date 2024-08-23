package com.app.bookmyshow.controller;

import com.app.bookmyshow.dtos.SignUpRequestDto;
import com.app.bookmyshow.dtos.SignUpResponseDto;
import com.app.bookmyshow.models.ResponseStatusL;


public class UserControlller {


    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        SignUpResponseDto responseDto = new SignUpResponseDto();

        try{

        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatusL.FAILURE );
            responseDto.setMessage(e.getMessage());
        }
    }
}
