package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.client.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RequestMapping("/hystrix")
@RestController
public class HystrixController {

    @Resource
    private RibbonService ribbonService;

    @HystrixCommand(fallbackMethod = "handleTimeout") //为该请求指定专属的回退方法
    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Integer time) {
        return ribbonService.sleep(Optional.ofNullable(time).orElse(0));
    }

    /**
     * 业务方法指定的fallback，和业务方法的参数、返回值，保持一致。
     */
    public String handleTimeout(Integer time) {
        return "specific sleep time out! time: " + time;
    }
}
