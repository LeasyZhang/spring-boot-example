package com.example.boot.service;

import com.example.boot.GreeterGrpc;
import com.example.boot.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class GrpcClient {

    private GreeterGrpc.GreeterBlockingStub blockingStub;
    private ManagedChannel channel;

    public void init() {
        String target = "localhost:8093";
        channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void greet() {
        init();
        String name = "Grpc Client";
        Greeting.HelloRequest request = Greeting.HelloRequest.newBuilder().setName(name).build();
        Greeting.HelloReply response;
        try {
            response = blockingStub.hello(request);
        } catch (StatusRuntimeException e) {
            return;
        }

        try {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
