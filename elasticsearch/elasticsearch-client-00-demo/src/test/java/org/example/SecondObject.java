package org.example;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecondObject {
    private String code;
    private FirstObject first;
}
