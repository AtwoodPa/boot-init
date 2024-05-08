package com.pp.boot.common.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义条件注解
 *
 * @author supanpan
 * @create 2024/05/08 16:59
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return context.getResourceLoader().getResource("classpath:application.yml").exists();
    }
}
