package learning_4.aaa;

public class AbsClass1 {

    AbsClass1() {
        super();
    }

    AbsClass1(Object obj) {
        this();
    }

    public static void main(String[] args) {
        AbsClass1 absClass1 = new AbsClass1(1);
        System.out.println(absClass1);
    }
}
