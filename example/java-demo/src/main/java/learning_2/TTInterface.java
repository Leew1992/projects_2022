package learning_2;

public interface TTInterface {

    String a = "";

    default void sayOK() {
        System.out.println("OK");
    }

    void sayHello();

    void sayYe();

}
