package com.yoke.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul大部分功能都是通过过滤器来实现的，这些过滤器类型对应于请求的典型生命周期。
 *
 *  pre： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录
 *  调试信息等。
 *  routing：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient
 *  或Netfilx Ribbon请求微服务。
 *  post：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指
 *  标、将响应从微服务发送给客户端等。
 *  error：在其他阶段发生错误时执行该过滤器。 除了默认的过滤器类型，Zuul还允许我们创建自定义的过滤器类型。
 *  例如，我们可以定制一种STATIC类型的过滤器，直接在Zuul中生成响应，而不将请求转发到后端的微服务。
 *
 * zuul自定义的filter(此filter并不是servlet中的filter，而是zuul定义的filter规范)
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *  类型	    顺序	       过滤器	                功能
 * pre	        -3	    ServletDetectionFilter	    标记处理Servlet的类型
 * pre	        -2	    Servlet30WrapperFilter	    包装HttpServletRequest请求
 * pre	        -1	    FormBodyWrapperFilter	    包装请求体
 * route	     1	    DebugFilter	                标记调试标志
 * route	     5	    PreDecorationFilter	        处理请求上下文供后续使用
 * route	    10	    RibbonRoutingFilter	        serviceId请求转发
 * route	    100	    SimpleHostRoutingFilter	    url请求转发
 * route	    500	    SendForwardFilter	        forward请求转发
 * post	        0	    SendErrorFilter	            处理有错误的请求响应
 * post	        1000	SendResponseFilter	        处理正常的请求响应
 *
 * 若要禁用filter可做如下配置
 * zuul.FormBodyWrapperFilter.pre.disable=true   禁用FormBodyWrapperFilter
 *
 * 实现{@see ZuulFilter} 来制定filter
 */
@Component
public class TokenFilter extends ZuulFilter {
    // 制定filter的类型 pre, routing, post, error
    @Override
    public String filterType() {
        return "pre";
    }

    // 指定filter的执行顺序，值越小越先执行
    @Override
    public int filterOrder() {
        return 10;
    }

    // 是否启用该filter
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if (token != null && !"".equals(token.trim())){
            // 下发请求
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            currentContext.set("isSucceed", true);
        }else {
            // 不下发请求
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(400);
            currentContext.setResponseBody("token is empty!");
            currentContext.set("isSucceed", false);
        }
        return null;
    }
}
