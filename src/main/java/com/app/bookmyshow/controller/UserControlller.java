package com.app.bookmyshow.controller;

import com.app.bookmyshow.dtos.SignUpRequestDto;
import com.app.bookmyshow.dtos.SignUpResponseDto;
import com.app.bookmyshow.models.ResponseStatusL;
import com.app.bookmyshow.models.User;
import com.app.bookmyshow.services.UserService;


public class UserControlller {

    private UserService userService;

    public UserControlller(UserService userService) {
        this.userService = userService;

    }

    SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        SignUpResponseDto responseDto = new SignUpResponseDto();

        try{
            User user = userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());

            responseDto.setResponseStatus(ResponseStatusL.SUCCESS);
            responseDto.setMessage("User added successfully");
            responseDto.setUserId(user.getId());
        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatusL.FAILURE );
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;
    }
}
