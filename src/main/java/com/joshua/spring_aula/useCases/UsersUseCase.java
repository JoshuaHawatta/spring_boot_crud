package com.joshua.spring_aula.useCases;

import com.joshua.spring_aula.entities.requestsResults.IRequestResult;
import com.joshua.spring_aula.models.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
@ResponseBody
public interface UsersUseCase {
    @GetMapping
    public ResponseEntity<IRequestResult<?>> getAllUsers();

    @GetMapping(value = "/{id}")
    public ResponseEntity<IRequestResult<?>> getOneUser(@PathVariable Long id);

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<IRequestResult<?>> getUserByName(@PathVariable String name);

    @PostMapping(value = "/register")
    public ResponseEntity<IRequestResult<?>> registerUser(@RequestBody Users RBUser);

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<IRequestResult<?>> updateUser(@PathVariable Long id, @RequestBody Users RBUser);

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<IRequestResult<?>> deleteUser(@PathVariable Long id);
}
