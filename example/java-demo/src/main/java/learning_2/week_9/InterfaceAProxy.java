package learning_2.week_9;

public class InterfaceAProxy {

    private InterfaceA interfaceA;

    InterfaceAProxy (InterfaceA ia) {
        interfaceA = ia;
    }

    public void testProxy() {
        System.out.println("proxy start");
        interfaceA.test();
        System.out.println("proxy end");
    }

}
