package com.joshua.spring_aula.entities.requestsResults;

import com.joshua.spring_aula.entities.requestsResults.abstractions.ResponseSet;

public class ResponseResultWithMessage<T> extends ResponseSet<T>  {
    protected String message;

    public ResponseResultWithMessage(Integer statusCode, T ignoreResult) {
        this.setStatusCode(statusCode);
        this.setResult(ignoreResult);
    }

    public void setMessage(String message) { this.message = message; }
}
