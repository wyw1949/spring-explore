package com.yoke.normal;

import org.springframework.stereotype.Component;

@Component
public class MusicPerformance implements Performance {
    public void perform(String title, int num) {
        System.out.println("进行音乐表演: " + title + ", " + num);
    }
}
