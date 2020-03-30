package com.yoke.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider", fallback = FallbackTestProvider.class)
public interface TestProvider {

    @GetMapping("/provider/test/check-user")
    public String checkUser(@RequestParam("username") String username);
}
