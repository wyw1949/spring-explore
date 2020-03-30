package com.yoke.ambiguity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmbiguityConfig.class)
public class AmbiguityTest {

    //指定要装配bean的name
//    @Qualifier("dog")
    @Autowired(required = false)
    private Animal animal;

    @Test
    public void animal(){
        System.out.println(animal);
    }
}
