package com.turtles.testsecurity.entity;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String login;

    @Column
    private String password;

    @ManyToOne
    private User user;
}
