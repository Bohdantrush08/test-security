package com.turtles.testsecurity.convertor;

import com.turtles.testsecurity.dto.SignUpDTO;
import com.turtles.testsecurity.entity.Account;
import com.turtles.testsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountConvertor {

    @Autowired
    private UserConvertor userConvertor;

    public SignUpDTO toSignUpDTO(Account account){
        SignUpDTO signUpDTO = new SignUpDTO();

        signUpDTO.setLogin(account.getLogin());
        signUpDTO.setPassword(account.getPassword());
        signUpDTO.setName(account.getUser().getName());
        signUpDTO.setSurname(account.getUser().getSurname());
        signUpDTO.setEmail(account.getUser().getEmail());

        return signUpDTO;
    }

    public Account fromSignUpDto(SignUpDTO signUpDTO){
        Account account = new Account();

        account.setLogin(signUpDTO.getLogin());
        account.setPassword(signUpDTO.getPassword());
        account.setUser(userConvertor.fromSignUpDTO(signUpDTO));

        return account;
    }
}
