package learning_1.week_15;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean(name = "userDO")
    public UserDO getUserDO() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("aa");
        return userDO;
    }

    @Bean(name = "adviceDO")
    public AdviceDO getAdviceDemo() {
        AdviceDO demo = new AdviceDO();
        return demo;
    }

    @Bean(name = "logicDO")
    public LogicDO getLogicDO() {
        LogicDO logicDO = new LogicDO();
        return logicDO;
    }
}
