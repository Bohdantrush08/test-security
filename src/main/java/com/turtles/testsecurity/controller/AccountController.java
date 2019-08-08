package com.turtles.testsecurity.controller;

import com.turtles.testsecurity.convertor.AccountConvertor;
import com.turtles.testsecurity.dto.SignUpDTO;
import com.turtles.testsecurity.entity.Account;
import com.turtles.testsecurity.service.AccountService;
import com.turtles.testsecurity.util.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private AccountConvertor accountConvertor;

    @PostMapping("/account")
    //this function name don't enjoy me .I suggest showCreatedAccount
    public ResponseEntity<SignUpDTO> createNewAccount(@RequestBody SignUpDTO signUpDTO) {
        if (!validate(signUpDTO)) {
            return ResponseEntity.badRequest().build();
        }
        Account account = accountService.createAccount(accountConvertor.fromSignUpDto(signUpDTO));
        return new ResponseEntity<SignUpDTO>(accountConvertor.toSignUpDTO(account), HttpStatus.CREATED);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<SignUpDTO> getAccount(@PathVariable(name = "id") Long id) {
        Account account = accountService.getAccountById(id);
        return new ResponseEntity<SignUpDTO>(accountConvertor.toSignUpDTO(account), HttpStatus.OK);
    }

    private boolean validate(SignUpDTO signUpDTO) {
        if (validationService.allExist(signUpDTO.getLogin(), signUpDTO.getPassword(), signUpDTO.getConfirmPassword(), signUpDTO.getEmail(), signUpDTO.getName(), signUpDTO.getSurname())) {
            return signUpDTO.getConfirmPassword().equals(signUpDTO.getPassword());
        }
        return false;
    }

}
