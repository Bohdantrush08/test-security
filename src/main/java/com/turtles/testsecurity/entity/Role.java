package com.turtles.testsecurity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_privilege",
            joinColumns = {@JoinColumn(name = "Role_id")},
            inverseJoinColumns = {@JoinColumn(name = "Privilege_id")}
    )
    private List<Role> privileges;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Role> privileges) {
        this.privileges = privileges;
    }
}
