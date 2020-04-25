package com.yoke.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Properties;

/**
 * 自定义一个系统属性条件装配实现，实现{@link Condition}
 */
public class OnSystemPropertiesCondition implements Condition {

    /**
     * 条件判断的逻辑在该方法中实现。根据方法中定义的条件逻辑装配相应的bean
     * @param conditionContext 条件上下文
     * @param annotatedTypeMetadata 注解元信息
     * @return 是否装配
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 根据注解名称获取注解信息
        Map<String, Object> attributes = annotatedTypeMetadata.getAnnotationAttributes(ConditionalOnSystemProperties.class.getName());
        Properties systemProperties = System.getProperties();

        String conditionAttributeName = String.valueOf(attributes.get("name"));
        String conditionAttributeValue = String.valueOf(attributes.get("value"));

        String systemAttributeValue = systemProperties.getProperty(conditionAttributeName);
        return systemAttributeValue.equals(conditionAttributeValue);
    }
}
