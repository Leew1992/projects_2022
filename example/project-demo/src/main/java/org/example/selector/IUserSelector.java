package org.example.selector;

import org.example.enums.UserEnum;
import org.example.strategy.UserStrategy;

/**
 * 《选择器接口》
 * 用来统一，获取策略实现类，的入口
 */
public interface IUserSelector {

    UserStrategy select(UserEnum userEnum);
}
