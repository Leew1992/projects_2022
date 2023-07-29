package learning_2.week_13;

public class GenericTest3 {
    // level 1
    class Food {}

    // level 2
    class Fruit extends Food {}
    class Meat extends Food {}

    // level 3
    class Apple extends Fruit {}
    class Banana extends Fruit {}

    class Pork extends Meat {}
    class Beef extends Meat {}

    // level 4
    class RedApple extends Apple {}
    class GreenApple extends Apple {}

    class Plate<T> {
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    class Plat2 {

    }

    private void test(Plate<? extends Fruit> food) {
        // set的值只能为null，其它值会报错
        // food.setT(new Fruit());
        food.getT();
    }

    private void test1(Plate<? super Fruit> food1) {
        food1.setT(new Fruit());
        // 只能用null承接，其它类型（Food）接收会报错
        Object r = food1.getT();
    }
}
