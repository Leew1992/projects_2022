package org.example.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class UserDO {

    @TableId("user_id")
    private Long userId;

    @TableField("user_code")
    private String userCode;

    @TableField("user_name")
    private String userName;

}
