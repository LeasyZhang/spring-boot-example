package example.boot.localstack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class SqsSenderBean {

    private final SqsAsyncClient sqsAsyncClient;

    public SqsSenderBean(SqsAsyncClient sqsAsyncClient) {
        this.sqsAsyncClient = sqsAsyncClient;
    }

    @PostConstruct
    public void sendHelloMessage() throws Exception {
        log.info("hello!!!");
        CompletableFuture<GetQueueUrlResponse> wat = sqsAsyncClient.getQueueUrl(GetQueueUrlRequest.builder().queueName("my-queue").build());
        GetQueueUrlResponse getQueueUrlResponse = wat.get();

        Mono.fromFuture(() -> sqsAsyncClient.sendMessage(
                SendMessageRequest.builder()
                        .queueUrl(getQueueUrlResponse.queueUrl())
                        .messageBody("new message at second " + ZonedDateTime.now().getSecond())
                        .build()
        ))
                .retryWhen(Retry.max(3))
                .repeat(5)
                .subscribe();
    }
}
