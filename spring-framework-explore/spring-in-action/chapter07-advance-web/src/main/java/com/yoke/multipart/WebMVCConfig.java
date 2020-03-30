package com.yoke.multipart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {"com.yoke.multipart"})
@EnableWebMvc
public class WebMVCConfig extends WebMvcConfigurerAdapter {

    /**
     * 上传文件解析器配置
     * servlet3.0 && spring3.1
     */
    @Bean
    public MultipartResolver multipartResolver(){
        // 不能做额外的指定，如文件大小限制，临时文件等，这些要在servlet中指定，
        // 如通过初始化类的customizeRegistration方法
        return new StandardServletMultipartResolver();
    }

    /*如果我们需要将应用部署到非Servlet 3.0的容器中，那么就得需要使用Spring内置的
    CommonsMultipartResolver，可以作为StandardServletMultipartResolver的替代方
    案。与StandardServletMultipartResolver有所不同，CommonsMultipart-Resolver
    不会强制要求设置临时文件路径。默认情况下，这个路径就是Servlet容器的临时目录。不
    过，通过设置uploadTempDir属性，我们可以将其指定为一个不同的位置，还可以指定上传
    文件的大小范围等，但无法设定multipart请求整体的最大容量*/
    /*@Bean
    public MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/uploads"));
        return multipartResolver;
    }*/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
}
