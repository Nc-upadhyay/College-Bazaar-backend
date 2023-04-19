package com.nc.college.bazaar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class UserException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public UserException(HttpStatus httpStatus, String msg) {
        super();
        this.status = httpStatus;
        this.message = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
