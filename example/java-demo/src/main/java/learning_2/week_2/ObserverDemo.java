package learning_2.week_2;

import java.util.Observable;

public class ObserverDemo extends Observable {

    public static void main(String[] args) {
        ObserverDemo demo = new ObserverDemo();

        demo.addObserver((o, arg) -> {
            System.out.println("observer1");
        });

        demo.addObserver((o, arg) -> {
            System.out.println("observer2");
        });

        demo.setChanged(); // 添加改变
        demo.notifyObservers(); // 唤醒所有的观察者
    }
}
