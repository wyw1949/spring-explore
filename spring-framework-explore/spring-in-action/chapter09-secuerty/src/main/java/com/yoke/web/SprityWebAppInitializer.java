package com.yoke.web;

import com.yoke.config.WebMVCConfig;
import com.yoke.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SprityWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMVCConfig.class, WebSecurityConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
