package learning_2.other;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoConfig implements WebMvcConfigurer {
    @Bean
    public DemoInterceptor getMyInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // getMyInterceptor()这种注册方式可以在拦截器里注入bean
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
    }
}
