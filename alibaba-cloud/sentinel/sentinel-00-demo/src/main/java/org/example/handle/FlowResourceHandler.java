package org.example.handle;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class FlowResourceHandler {

    /**
     * 通过 SphU 手动定义资源
     */
    public static String testAbySphU(String serverPort) {
        Entry entry = null;
        try {
            entry = SphU.entry("testAbySphU");
            //您的业务逻辑 - 开始
            return "服务访问成功------testA：" + serverPort;
            //您的业务逻辑 - 结束
        } catch (BlockException e1) {
            //流控逻辑处理 - 开始
            return "testA 服务被限流";
            //流控逻辑处理 - 结束
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    /**
     * 通过 SphO 手动定义资源
     */
    public static String testBbySphO(String serverPort) {
        if (SphO.entry("testBbySphO")) {
            // 务必保证finally会被执行
            try {
                return "服务访问成功------testB：" + serverPort;
            } finally {
                SphO.exit();
            }
        } else {
            // 资源访问阻止，被限流或被降级
            //流控逻辑处理 - 开始
            return "testB 服务被限流";
            //流控逻辑处理 - 结束
        }
    }

}
