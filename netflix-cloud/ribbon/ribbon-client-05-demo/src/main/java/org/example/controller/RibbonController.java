package org.example.controller;

import org.example.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RequestMapping("/ribbon")
@RestController
public class RibbonController {

    @Resource
    private RibbonService ribbonService;

    @GetMapping("/get")
    public String get() {
        return ribbonService.get();
    }

    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Integer time) {
        return ribbonService.sleep(Optional.ofNullable(time).orElse(0));
    }

    @GetMapping("/breaker/{id}")
    public String breaker(@PathVariable Integer id) {
        return ribbonService.breaker(id);
    }
}
