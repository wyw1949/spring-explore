package com.yoke.web;

import com.yoke.multipart.WebMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.MultipartConfig;

public class SpittirInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebMVCConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMVCConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 文件上传的相关配置
     * 配置临时路径
     * 文件大小限制
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp/uploads");
        registration.setMultipartConfig(multipartConfigElement);
    }
}
