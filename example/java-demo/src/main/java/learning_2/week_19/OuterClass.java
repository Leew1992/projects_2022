package learning_2.week_19;

public class OuterClass {
    private String name;

    static class staticInnerClass {
        static String staticField;
    }

    class generalInnerClass {
        public String generalField;

        public void testGeneralMethod() {
            System.out.println("generalMethod");
        }
    }

    public static void main(String[] args) {
        OuterClass myOuterClass = new OuterClass();
        generalInnerClass general = myOuterClass.new generalInnerClass();
        general.testGeneralMethod();

        System.out.println(staticInnerClass.staticField);
    }
}
