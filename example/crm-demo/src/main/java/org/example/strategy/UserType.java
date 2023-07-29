package org.example.strategy;

import org.example.enums.UserEnum;

import java.lang.annotation.*;

/**
 * 《策略类枚举》
 * 用来标识不同类型的策略类
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface UserType {

    UserEnum[] value();
}
