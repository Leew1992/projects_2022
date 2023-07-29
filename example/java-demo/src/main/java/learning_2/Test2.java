package learning_2;

import java.util.concurrent.PriorityBlockingQueue;

public class Test2 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        // 方法引用
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(20, (x, y) -> {
            return 0;
        });

    }
}
