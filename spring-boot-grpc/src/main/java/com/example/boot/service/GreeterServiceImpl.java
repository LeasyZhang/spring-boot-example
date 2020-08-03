package com.example.boot.service;

import com.example.boot.GreeterGrpc;
import com.example.boot.Greeting;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void hello(Greeting.HelloRequest request, StreamObserver<Greeting.HelloReply> responseObserver) {
        Greeting.HelloReply reply = Greeting.HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
