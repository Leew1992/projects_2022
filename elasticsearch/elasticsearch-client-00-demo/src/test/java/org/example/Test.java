package org.example;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        ThirdObject third = new ThirdObject("a03", new SecondObject("a02", new FirstObject("a01", "bb")));

        String str = Optional.ofNullable(third).map(ThirdObject::getSecond)
                .map(SecondObject::getFirst).map(FirstObject::getCode).orElse("");

        System.out.println(str);
    }
}
