package com.joshua.spring_aula.entities;

import com.joshua.spring_aula.entities.requestsResults.ResponseResult;
import com.joshua.spring_aula.entities.requestsResults.abstractions.ResponseSet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    //NOT_FOUND
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseSet<?>> handleNullPointerException(NullPointerException e) {
        return ResponseSet.sendResponse(new ResponseResult<>(404, e.getMessage()));
    }

    //UNPROCESSABLE_ENTITY
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseSet<?>> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseSet.sendResponse(new ResponseResult<>(422, e.getMessage()));
    }

    //SERVER_ERROR
    @ExceptionHandler(UnknownError.class)
    public ResponseEntity<ResponseSet<?>> HandleUnknownError(UnknownError e) {
        return ResponseSet.sendResponse(new ResponseResult<>(500, "Algo deu errado aqui, Tente isso depois!"));
    }
}