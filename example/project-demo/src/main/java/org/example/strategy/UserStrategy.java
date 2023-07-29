package org.example.strategy;

import org.example.command.UserCmd;

/**
 * 《策略接口》
 * 用来处理某一类逻辑的多种不同操作
 * 比如：四则运算（一类逻辑），加减乘除（不同操作）。
 */
public interface UserStrategy {

    /**
     * UserCmd 命令模式，用于统一不同操作的入参结构
     * @param userCmd 命令行对象
     */
    void handle(UserCmd userCmd);

}
