package com.yoke.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign-hystrix-client", fallback = GetHystrixFeignForProviderImpl.class)
public interface GetHystrixFeignForProvider {

    @GetMapping("/feign/hystrix/forProvider")
    public String forProvider();
}
