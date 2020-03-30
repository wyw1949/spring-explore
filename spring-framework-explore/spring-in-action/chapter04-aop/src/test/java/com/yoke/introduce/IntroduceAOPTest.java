package com.yoke.introduce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IntroduceAOPConfig.class})
public class IntroduceAOPTest {

    @Autowired
    private Encoreable encoreable;

    @Test
    public void introduceTest(){
        encoreable.introduce();

        Class<?>[] superClasses = encoreable.getClass().getInterfaces();
        Arrays.asList(superClasses).forEach(System.out::println);
        /*
        interface com.yoke.introduce.Performance
        interface com.yoke.introduce.Encoreable
        interface org.springframework.aop.SpringProxy
        interface org.springframework.aop.framework.Advised
        interface org.springframework.core.DecoratingProxy
         */
    }
}
