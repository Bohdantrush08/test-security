package com.turtles.testsecurity.service;

import com.turtles.testsecurity.entity.Account;
import com.turtles.testsecurity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserService userService;

    public Account createAccount(Account account) {
        if (isExist(account.getLogin())) {
            return null;
        }
        account.setUser(userService.createUser(account.getUser()));
        account = accountRepository.save(account);
        return account;
    }

    public Account getAccount(String login, String password) {
        if (!isExist(login)) {
            return null;
        }
        Account account = accountRepository.findOneByLoginAndPassword(login, password);
        if (account != null) {
            return account;
        }
        return null;
    }

    public boolean isExist(String login) {
        return false;
    }

    public Account getAccountById(Long id) {
        return accountRepository.getOne(id);
    }

}
