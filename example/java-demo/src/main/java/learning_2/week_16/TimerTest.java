package learning_2.week_16;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        testTimer();
    }

    private static void testTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask1(), 0, 1000);
    }

    static class TimerTask1 extends TimerTask {
        @Override
        public void run() {
            System.out.println(new SimpleDateFormat("hh:mm:ss.SSS").format(new Date()));
        }
    }
}
