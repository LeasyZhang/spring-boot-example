package example.scheduler.config;

import com.github.kagkarlsson.scheduler.SchedulerName;
import com.github.kagkarlsson.scheduler.boot.config.DbSchedulerCustomizer;
import com.github.kagkarlsson.scheduler.task.Task;
import com.github.kagkarlsson.scheduler.task.helper.Tasks;
import example.scheduler.scheduler.CounterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Optional;

import static com.github.kagkarlsson.scheduler.task.schedule.Schedules.fixedDelay;

@Slf4j
@Configuration
public class TaskConfiguration {

    @Bean
    public Task<Void> recurringSampleTask(CounterService counter) {
        return Tasks.recurring("recurring sample task", fixedDelay(Duration.ofMinutes(1)))
                .execute((instance, context) -> {
                    log.info("Running recurring simple task, Instance {}, ctx {}", instance, context);
                    counter.increase();
                });
    }

    @Bean
    public Task<Void> sampleOneTimeTask() {
        return Tasks.oneTime("sample one time task")
                .execute((instance, context) -> {
                   log.info("This is one time task");
                });
    }

    @Bean
    public DbSchedulerCustomizer customizer() {
        return new DbSchedulerCustomizer() {
            @Override
            public Optional<SchedulerName> schedulerName() {
                return Optional.of(new SchedulerName.Fixed("spring-boot-scheduler-1"));
            }
        };
    }
}
