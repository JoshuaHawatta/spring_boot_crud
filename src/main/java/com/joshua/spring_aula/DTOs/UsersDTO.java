package com.joshua.spring_aula.DTOs;

import com.joshua.spring_aula.models.Users;

public class UsersDTO {
    private Long id;
    private String name;

    public UsersDTO() {}

    public UsersDTO(Users user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
