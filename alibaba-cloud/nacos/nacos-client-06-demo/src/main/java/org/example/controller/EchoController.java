package org.example.controller;

import org.example.service.EchoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class EchoController {

    @Resource
    private EchoService echoService;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return echoService.echo(string);
    }

}
