package learning_2.week_13;

import java.util.List;

public class GenericTest2 {

    class Shape { /* ... */ }
    class Circle extends Shape { /* ... */ }
    class Rectangle extends Shape { /* ... */ }

    class Node<T> { /* ... */ }

    class Node2<T> {
        private Node2<? extends T> node;
        private Node2<? super T> childNode;

        public Node2<? extends T> getNode() {
            return node;
        }

        public void setNode(Node2<? extends T> node) {
            this.node = node;
        }

        public Node2<? super T> getChildNode() {
            return childNode;
        }

        public void setChildNode(Node2<? super T> childNode) {
            this.childNode = childNode;
        }
    }

    /**
     * 因为 Node<Circle> 不是 Node<Shape> 的子类
     * 只有参数类型是继承关系，但整体类不是继承关系。
     * 不同的参数类型，对应的同样的类名，不算同一个类。
     */
    // Node<Circle> nc = new Node<>();
    // Node<Shape>  ns = nc;

    /**
     * 类的继承
     */
    class ChildNode<T> extends Node<T>{

    }
    ChildNode<Circle> nc = new ChildNode<>();
    // 满足类的继承
    Node<Circle>  ns = nc;


    public static void print(List<? extends Number> list) {
        for (Number n : list) {
            System.out.print(n + " ");
            // list.add(n); // extends 不能添加元素
        }
        System.out.println();
    }

    public static void add(List<? super ChildNode> nodes) {
        for (Object node : nodes) {
            System.out.println(node);
        }
    }

    public void test2(Node2<? extends Node2> node) {
        node.setNode(new Node2<>());
        node.getNode();

        node.getChildNode();
        node.setChildNode(new Node2<>());
    }
}
