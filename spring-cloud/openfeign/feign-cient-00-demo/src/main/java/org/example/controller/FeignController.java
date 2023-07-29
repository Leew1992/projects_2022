package org.example.controller;

import org.example.client.request.ReqUserVO;
import org.example.client.response.RespUserVO;
import org.example.client.service.RibbonService;
import org.example.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private UserService userService;

    @Resource
    private RibbonService ribbonService;

    @PostMapping("/test")
    public RespUserVO getUser(@RequestBody ReqUserVO reqVO) {
        return userService.getUser(reqVO);
    }

    @GetMapping("/get")
    public String get() {
        return ribbonService.get();
    }

    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Integer time) {
        return ribbonService.sleep(Optional.ofNullable(time).orElse(0));
    }
}
