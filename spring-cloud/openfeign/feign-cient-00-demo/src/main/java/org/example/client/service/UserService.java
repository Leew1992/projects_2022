package org.example.client.service;

import org.example.client.request.ReqUserVO;
import org.example.client.response.RespUserVO;
import org.example.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="crm-demo", url="http://localhost:8000/crm-demo/user", configuration = FeignConfig.class)
@Component
public interface UserService {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    RespUserVO getUser(ReqUserVO reqVO);
}
