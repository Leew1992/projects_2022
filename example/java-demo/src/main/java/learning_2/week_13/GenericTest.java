package learning_2.week_13;

import learning_2.other.VipUser;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        // 1.编译期间直接添加会报错
        // list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        // 2.运行期间通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);

    }

    class Node<T> {
        public T data;
        public Node(T data) { this.data = data; }
        public void setData(T data) {
            System.out.println("Node.setData");
            this.data = data;
        }
    }

    class MyNode extends Node<Integer> {
        public MyNode(Integer data) { super(data); }

        public void setData(Integer data) {
            System.out.println("MyNode.setData");
            super.setData(data);
        }
    }

    private void test() {
        Object a = new Object();
        Object b = new Object();
    }

    private void testList() {
        List<? super VipUser> list = new ArrayList<>();
        // list.add("sss");//报错

        List list2 = new ArrayList<>();
        list2.add("sss");//警告信息
    }
}
