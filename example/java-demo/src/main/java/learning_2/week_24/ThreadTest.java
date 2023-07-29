package learning_2.week_24;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 2000; i ++) {
            Thread thread = new Thread();
            threads.add(thread);
        }
    }
}
