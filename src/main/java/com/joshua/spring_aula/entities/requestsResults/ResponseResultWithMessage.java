package com.joshua.spring_aula.entities.requestsResults;

import com.joshua.spring_aula.entities.requestsResults.abstractions.ResponseSet;

public class ResponseResultWithMessage<T> extends ResponseSet<T>  {
    private String message;

    public ResponseResultWithMessage(Integer statusCode, T result) {
        this.setStatusCode(statusCode);
        this.setResult(result);
    }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}
