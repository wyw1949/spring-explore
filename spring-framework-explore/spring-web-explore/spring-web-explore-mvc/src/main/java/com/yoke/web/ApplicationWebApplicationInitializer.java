package com.yoke.web;

import com.yoke.config.AppMVCConfig;
import com.yoke.config.ApplicationConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 取代web.xml配置
 *
 */
public class ApplicationWebApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        /*
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ApplicationConfig.class);
        // 如果使用@EnableWebMvc，那么其所引入的WebMvcConfigurationSupport配置类要从应用上下文中获取ServletContext，其中的resourceHandlerMapping()和defaultServletHandlerMapping()中校验servletContext
        // 将ServletContext上下文放入应用上下文，如果不加此行代码，将导致报错
        ctx.setServletContext(servletContext);
        ctx.refresh();

        DispatcherServlet servlet = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        //1. load-on-startup 元素标记容器是否应该在web应用程序启动的时候就加载这个servlet，(实例化并调用其init()方法)。
        //2. 它的值必须是一个整数，表示servlet被加载的先后顺序。
        //3. 如果该元素的值为负数或者没有设置，则容器会当Servlet被请求时再加载。
        //4. 如果值为正整数或者0时，表示容器在应用启动时就加载并初始化这个servlet，值越小，servlet的优先级越高，就越先被加载。值相同时，容器就会自己选择顺序来加载。
        registration.setLoadOnStartup(1);
        // servlet要拦截的路由规则，"/"拦截所有
        registration.addMapping("/");
        */

        /*
        下面配置等价于如下的web.xml
        配置监听器ContextLoaderListener,由监听器ContextLoaderListener初始化应用上下文
            配置监听器ContextLoaderListener是ServletContextListener类型，它将监听ServletContextEvent，监听ServletContext的生命周期，
            其中的初始化方法contextInitialized在Web容器初始化时执行,方法体如下，即在启动web容器时初始化应用上下文，并将ServletContext
            存入应用上下文
            @Override
            public void contextInitialized(ServletContextEvent event) {
                initWebApplicationContext(event.getServletContext());
            }
        */
        // 配置初始化参数
        servletContext.setInitParameter(ContextLoaderListener.CONTEXT_CLASS_PARAM, AnnotationConfigWebApplicationContext.class.getName());
        servletContext.setInitParameter(ContextLoaderListener.CONFIG_LOCATION_PARAM, ApplicationConfig.class.getName());
        // 配置监听器
        servletContext.addListener(ContextLoaderListener.class);

        // 配置DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet();
        // 指定spring应用上下文类型（不指定默认为XmlWebApplicationContext，即要提供一个app-servlet.xml）
        // servlet.setContextClass(AnnotationConfigWebApplicationContext.class);
        // 指定MVC配置文件或配置类
        // 1. 如果应用上下文类型为AnnotationConfigWebApplicationContext，此处配置配置类名称，多个使用“,”分割
        // 2. 如果应用上下文类型为XmlWebApplicationContext，此处指定xml文件，多个使用“，”分割，如果配置文件为app-servlet.xml(app为配置DispatcherServlet指定的名称，如下为app)格式的，则可省略此配置
        // servlet.setContextConfigLocation(AppMVCConfig.class.getName());
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        // 指定spring应用上下文类型（不指定默认为XmlWebApplicationContext，即要提供一个app-servlet.xml）
        registration.setInitParameter(ContextLoaderListener.CONTEXT_CLASS_PARAM, AnnotationConfigWebApplicationContext.class.getName());
        // 指定MVC配置文件或配置类
        // 1. 如果应用上下文类型为AnnotationConfigWebApplicationContext，此处配置配置类名称，多个使用“,”分割
        // 2. 如果应用上下文类型为XmlWebApplicationContext，此处指定xml文件，多个使用“，”分割，如果配置文件为app-servlet.xml(app为配置DispatcherServlet指定的名称，如下为app)格式的，则可省略此配置
        registration.setInitParameter(ContextLoaderListener.CONFIG_LOCATION_PARAM, AppMVCConfig.class.getName());
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        /*
            <listener>
                <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
            </listener>
            <context-param>
                <param-name>contextClass</param-name>
                <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
            </context-param>

            <context-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>com.yoke.config.ApplicationConfig</param-value>
            </context-param>

            <servlet>
                <servlet-name>app</servlet-name>
                <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                <init-param>
                    <param-name>contextClass</param-name>
                    <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
                </init-param>
                <init-param>
                    <param-name>contextConfigLocation</param-name>
                    <param-value>com.yoke.config.AppMVCConfig</param-value>
                </init-param>
                <load-on-startup>1</load-on-startup>
            </servlet>
            <servlet-mapping>
                <servlet-name>app</servlet-name>
                <url-pattern>/</url-pattern>
            </servlet-mapping>
         */
    }
}
