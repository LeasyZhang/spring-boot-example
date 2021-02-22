package example.boot.observer;

import org.springframework.context.ApplicationEvent;

public class UserRegisterEvent extends ApplicationEvent {

    private String userName;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
