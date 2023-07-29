package org.example.selector.impl;

import org.example.enums.UserEnum;
import org.example.selector.IUserSelector;
import org.example.strategy.UserStrategy;
import org.example.strategy.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 《选择器实现类》
 * 用来获取对应策略的实现类
 */
@Component
public class UserSelector implements IUserSelector {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public UserStrategy select(UserEnum userEnum) {
        // 根据接口获取配置的所有实现类
        Map<String, UserStrategy> beans = applicationContext.getBeansOfType(UserStrategy.class);
        // 遍历所有实现类
        Set<Map.Entry<String, UserStrategy>> entrySet = beans.entrySet();
        Iterator<Map.Entry<String, UserStrategy>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object interfaceServiceImpl = iterator.next().getValue();
            // 获取实现类的所有注解
            UserType annotationValue = interfaceServiceImpl.getClass().getAnnotation(UserType.class);
            if (null != annotationValue) {
                boolean contain = Arrays.asList(annotationValue.value()).contains(userEnum);
                if (contain) {
                    return (UserStrategy) interfaceServiceImpl;
                }
            }
        }
        return null;
    }
}
