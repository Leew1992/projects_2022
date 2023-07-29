package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.request.ReqUserVO;
import org.example.response.RespUserVO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crm-demo/user")
@Api(value = "用户相关")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    @ApiOperation(value = "获取用户信息")
    public ResponseEntity<RespUserVO> getUser(@RequestBody ReqUserVO reqVO) {
        return ResponseEntity.ok(userService.getUser(reqVO));
    }
}
