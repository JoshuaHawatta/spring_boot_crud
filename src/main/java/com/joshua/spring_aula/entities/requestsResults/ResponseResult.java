package com.joshua.spring_aula.entities.requestsResults;

import com.joshua.spring_aula.entities.requestsResults.abstractions.ResponseSet;

public class ResponseResult<T> extends ResponseSet<T> {
    public ResponseResult(Integer statusCode, T ignoreResult) {
        this.setStatusCode(statusCode);
        this.setResult(ignoreResult);
    }
}
