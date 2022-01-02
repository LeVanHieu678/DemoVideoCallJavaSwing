package com.hieulv.signalingserver;

import com.hieulv.signalingserver.server.SignalingServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new SignalingServer().startServer();
    }
}
