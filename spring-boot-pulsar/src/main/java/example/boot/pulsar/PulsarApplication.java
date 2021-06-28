package example.boot.pulsar;

import org.apache.pulsar.client.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@SpringBootApplication
public class PulsarApplication implements CommandLineRunner {

    @Autowired
    private Producer<byte[]> producer;
    @Autowired
    private Consumer<byte[]> consumer;

    public static void main(String[] args) {
        SpringApplication.run(PulsarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> produce());
        service.submit(() -> consume());
    }

    private void produce() {
        IntStream.range(1, 5).forEach(i -> {
            String content = String.format("hi-pulsar-%d", i);

            Message<byte[]> msg = MessageBuilder.create()
                    .setContent(content.getBytes())
                    .build();
            try {
                MessageId msgId = producer.send(msg);
            } catch (PulsarClientException e) {
                e.printStackTrace();
            }
        });
    }

    private void consume() {
        while (!consumer.hasReachedEndOfTopic()) {
            String result = consumer.receiveAsync().thenApply(message -> new String(message.getValue())).join();
            System.out.println("result " + result);
        }
    }
}
