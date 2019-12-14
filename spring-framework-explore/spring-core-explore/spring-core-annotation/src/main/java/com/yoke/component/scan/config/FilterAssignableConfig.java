package com.yoke.component.scan.config;

import com.yoke.component.scan.filter.assignable.AssignanleBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.yoke.component.scan.filter.assignable"},
        // 要想下面的includeFilters单一生效，此处必须置为false
        useDefaultFilters = false,
        // 将com.yoke.component.scan.filter.annotation包中的所有@MyBeanScan注解的类注册为bean
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {AssignanleBean.class}
                )
        }
)
public class FilterAssignableConfig {
}
