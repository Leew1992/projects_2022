package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.client.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@DefaultProperties(defaultFallback = "globalHandleTimeout") //全局的服务降级方法
@RequestMapping("/global")
@RestController
public class GlobalController {

    @Resource
    private RibbonService ribbonService;

    @HystrixCommand
    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Integer time) {
        return ribbonService.sleep(Optional.ofNullable(time).orElse(0));
    }

    /**
     * 全局的fallback，适用于当前类中所有方法，无参数
     */
    public String globalHandleTimeout() {
        return "global xxx time out!";
    }
}
