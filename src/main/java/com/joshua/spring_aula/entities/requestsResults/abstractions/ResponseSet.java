package com.joshua.spring_aula.entities.requestsResults.abstractions;

public abstract class ResponseSet<T> implements IResponseSet<T> {
    private Integer statusCode;
    protected T result;

    //GETTERS_AND_SETTERS
    @Override
    public Integer getStatusCode() { return statusCode; }

    @Override
    public void setStatusCode(Integer statusCode) { this.statusCode = statusCode; }

    @Override
    public void setResult(T result) { this.result = result; }
}
