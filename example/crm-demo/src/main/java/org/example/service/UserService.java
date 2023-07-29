package org.example.service;

import org.example.request.ReqUserVO;
import org.example.response.RespUserVO;

public interface UserService {

    RespUserVO getUser(ReqUserVO reqVO);
}
