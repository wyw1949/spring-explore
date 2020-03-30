package com.yoke.ambiguity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * {@link Primary} 标识Bean上，与{@link Component}或{@link org.springframework.context.annotation.Bean}连用
 */
@Primary
@Component
public class Cat implements Animal {
}
