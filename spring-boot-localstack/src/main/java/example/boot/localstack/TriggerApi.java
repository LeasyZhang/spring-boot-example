package example.boot.localstack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggerApi {

    private SqsListenerBean sqsListenerBean;

    @Autowired
    public TriggerApi(SqsListenerBean sqsListenerBean) {
        this.sqsListenerBean = sqsListenerBean;
    }

    @GetMapping("/trigger")
    public String trigger() {
        sqsListenerBean.consume();
        return "success";
    }
}
