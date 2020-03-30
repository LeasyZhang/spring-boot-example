package com.springboot.example.exception;

public class SQSException extends RuntimeException {

    public SQSException(Throwable ex) {
        super(ex);
    }

    public SQSException(String message) {
        super(message);
    }

    public SQSException(String message, Throwable ex) {
        super(message, ex);
    }
}
