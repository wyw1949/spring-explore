package com.yoke.auto;

import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("sgtPeppers")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artists = "The Beatles";
    public void play() {
        System.out.println("Playing " + title + "By " + artists);
    }

}
