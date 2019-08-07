package com.turtles.testsecurity.repository;

import com.turtles.testsecurity.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

     Account findOneByLoginAndPassword(String login, String password);
}
