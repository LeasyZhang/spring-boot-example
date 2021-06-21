package example.scheduler.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private final CounterService counter;

    @Autowired
    public CounterController(CounterService counter) {
        this.counter = counter;
    }

    public Map<String, Long> displayCounter() {
        Map<String, Long> data = new HashMap<>();
        data.put("recurring_executions", counter.read());
        return data;
    }
}
