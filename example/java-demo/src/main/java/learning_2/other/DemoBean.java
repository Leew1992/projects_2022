package learning_2.other;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DemoBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
