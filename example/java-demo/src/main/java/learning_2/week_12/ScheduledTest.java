package learning_2.week_12;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTest {

    @Scheduled(cron = "0/5 * * * * ? ")
    public void scheduled() {
        System.out.println("spring scheduled test...");
    }
}
