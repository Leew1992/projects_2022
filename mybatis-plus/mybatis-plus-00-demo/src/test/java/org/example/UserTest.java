package org.example;

import org.example.controller.UserController;
import org.example.request.ReqUserVO;
import org.example.response.RespUserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    public UserController userController;

    @Test
    public void test() {
        ReqUserVO reqUserVO = new ReqUserVO(1L);
        ResponseEntity<RespUserVO> respTestVO = userController.getUser(reqUserVO);
        System.out.println(respTestVO);
    }
}
