package learning_1.week_13;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
