package com.joshua.spring_aula.controllers;

import com.joshua.spring_aula.entities.requestsResults.ResponseResult;
import com.joshua.spring_aula.entities.requestsResults.ResponseResultWithMessage;
import com.joshua.spring_aula.models.Users;
import com.joshua.spring_aula.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.joshua.spring_aula.entities.requestsResults.abstractions.ResponseSet;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    UsersServices services;

    @GetMapping
    public ResponseEntity<ResponseSet<?>> findAll() {
        return ResponseSet.sendResponse(new ResponseResult<>(200, services.findAll()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseSet<?>> findById(@PathVariable Long id) {
        var user = services.findById(id);
        var results = new ResponseResultWithMessage<>(200, user);

        results.setMessage("Olá, " + user.getName() + "!");

        return ResponseSet.sendResponse(results);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<ResponseSet<?>> findByName(@PathVariable String name) {
        return ResponseSet.sendResponse(new ResponseResult<>(200, services.findByName(name)));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<ResponseSet<?>> save(@RequestBody Users RBUser) {
        services.save(RBUser);

        var results = new ResponseResultWithMessage<>(201, RBUser);
        results.setMessage("Bem-vindo(a) ao sistema, " + RBUser.getName() + "!");

        return ResponseSet.sendResponse(results);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseSet<?>> updateUser(@PathVariable Long id, @RequestBody Users RBUser) {
        services.update(id, RBUser);
        return ResponseSet.sendResponse(new ResponseResult<>(200, RBUser));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseSet<?>> deleteUser(@PathVariable Long id) {
        services.deleteById(id);

        return ResponseSet.sendResponse(
            new ResponseResult<>(200, "Até mais, obrigado pelos peixes!")
        );
    }
}
