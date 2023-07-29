package org.example.listener;

import org.example.event.QueryUserEvent;
import org.example.response.RespUserVO;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class QueryUserListener implements ApplicationListener<QueryUserEvent> {

    @Override
    public void onApplicationEvent(QueryUserEvent queryUserEvent) {
        RespUserVO respUserVO = queryUserEvent.getRespUserVO();
        System.out.println("QueryUserListener result: " + respUserVO);
    }

}
