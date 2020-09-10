package com.udacity.jdnd.course3.critter.error_response;

import org.springframework.http.HttpStatus;

public class NotFoundErrorResponse {
    private HttpStatus status;
    private String message;

    public NotFoundErrorResponse(String message) {
        this.status = HttpStatus.NOT_FOUND;
        this.message = message;
    }

    public NotFoundErrorResponse(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
