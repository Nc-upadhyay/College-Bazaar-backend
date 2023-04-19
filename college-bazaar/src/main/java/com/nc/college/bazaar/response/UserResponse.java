package com.nc.college.bazaar.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class UserResponse {
    private HttpStatus httpStatus;
    private String msg;

    public UserResponse(HttpStatus httpStatus, String msg) {
        super();
        this.httpStatus = httpStatus;
        this.msg = msg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
