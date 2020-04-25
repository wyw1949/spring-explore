package com.yoke.service.impl;

import com.yoke.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * java7实现{@link com.yoke.service.CalculateService}
 * 通过for循环的形式求和
 */
@Profile("Java7")
@Service
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... num) {
        System.out.println("Java7 实现求和计算");
        Integer sum = 0;
        for (Integer nu : num){
            sum += nu;
        }
        return sum;
    }
}
