package com.joshua.spring_aula.useCases;

import com.joshua.spring_aula.entities.requestsResults.abstractions.ResponseSet;
import com.joshua.spring_aula.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
@ResponseBody
public interface UsersUseCase {
    @GetMapping
    public ResponseEntity<ResponseSet<?>> getAllUsers();

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseSet<?>> getOneUser(@PathVariable Long id);

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<ResponseSet<?>> getUserByName(@PathVariable String name);

    @PostMapping(value = "/register")
    public ResponseEntity<ResponseSet<?>> registerUser(@RequestBody Users RBUser);

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseSet<?>> updateUser(@PathVariable Long id, @RequestBody Users RBUser);

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseSet<?>> deleteUser(@PathVariable Long id);
}
