package org.example.strategy.impl;

import org.example.command.UserCmd;
import org.example.enums.UserEnum;
import org.example.strategy.UserStrategy;
import org.example.strategy.UserType;
import org.springframework.stereotype.Component;

/**
 * 《策略实现类》
 * 具体某个操作的实现类
 */
@UserType(UserEnum.USER_TYPE_STUDENT)
@Component
public class StudentStrategy implements UserStrategy {

    @Override
    public void handle(UserCmd userCmd) {
        System.out.println("student: " + userCmd);
    }

}
