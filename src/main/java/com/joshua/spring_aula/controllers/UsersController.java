package com.joshua.spring_aula.controllers;

import com.joshua.spring_aula.entities.requestsResults.ResponseResult;
import com.joshua.spring_aula.entities.requestsResults.ResponseResultWithMessage;
import com.joshua.spring_aula.models.Users;
import com.joshua.spring_aula.repositories.UsersRepository;
import com.joshua.spring_aula.useCases.UsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.joshua.spring_aula.entities.requestsResults.abstractions.ResponseSet;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController implements UsersUseCase {
    @Autowired
    UsersRepository usersRepository;

    public ResponseEntity<ResponseSet<?>> getAllUsers() {
        try {
            List<Users> users = usersRepository.findAll();

            if(users.size() == 0) {
                ResponseResultWithMessage<List<Users>> emptyResult = new ResponseResultWithMessage<>(
                200,
                    users
                );

                emptyResult.setMessage("Nenhum usuário encontrado!");

                return ResponseEntity.status(emptyResult.getStatusCode()).body(emptyResult);
            }

            ResponseSet<List<Users>> results = new ResponseResult<>(200, users);
            return ResponseEntity.status(results.getStatusCode()).body(results);
        } catch(Exception exception) {
            ResponseSet<String> badResult = new ResponseResult<>(
                500,
                "Não foi possível realizar a busca!"
            );

            return ResponseEntity.status(badResult.getStatusCode()).body(badResult);
        }
    }

    @Override
    public ResponseEntity<ResponseSet<?>> getOneUser(Long id) {
        Optional<Users> user = usersRepository.findById(id);

        if(user.isEmpty()) {
            ResponseSet<String> emptyResult = new ResponseResult<>(404, "Usuário não encontrado!");
            return ResponseEntity.status(emptyResult.getStatusCode()).body(emptyResult);
        }

        try {
            Users foundedUser = user.get();
            ResponseResultWithMessage<Users> results = new ResponseResultWithMessage<>(200, foundedUser);

            results.setMessage("Olá " + foundedUser.getName() + "!");

            return ResponseEntity.status(results.getStatusCode()).body(results);
        } catch(Exception exception) {
            ResponseSet<String> badResult = new ResponseResult<>(
                500,
                "Não foi possível realizar a busca!"
            );

            return ResponseEntity.status(badResult.getStatusCode()).body(badResult);
        }
    }

    @Override
    public ResponseEntity<ResponseSet<?>> getUserByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseSet<?>> registerUser(Users RBUser) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseSet<?>> updateUser(Long id, Users RBUser) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseSet<?>> deleteUser(Long id) {
        return null;
    }
}
