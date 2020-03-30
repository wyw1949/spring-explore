package com.yoke.auto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CDPlayerConfig.class)
@ContextConfiguration(locations = {"classpath:cdPlayer.xml"})
public class CDPlayerTest {

    /**
     * spring支持JSR330规范的实现，可以使用{@link javax.inject.Named}代替{@link org.springframework.stereotype.Component}、
     * 使用{@link Inject}代替{@link Autowired}
     *
     */
    @Inject
    private CompactDisc compactDisc;

    /**
     * {@link Autowired} 可以用在构造器、setter方法或任意方法上来完成依赖的描述。
     */
    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void cdShouldNotBeNull(){
        Assert.assertNotNull(compactDisc);
    }

    @Test
    public void cdPlay(){
        cdPlayer.play();
    }
}
