package learning_2.week_3;

import org.springframework.stereotype.Service;

@Service("userService1")
public class UserService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
