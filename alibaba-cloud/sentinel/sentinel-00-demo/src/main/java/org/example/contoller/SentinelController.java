package org.example.contoller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.example.handle.FlowBlockHandler;
import org.example.handle.FlowResourceHandler;
import org.example.handle.FlowRuleHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/sentinel")
@RestController
public class SentinelController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/testA")
    public String testA() {
        return FlowResourceHandler.testAbySphU(serverPort);
    }

    @GetMapping("/testB")
    public String testB() {
        return FlowResourceHandler.testBbySphO(serverPort);
    }

    @GetMapping("/testC")
    @SentinelResource(value = "testCbyAnnotation") //通过注解定义资源
    public String testC() {
        return "服务访问成功------testC：" + serverPort;
    }

    /**
     * 通过 Sentinel 控制台定义流控规则
     */
    @GetMapping("/testD")
    @SentinelResource(value = "testD-resource", blockHandler = "blockHandlerTestD", blockHandlerClass = FlowBlockHandler.class) //通过注解定
    public String testD() {
        FlowRuleHandler.initFlowRules();
        return "服务访问成功------testD：" + serverPort;
    }

    /**
     * 通过 Sentinel 控制台定义流控规则
     */
    @GetMapping("/testE")
    @SentinelResource(value = "testE-resource", blockHandler = "blockHandlerTestE", blockHandlerClass = FlowBlockHandler.class) //通过注解定
    public String testE() {
        FlowRuleHandler.initDegradeRule();
        return "服务访问成功------testE：" + serverPort;
    }
}
