package learning_4.aaa;

public class FinalObject1 {

    private final int i;

    FinalObject1() {
        i = 2;
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        int i1 = new FinalObject1().getI();
        System.out.println(i1);
    }
}
