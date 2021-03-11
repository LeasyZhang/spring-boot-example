package example.boot.test.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.google.common.util.concurrent.MoreExecutors;

@Runwith(SpringRunner.class)
@Import(AsyncService.class)
public class AsyncServiceTest {
    @Autowired
    private AsyncService asyncService;
    @MockBean
    private MyTask myTask;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field field = AsyncService.class.getDeclaredField("executorService");

        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, MoreExecutors.newDirectExecutorService());
    }

    @Test
    public void testAsyncService() {
        asyncService.asyncTask();
        verify(myTask, times(1)).execute();
    }
}
