package com.hieulv.videocallpc;

import com.hieulv.videocallpc.view.HomeUI;

import javax.sound.sampled.SourceDataLine;

public class Main {
    static SourceDataLine sourceDataLine;
    public static void main(String[] args) {
        HomeUI homeUI = new HomeUI();
        homeUI.setVisible(true);

    }


}

class Main2{
    public static void main(String[] args) {
        HomeUI homeUI = new HomeUI();
        homeUI.setVisible(true);
    }
}
