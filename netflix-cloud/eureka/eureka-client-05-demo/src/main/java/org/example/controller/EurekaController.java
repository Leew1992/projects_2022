package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/eureka")
@RestController
public class EurekaController {

    @GetMapping("/get")
    public String get() {
        return "eureka-client-05";
    }
}
