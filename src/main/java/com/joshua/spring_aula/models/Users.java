package com.joshua.spring_aula.models;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    //CONSTRUCTORS_OVERLOADS
    public Users() {}

    public Users(Long id) { this.id = id; }

    public Users(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //GETTERS_AND_SETTERS
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }
}
