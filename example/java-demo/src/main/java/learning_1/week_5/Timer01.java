package learning_1.week_5;

import java.util.TimerTask;

public class Timer01 extends TimerTask {

    private String taskName;

    public Timer01(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " running !");
    }
}
