package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mapper.entity.Account;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {
    Account selectByUserId(Long userId);
    int decrease(Long userId, BigDecimal money);
}
