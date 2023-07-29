package org.example.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCmd {
    private Integer userType;
    private Long userId;
    private String userCode;
    private String userName;
}
