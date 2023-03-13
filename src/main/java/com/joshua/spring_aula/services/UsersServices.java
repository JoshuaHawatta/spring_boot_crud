package com.joshua.spring_aula.services;

import com.joshua.spring_aula.DTOs.UsersDTO;
import com.joshua.spring_aula.models.Users;
import com.joshua.spring_aula.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class UsersServices {
    @Autowired
    UsersRepository repository;

    public List<UsersDTO> findAll() {
        List<UsersDTO> users = new ArrayList<>();
        for(Users user : repository.findAll()) users.add(new UsersDTO(user));

        return users;
    }

    public UsersDTO findById(Long id) {
        Optional<Users> user = repository.findById(id);

        if(user.isEmpty()) throw new NullPointerException("Usuário não encontrado!");

        return new UsersDTO(user.get());
    }

    public List<UsersDTO> findByName(String name) {
        List<UsersDTO> users = new ArrayList<>();
        for(Users user : repository.findByName(name.trim().toLowerCase())) users.add(new UsersDTO(user));

        return users;
    }

    public void save(Users user) {
        if(user.getName() == null || user.getName().isEmpty() || user.getName().isBlank())
            throw new IllegalArgumentException("Nome obrigatório!");
        else if(user.getAge() == null || user.getAge() <= 0)
            throw new IllegalArgumentException("Idade obrigatória!");

        repository.save(user);
    }

    public void update(Long id, Users user) {
        Optional<Users> dbUser = repository.findById(id);

        if(dbUser.isEmpty()) throw new NullPointerException("Usuário não encontrado!");

        Users foundUser = dbUser.get();

        if(user.getName() == null || user.getName().isEmpty() || user.getName().isBlank())
            throw new IllegalArgumentException("Nome obrigatório!");
        else if(user.getAge() == null || user.getAge() <= 0)
            throw new IllegalArgumentException("Idade obrigatória!");

        foundUser.setName(user.getName());
        foundUser.setAge(user.getAge());

        repository.save(foundUser);
    }

    public void deleteById(Long id) {
        Optional<Users> user = repository.findById(id);

        if(user.isEmpty()) throw new NullPointerException("Usuário não encontrado!");

        repository.deleteById(user.get().getId());
    }
}
