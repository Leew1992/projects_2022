package org.example.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class FlowBlockHandler {

    /**
     * 限流之后的逻辑
     * @param exception
     * @return
     */
    public static String blockHandlerTestD(BlockException exception) {
        return "TestD服务访问失败! 您已被限流，请稍后重试";
    }

    /**
     * 限流之后的逻辑
     * @param exception
     * @return
     */
    public static String blockHandlerTestE(BlockException exception) {
        return "TestE服务访问失败! 您已被限流，请稍后重试";
    }
}
