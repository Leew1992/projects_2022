package org.example;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThirdObject {
    private String code;
    private SecondObject second;
}
