package com.yoke.web;

import com.yoke.config.WebMVCConfig;
import com.yoke.config.WebRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 配置Spring配置类
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    /**
     * 配置SpringMVC配置类
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMVCConfig.class};
    }

    /**
     * 配置DispatcherServlet的拦截资源符
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
