package learning_2;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@ControllerAdvice
public class Test1 {
    @NotNull(message = "不能为空")
    private String name;
    @Future
    volatile int age = 999;
    static String year = "2022";
    final String type = "human";
    private final int TYPE = 666;

    public Test2 test2;

    @ExceptionHandler(Exception.class)
    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
