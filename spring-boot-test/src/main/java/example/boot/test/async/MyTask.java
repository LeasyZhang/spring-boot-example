package example.boot.test.async;

import org.springframework.stereotype.Component;

@Component
public class MyTask {

    public void execute() {
        System.out.println("Do something");
    }
}
