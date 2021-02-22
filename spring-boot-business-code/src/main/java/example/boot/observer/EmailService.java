package example.boot.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        log.info("[user] {} registered in {}", event.getUserName(), event.getTimestamp());
        log.info("Send email for new user {}", event.getUserName());
    }
}
