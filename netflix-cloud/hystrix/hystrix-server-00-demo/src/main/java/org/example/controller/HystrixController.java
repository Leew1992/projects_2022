package org.example.controller;

import org.example.service.HystrixService;
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
    private HystrixService hystrixService;

    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Integer time) {
        return hystrixService.sleep(Optional.ofNullable(time).orElse(0));
    }

    @GetMapping("/breaker/{id}")
    public String breaker(@PathVariable Integer id) {
        return hystrixService.breaker(id);
    }
}
