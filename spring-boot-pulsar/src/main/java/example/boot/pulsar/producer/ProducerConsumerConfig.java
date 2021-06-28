package example.boot.pulsar.producer;

import org.apache.pulsar.client.api.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConsumerConfig {

    private static final String SERVICE_URL = "pulsar://localhost:6650";
    private static final String TOPIC_NAME = "test-topic";
    private static final String SUBSCRIPTION_NAME = "subscription";

    @Bean
    public PulsarClient client() throws PulsarClientException {
        return PulsarClient.builder().serviceUrl(SERVICE_URL).build();
    }

    @Bean
    public Producer<byte[]> producer() throws PulsarClientException {
        return client().newProducer().topic(TOPIC_NAME).compressionType(CompressionType.LZ4).create();
    }

    @Bean
    public Consumer<byte[]> consumer() throws PulsarClientException {
        return client().newConsumer().topic(TOPIC_NAME).subscriptionType(SubscriptionType.Shared).subscriptionName(SUBSCRIPTION_NAME).subscribe();
    }
}
