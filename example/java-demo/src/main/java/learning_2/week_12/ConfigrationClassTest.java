package learning_2.week_12;

import learning_2.other.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class ConfigrationClassTest {

    @Autowired
    private User user;

    @Resource
    private User user1;

    @Bean
    User getUser() {
        return new User();
    }
}
