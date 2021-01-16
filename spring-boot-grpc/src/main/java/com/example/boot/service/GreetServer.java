package com.example.boot.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class GreetServer {

    @Autowired
    private GreeterServiceImpl greeterService;

    private Server server;

    public void start() throws IOException, InterruptedException {
        int port = 8093;

        server = ServerBuilder.forPort(port)
                .addService(greeterService)
                .build().start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            stop();
            System.err.println("*** server shut down");
        }));

        blockUntilShutdown();
    }

    public void stop() {
        if (this.server != null) {
            this.server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (this.server != null) {
            this.server.awaitTermination();
        }
    }
}
