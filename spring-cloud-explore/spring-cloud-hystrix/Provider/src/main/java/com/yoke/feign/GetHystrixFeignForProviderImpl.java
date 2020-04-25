package com.yoke.feign;

import org.springframework.stereotype.Component;

@Component
public class GetHystrixFeignForProviderImpl implements GetHystrixFeignForProvider{
    @Override
    public String forProvider() {
        return "FallbackTestProvider response for provider";
    }
}
