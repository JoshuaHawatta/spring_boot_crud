package com.joshua.spring_aula.entities.requestsResults.abstractions;

import org.springframework.http.ResponseEntity;

public abstract class ResponseSet<T> implements IResponseSet<T> {
    private static Integer statusCode;
    protected T result;

    public static ResponseEntity<ResponseSet<?>> sendResponse(ResponseSet<?> results) {
        return ResponseEntity.status(statusCode).body(results);
    }

    //GETTERS_AND_SETTERS
    @Override
    public Integer getStatusCode() { return statusCode; }

    @Override
    public void setStatusCode(Integer statusCode) { ResponseSet.statusCode = statusCode; }

    @Override
    public T getResult() { return result; }

    @Override
    public void setResult(T result) { this.result = result; }
}
