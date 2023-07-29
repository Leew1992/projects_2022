package learning_1.week_5;

import java.util.TimerTask;

public class Timer02 extends TimerTask {

    private String taskName;

    public Timer02(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        int i = 1 / 0;
        System.out.println(taskName + " running !");
    }
}
