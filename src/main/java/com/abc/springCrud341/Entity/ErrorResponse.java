package com.abc.springCrud341.Entity;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int Status;
    private String error;
    private String message;

    public ErrorResponse(LocalDateTime timeStamp, int status, String error, String message) {
        this.timeStamp = timeStamp;
        Status = status;
        this.error = error;
        this.message = message;
    }

    public ErrorResponse(LocalDateTime now, String message, String bookNotFound) {
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
