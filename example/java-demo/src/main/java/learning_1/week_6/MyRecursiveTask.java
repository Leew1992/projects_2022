package learning_1.week_6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Long> {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    private long workLoad = 0;

    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() { // 计算
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.workLoad > 16) {
            System.out.println(Thread.currentThread().getName() + "; " + formatter.format(LocalDateTime.now()) + "; Splitting workLoad : " + this.workLoad);

            List<MyRecursiveTask> subTasks = new ArrayList<>();
            subTasks.addAll(createSubTasks());

            for (MyRecursiveTask subtask : subTasks) {
                subtask.fork(); // 分叉 重开一个线程执行
            }

            long result = 0;
            for (MyRecursiveTask subTask : subTasks) {
                result += subTask.join();
            }
            return result;
        } else {
            System.out.println(Thread.currentThread().getName() + "; " + formatter.format(LocalDateTime.now()) + "; doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<MyRecursiveTask> createSubTasks() {
        List<MyRecursiveTask> subTasks =
                new ArrayList<>();
        MyRecursiveTask subTask1 = new MyRecursiveTask(this.workLoad / 2);
        MyRecursiveTask subTask2 = new MyRecursiveTask(this.workLoad / 2);
        subTasks.add(subTask1);
        subTasks.add(subTask2);
        return subTasks;
    }
}
