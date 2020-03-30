package com.yoke.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SpelBean {

    @Value("#{T(System).currentTimeMillis()}")
    private Long time;

    @Value("#{new java.util.Date()}")
    private Date current;

    @Value("#{componentBean.sum(10)}")
    private Integer sum;

    @Value("#{\"a\" + \"b\"}")
    private String ab;

    /*
     * ？的作用是进行非空判断，如果componentBean为null，不进行方法调用，表达式返回null
     */
    @Value("#{componentBean?.getMap()['name']}")
    private String name;

    /*
     * Spel支持运算符
     * 算术运算符：+、-、 * 、/、%、^
     * 比较运算符：< 、 > 、 == 、 <= 、 >= 、 lt 、 gt 、 eq 、 le 、 ge
     * 逻辑运算符：and 、 or 、 not 、│
     * 条件运算符：?: (ternary) 、 ?: (Elvis)
     * 正则表达式
     */
    @Value("#{(1>2) or (componentBean != null)}")
    private Boolean bool;

    @Value("#{componentBean != null ? '存在' : '不存在'}")
    private String exists;

    // Elvis运算
    @Value("#{null ?: 'abc'}")
    private String elvis;

    public Long getTime() {
        return time;
    }

    public Date getCurrent() {
        return current;
    }

    public Integer getSum() {
        return sum;
    }

    public String getAb() {
        return ab;
    }

    public String getName() {
        return name;
    }

    public Boolean getBool() {
        return bool;
    }

    public String getExists() {
        return exists;
    }

    public String getElvis() {
        return elvis;
    }
}
