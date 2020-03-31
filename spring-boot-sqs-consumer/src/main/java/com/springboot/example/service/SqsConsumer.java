package com.springboot.example.service;

public interface SqsConsumer {
    void consume();
    void stopConsume();
}
