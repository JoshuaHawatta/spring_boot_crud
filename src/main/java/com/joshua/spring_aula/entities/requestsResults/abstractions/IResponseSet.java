package com.joshua.spring_aula.entities.requestsResults.abstractions;

public interface IResponseSet<T> {
    Integer getStatusCode();
    void setStatusCode(Integer statusCode);
    T getResult();
    void setResult(T result);
}
