package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.client.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RequestMapping("/fallback")
@RestController
public class FallBackController {

    @Resource
    private RibbonService ribbonService;

    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Integer time) {
        return ribbonService.sleep(Optional.ofNullable(time).orElse(0));
    }
}
