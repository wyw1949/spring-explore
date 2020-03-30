package com.yoke.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

/**
 * 指定proxyMode为TARGET_CLASS或INTERFACES即可再注入到单例bean中时，正确注入相应非单例作用域的Bean
 * 也可以通过@Lookup来实现
 */
@Component
@Scope(scopeName = SCOPE_PROTOTYPE/*, proxyMode = TARGET_CLASS*/)
public class PrototypeBean {
}
