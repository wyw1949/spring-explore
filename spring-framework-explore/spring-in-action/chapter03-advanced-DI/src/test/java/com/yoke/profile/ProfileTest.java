package com.yoke.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProdProfileConfig.class})
// 集成测试环境激活profile
@ActiveProfiles("qa")
public class ProfileTest {

    @Autowired(required = false)
    private EnvironmentInterface environment;

    @Test
    public void showEnvironment(){
        if (environment != null)
            System.out.println(environment.getClass().getName());
        else
            System.out.println("environment 为 null");
        
    }
}
