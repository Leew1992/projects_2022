package org.example.event;

import lombok.Getter;
import org.example.response.RespUserVO;
import org.springframework.context.ApplicationEvent;

@Getter
public class QueryUserEvent extends ApplicationEvent {

    // 事件对象
    private final RespUserVO respUserVO;

    public QueryUserEvent(Object source, RespUserVO respUserVO) {
        super(source);
        this.respUserVO = respUserVO;
    }
}
