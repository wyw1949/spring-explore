package com.yoke.service.impl;

import com.yoke.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * java8实现{@link CalculateService}
 * 通过lambda的形式求和
 */
@Profile("Java8")
@Service
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... num) {
        System.out.println("Java8 实现求和计算");
        return Stream.of(num).reduce(0, Integer::sum);
    }
}
