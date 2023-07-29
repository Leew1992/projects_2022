package org.example.service.impl;


import org.example.event.QueryUserEvent;
import org.example.request.ReqUserVO;
import org.example.response.RespUserVO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public RespUserVO getUser(ReqUserVO reqVO) {
        if (Objects.isNull(reqVO) || Objects.isNull(reqVO.getUserId())) {
            return null;
        }
        RespUserVO respUserVO = new RespUserVO(reqVO.getUserId(), "a001", "zhangsan");
        applicationContext.publishEvent(new QueryUserEvent(this, respUserVO));
        return respUserVO;
    }
}
