package com.turtles.testsecurity.convertor;

import com.turtles.testsecurity.dto.SignUpDTO;
import com.turtles.testsecurity.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserConvertor {

    public User fromSignUpDTO(SignUpDTO signUpDTO){
        User user = new User();
        user.setName(signUpDTO.getName());
        user.setSurname(signUpDTO.getName());
        user.setEmail(signUpDTO.getEmail());

        return user;
    }
}
