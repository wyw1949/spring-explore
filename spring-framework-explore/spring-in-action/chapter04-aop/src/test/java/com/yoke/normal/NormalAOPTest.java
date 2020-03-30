package com.yoke.normal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NormalAOPConfig.class})
public class NormalAOPTest {

    @Autowired
    @Qualifier("musicPerformance")
    private Performance performance;

    @Test
    public void performanceTest(){
        performance.perform("肖邦", 1);
    }

}
