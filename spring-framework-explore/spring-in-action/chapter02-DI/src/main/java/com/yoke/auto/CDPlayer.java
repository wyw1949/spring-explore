package com.yoke.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
//    setter注入，能够处理bean的循环依赖
//    @Autowired
    private CompactDisc compactDisc;

    public CDPlayer(){}

    // 构造器注入，无法处理bean的循环依赖
    @Autowired
    public CDPlayer(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    public void play(){
        compactDisc.play();
    }
}
