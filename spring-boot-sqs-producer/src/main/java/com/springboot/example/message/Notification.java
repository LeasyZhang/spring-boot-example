package com.springboot.example.message;

public class Notification {

    private long uerId;
    private String message;

    public long getUerId() {
        return uerId;
    }

    public void setUerId(long uerId) {
        this.uerId = uerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
