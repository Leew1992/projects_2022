package learning_1.week_18;

public class OutClass {

    private static String name = "aa";

    private String name1 = "aaa";

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        name = name;
    }

    static class InnerClass {

        /**
         * 2、可以定义静态方法和静态变量
         */
        private static String address = "bb";

        public static void test() {
            /**
             * 1、可以访问外部类方法和外部变量
             */
            System.out.println(name);
            String var = getName();
            System.out.println(var);
        }
    }

    class GeneralInnerClass {

        public void test1() {
            /**
             * 可以访问静态方法和静态属性
             */
            System.out.println(name);
            System.out.println(getName());
            /**
             * 可以访问普通方法和普通属性
             */
            System.out.println(name1);
            System.out.println(getName1());
        }
    }

    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        ic.test();
    }

}
