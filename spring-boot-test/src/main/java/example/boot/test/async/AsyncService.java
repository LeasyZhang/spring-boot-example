package example.boot.test.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class AsyncService {

    public MyTask myTask;

    @Autowired
    public AsyncService(MyTask myTask) {
        this.myTask = myTask;
    }

    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void asyncTask() {
        executorService.submit(() -> myTask.execute());
    }
}
