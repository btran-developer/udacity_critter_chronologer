package com.udacity.jdnd.course3.critter.error_response;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ValidationErrorResponse {
    private HttpStatus status;
    private Map<String, String> errors;

    public ValidationErrorResponse(Map<String, String> errors) {
        this.status = HttpStatus.BAD_REQUEST;
        this.errors = errors;
    }

    public ValidationErrorResponse(Map<String, String> errors, HttpStatus status) {
        this.status = status;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
