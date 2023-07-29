package org.example.service.impl;


import org.example.mapper.UserMapper;
import org.example.mapper.entity.UserDO;
import org.example.request.ReqUserVO;
import org.example.response.RespUserVO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    ApplicationContext applicationContext;

    BeanCopier beanCopier = BeanCopier.create(UserDO.class, RespUserVO.class, false);

    @Override
    public RespUserVO getUser(ReqUserVO reqVO) {
        RespUserVO respVO = new RespUserVO();
        if (Objects.isNull(reqVO) || Objects.isNull(reqVO.getUserId())) {
            return null;
        }
        UserDO userDO = userMapper.selectById(reqVO.getUserId());
        beanCopier.copy(userDO, respVO, null);
        return respVO;
    }
}
