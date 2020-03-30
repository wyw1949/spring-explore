package com.yoke.spel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpelConfig.class})
public class SpelTest {

    @Autowired
    private SpelBean spelBean;

    @Test
    public void spelPrint(){
        System.out.println(spelBean.getTime());
        System.out.println(spelBean.getCurrent());
        System.out.println(spelBean.getSum());
        System.out.println(spelBean.getAb());
        System.out.println(spelBean.getName());
        System.out.println(spelBean.getBool());
        System.out.println(spelBean.getExists());
        System.out.println(spelBean.getElvis());
    }
}
