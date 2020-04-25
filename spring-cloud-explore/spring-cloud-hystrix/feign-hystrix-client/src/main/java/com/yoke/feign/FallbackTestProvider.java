package com.yoke.feign;

import org.springframework.stereotype.Component;

@Component
public class FallbackTestProvider implements TestProvider {
    public String checkUser(String username) {
        return "FallbackTestProvider response check user";
    }
}
