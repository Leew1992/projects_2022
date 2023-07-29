package learning_2.week_19;

public class AnynomousInnerClass {
    SayHi hi = () -> System.out.println("hi");

    public static void main(String[] args) {
       new AnynomousInnerClass().hi.test();
    }
}
