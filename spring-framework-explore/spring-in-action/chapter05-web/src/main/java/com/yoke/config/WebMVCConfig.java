package com.yoke.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * springMVC配置
 */
@Configuration
@ComponentScan(basePackages = {"com.yoke.controller"},
        // 要想使includeFilters单独生效，需要将useDefaultFilters设置为false
        // 配置includeFilters实际上是在默认的基础上追加条件，与默认是并集关系
        useDefaultFilters = false,
        includeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        }
)
// 启动MVC
@EnableWebMvc
public class WebMVCConfig extends WebMvcConfigurerAdapter {

        /**
         * 配置视图解析器
         */
        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
                registry.jsp("/WEB-INF/views/", ".jsp");
        }

        /**
         * 配置静态资源的处理
         * 当讲DispatcherServlet的映射配置成"/"时，它会覆盖tomcat默认Servlet。
         * DispatcherServlet将把所有请求都当作是普通请求，对于静态资源的请求会
         * 造成404错误。
         *
         * 配置一个DefaultServletHttpRequestHandler，它会回复tomcat的默认Servlet,当
         * DispatcherServlet找到对应的controller映射时，就由对应的Controller处理，如
         * 果没有找到，就交给 WEB 应用服务器默认的 Servlet 处理，从而找到对应的静态资源，
         * 只有再找不到资源时才会报错。
         *
         * 即将静态资源的处理交还给web容器（tomcat等）处理
         *
         * 也可以通过{@link WebMvcConfigurerAdapter#addResourceHandlers(ResourceHandlerRegistry)}
         * 来配置静态资源，这种方式是springMVC自己来处理静态资源
         */
        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                configurer.enable();
        }

}
