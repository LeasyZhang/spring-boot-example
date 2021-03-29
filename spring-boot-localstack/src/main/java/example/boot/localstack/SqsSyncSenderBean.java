package example.boot.localstack;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;

@Slf4j
@Component
public class SqsSyncSenderBean {

    private final AmazonSQS amazonSQS;

    public SqsSyncSenderBean(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }

    @PostConstruct
    public void sendHelloMessage() {
        log.info("hello from sync sender!!!");
        SendMessageRequest request = new SendMessageRequest("my-queue", "new sync message at second " + ZonedDateTime.now().getSecond());
        amazonSQS.sendMessage(request);
    }
}
