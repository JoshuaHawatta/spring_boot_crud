package com.joshua.spring_aula.controllers;

import com.joshua.spring_aula.entities.requestsResults.IRequestResult;
import com.joshua.spring_aula.entities.requestsResults.RequestResult;
import com.joshua.spring_aula.models.Users;
import com.joshua.spring_aula.repositories.UsersRepository;
import com.joshua.spring_aula.useCases.UsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController implements UsersUseCase {
    @Autowired
    UsersRepository usersRepository;

    public ResponseEntity<IRequestResult<?>> getAllUsers() {
        try {
            List<Users> users = usersRepository.findAll();
            IRequestResult<List<Users>> results;

            if(users.size() == 0) {
                results = new RequestResult<>(users, "Nenhum usuário encontrado!", 200);
                return ResponseEntity.status(results.getStatusCode()).body(results);
            }

            results = new RequestResult<>(users, 200);
            return ResponseEntity.status(results.getStatusCode()).body(results);
        } catch(Exception exception) {
            RequestResult<Exception> badResult = new RequestResult<>(exception.getMessage(), 500);
            return ResponseEntity.status(badResult.getStatusCode()).body(badResult);
        }
    }

    @Override
    public ResponseEntity<IRequestResult<?>> getOneUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<IRequestResult<?>> getUserByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<IRequestResult<?>> registerUser(Users RBUser) {
        return null;
    }

    @Override
    public ResponseEntity<IRequestResult<?>> updateUser(Long id, Users RBUser) {
        return null;
    }

    @Override
    public ResponseEntity<IRequestResult<?>> deleteUser(Long id) {
        return null;
    }
}
