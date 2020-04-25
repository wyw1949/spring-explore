package com.yoke.service;

/**
 * 计算服务，提供一些计算的功能
 */
public interface CalculateService {
    /**
     * 若干整数求和
     * @param num 若干整数
     * @return 计算结果
     */
    Integer sum(Integer... num);
}
