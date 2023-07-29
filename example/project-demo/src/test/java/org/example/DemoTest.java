package org.example;

import org.example.command.UserCmd;
import org.example.controller.UserController;
import org.example.enums.UserEnum;
import org.example.request.ReqUserVO;
import org.example.response.RespUserVO;
import org.example.selector.impl.UserSelector;
import org.example.strategy.UserStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Resource
    public UserController userController;

    @Resource
    private UserSelector userSelector;

    @Test
    public void test() {
        ReqUserVO reqUserVO = new ReqUserVO(1L);
        ResponseEntity<RespUserVO> respTestVO = userController.getUser(reqUserVO);
        System.out.println(respTestVO);
    }

    @Test
    public void test2() {
        UserCmd userCmd = new UserCmd(1, 1L, "a001", "zhangsan");
        UserStrategy strategy = userSelector.select(UserEnum.USER_TYPE_STUDENT);
        strategy.handle(userCmd);
    }
}
