package com.jevigsoft.cicd.exception.dto;

/**
 * @author Navishka Darshana - navishka@learnfi.lk
 * @project my-cicd-project
 * @CreatedBy IntelliJ IDEA
 * @created 26/08/2024 - 23.16
 */


public class CustomAuthenticationException extends RuntimeException {

    private int status;
    private String message;

    public CustomAuthenticationException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
