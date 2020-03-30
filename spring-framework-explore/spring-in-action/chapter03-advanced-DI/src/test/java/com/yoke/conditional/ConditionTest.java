package com.yoke.conditional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConditionalConfig.class})
public class ConditionTest {

    @Autowired(required = false)
    private MagicBean magicBean;

    @Test
    public void magicBeanExists(){
        System.out.println(magicBean);
    }
}
