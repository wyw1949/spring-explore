package com.yoke.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(MagicExistsCondition.class)
public class MagicBean {
}
