package org.example.contoller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.CircuitBreaker;
import com.alibaba.csp.sentinel.slots.block.degrade.circuitbreaker.EventObserverRegistry;
import com.alibaba.csp.sentinel.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.example.client.service.EchoService;
import org.example.handle.FallbackHandler;
import org.example.handle.FlowRuleHandler;
import org.example.monitor.FlowEventMonitor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequestMapping("/feign")
@RestController
public class FeignController {

    @Resource
    private EchoService echoService;

    @GetMapping("/get/{string}")
    @SentinelResource(value = "fallback", fallback = "getFallback", fallbackClass = FallbackHandler.class)
    public String get(@PathVariable String string) {
        FlowRuleHandler.initDegradeRule();
        new FlowEventMonitor().monitor();
        System.out.println("--------->>>>主业务逻辑");
        if ("a".equals(string)) {
            System.err.println("--------->>>>主业务逻辑，抛出非法参数异常");
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常....");
            //如果查到的记录也是 null 也控制正异常
        }
        if ("b".equals(string)) {
            System.err.println("--------->>>>主业务逻辑，抛出空指针异常");
            throw new NullPointerException("NullPointerException，该ID没有对应记录,空指针异常");
        }
        return echoService.echo(string);
    }
}
