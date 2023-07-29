package learning_1.week_5;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimerTest{

    public static void main(String[] args) {
        // test();
        test2();
    }

    /**
     * 两个定时线程执行，其中一个执行失败，则其他的定时线程也会终止。
     */
    private static void test() {
        Timer timer = new Timer();
        Timer01 test1 = new Timer01("TimerTask_1");
        Timer02 test2 = new Timer02("TimerTask_2");
        timer.schedule(test1, 2000L, 1000L);
        timer.schedule(test2, 3000L, 1500L);
        System.out.println("main end...");
    }

    /**
     * scheduleAtFixedRate: 按固定的时间执行，无论任务是否执行完。
     * scheduleWithFixedRate：按任务执行完后，固定的时间来执行。
     *
     * 两个定时线程执行，其中一个执行失败，不影响另一个。
     */
    private static void test2() {
        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        try {
            threadPoolExecutor.scheduleAtFixedRate(new Timer01("Timer01"), 1, 1, TimeUnit.SECONDS);
            threadPoolExecutor.scheduleAtFixedRate(new Timer02("Timer02"), 2, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }


}
