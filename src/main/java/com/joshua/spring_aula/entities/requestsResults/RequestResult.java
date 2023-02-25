package com.joshua.spring_aula.entities.requestsResults;

public class RequestResult<T> implements IRequestResult<T> {
    private T result;
    private String message;
    private Integer statusCode;

    //CONSTRUCTORS_OVERLOADS
    public RequestResult(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public RequestResult(T result, Integer statusCode) {
        this.result = result;
        this.statusCode = statusCode;
    }

    public RequestResult(T result, String message, Integer statusCode) {
        this.result = result;
        this.message = message;
        this.statusCode = statusCode;
    }

    //GETTERS_AND_SETTERS
    public T getResult() { return result; }

    public void setResult(T result) { this.result = result; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public Integer getStatusCode() { return statusCode; }

    public void setStatusCode(Integer statusCode) { this.statusCode = statusCode; }
}
