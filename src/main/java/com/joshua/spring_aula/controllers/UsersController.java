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
                var emptyResult = new ResponseResultWithMessage<>(200, users);
                emptyResult.setMessage("Nenhum usuário encontrado!");

                return ResponseSet.sendResponse(emptyResult);
            }

            return ResponseSet.sendResponse(new ResponseResult<>(200, users));
        } catch(Exception exception) {
            return ResponseSet.sendResponse(
                new ResponseResult<>(500, "Não foi possível realizar a busca!")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseSet<?>> getOneUser(Long id) {
        Optional<Users> user = usersRepository.findById(id);

        if(user.isEmpty())
            return ResponseSet.sendResponse(new ResponseResult<>(404, "Usuário não encontrado!"));

        try {
            Users foundUser = user.get();

            ResponseResultWithMessage<Users> results = new ResponseResultWithMessage<>(200, foundUser);
            results.setMessage("Olá " + foundUser.getName() + "!");

            return ResponseSet.sendResponse(results);
        } catch(Exception exception) {
            return ResponseSet.sendResponse(
                new ResponseResult<>(500, "Não foi possível realizar a busca!")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseSet<?>> getUserByName(String name) {
        if(name.isEmpty())
            return ResponseSet.sendResponse(new ResponseResult<>(422, "Nome obrigatório!"));

        try {
            return ResponseSet.sendResponse(
                new ResponseResult<>(200, usersRepository.getByName((name.trim().toLowerCase())))
            );
        } catch(Exception exception) {
            return ResponseSet.sendResponse(
                new ResponseResult<>(500, "Erro na busca, tente mais tarde!")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseSet<?>> registerUser(Users RBUser) {
        if(RBUser.getName().isEmpty())
            return ResponseSet.sendResponse(new ResponseResult<>(422, "Nome obrigatório!"));
        else if(RBUser.getAge() == null)
            return ResponseSet.sendResponse(new ResponseResult<>(422, "Idade obrigatória!"));

        Users user = new Users(RBUser.getName(), RBUser.getAge());

        try {
            usersRepository.save(user);

            ResponseResultWithMessage<Users> results = new ResponseResultWithMessage<>(201, user);
            results.setMessage("Bem-vindo(a) ao sistema, " + user.getName() + "!");

            return ResponseSet.sendResponse(results);
        } catch(Exception exception) {
            return ResponseSet.sendResponse(
                new ResponseResult<>(500, "Ops, Tenta criar sua conta mais tarde!")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseSet<?>> updateUser(Long id, Users RBUser) {
        if(id == null)
            return ResponseSet.sendResponse(new ResponseResult<>(422, "ID necessário!"));

        Optional<Users> user = usersRepository.findById(id);

        if(user.isEmpty())
            return ResponseSet.sendResponse(new ResponseResult<>(404, "Usuário não encontrado!"));

        try {
            Users foundUser = user.get();

            foundUser.setName(RBUser.getName());
            foundUser.setAge(RBUser.getAge());

            usersRepository.save(foundUser);
            return ResponseSet.sendResponse(new ResponseResult<>(200, foundUser));
        } catch(Exception exception) {
            return ResponseSet.sendResponse(
                new ResponseResult<>(500, "Ops, tenta atualizar seus dados mais tarde!")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseSet<?>> deleteUser(Long id) {
        if(id == null)
            return ResponseSet.sendResponse(new ResponseResult<>(422, "ID inválido!"));

        Optional<Users> user = usersRepository.findById(id);

        if (user.isEmpty())
            return ResponseSet.sendResponse(new ResponseResult<>(404, "Usuário não encontrado!"));

        try {
            Users foundUser = user.get();

            usersRepository.deleteById(foundUser.getId());

            return ResponseSet.sendResponse(
                new ResponseResult<>(200, "Até logo, obrigado pelos peixes!")
            );
        } catch (Exception exception) {
            return ResponseSet.sendResponse(
                new ResponseResult<>(500, "Ops, tenta deletar sua conta mais tarde!")
            );
        }
    }
}
