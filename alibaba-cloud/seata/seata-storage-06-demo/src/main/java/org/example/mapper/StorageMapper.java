package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mapper.entity.Storage;

@Mapper
public interface StorageMapper {
    Storage selectByProductId(Long productId);
    int decrease(Storage record);
}