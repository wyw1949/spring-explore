package com.yoke.scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ScopeConfig.class})
public class ScopeTest {

    @Autowired
    private ShowPrototype1 showPrototype1;

    @Autowired
    private ShowSingleton1 showSingleton1;

    @Autowired
    private LookUpDIPrototype lookUpDIPrototype;

    @Test
    public void showBean(){
        System.out.println(showPrototype1.getPrototypeBean());
        System.out.println(showPrototype1.getPrototypeBean());
        System.out.println(lookUpDIPrototype.getPrototypeBean());
        System.out.println(lookUpDIPrototype.getPrototypeBean());
        System.out.println(showSingleton1.getSingletonBean());
        System.out.println(showSingleton1.getSingletonBean());
    }
}
