package org.example.handle;

import org.springframework.web.bind.annotation.PathVariable;

public class FallbackHandler {

    public static String getFallback(@PathVariable String string, Throwable e) {
        return "getFallback param: " + string + "; exception: " + e;
    }
}
