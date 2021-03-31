package example.boot.localstack;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsListenerBean {

    private String queueUrl = "http://localhost:4566/000000000000/my-queue";

    private AmazonSQS amazonSQS;

    @Autowired
    public SqsListenerBean(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }

    public void consume() {
        while (true) {
            log.info("build message listener");
            ReceiveMessageRequest request = new ReceiveMessageRequest().withWaitTimeSeconds(20).withQueueUrl(queueUrl);
            ReceiveMessageResult result = null;
            try {
                log.info("start receive message");
                result = amazonSQS.receiveMessage(request);
            } catch (Exception e) {
                log.error("receive message error", e);
            }

            for (Message message : result.getMessages()) {
                log.warn(message.getBody());
                amazonSQS.deleteMessage(queueUrl, message.getReceiptHandle());
            }
        }
    }
}
