package com.yoke.introduce;

import org.springframework.stereotype.Component;

@Component
public class MusicPerformance implements Performance {
    public void perform() {
        System.out.println("进行音乐表演");
    }
}
