package org.example.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.example.service.HystrixService;
import org.springframework.stereotype.Service;

@Service
public class HystrixServiceImpl implements HystrixService {

    @HystrixCommand(fallbackMethod = "timeoutFallback",
                   commandProperties =
    //规定 3 秒钟以内就不报错，正常运行，超过 3 秒就报错，调用指定的方法
    {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @Override
    public String sleep(Integer time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sleep finish!";
    }

    public String timeoutFallback(int time) {
        return "thread execute time out! time: " + time;
    }

    @HystrixCommand(fallbackMethod = "breakerFallback", commandProperties = {
            //以下参数在 HystrixCommandProperties 类中有默认配置
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000"), //统计时间窗
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计时间窗内请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
    })
    @Override
    public String breaker(Integer id) {
        if (id == null || id < 0) {
            throw new RuntimeException("id can't negative number");
        }
        return String.valueOf(id);
    }

    public String breakerFallback(Integer id) {
        return "circuit breaker fallback; id: " + id;
    }
}
