package com.app.bookmyshow.services;

import com.app.bookmyshow.models.User;
import com.app.bookmyshow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password){

        // check if email id already exists.
       Optional<User> optUser =  userRepository.findByEmail(email);

       if(optUser.isPresent()){
           throw new RuntimeException("User already exists");
       }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName("Temp user");
        user.setLastName("Temp User");
        return userRepository.save(user);
    }
}
