package learning_2.week_1;

import org.springframework.lang.Nullable;

import java.io.Serializable;

public class ExampleDemo implements Serializable {

    @Nullable
    private String name;

    @Nullable
    private Integer age;

    private String address;

    private Integer number;


    public static void main(String[] args) {
        ExampleDemo demo = new ExampleDemo();
        System.out.println(demo);
    }

}
