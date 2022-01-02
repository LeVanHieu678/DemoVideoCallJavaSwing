package com.hieulv.turnserver;

import com.hieulv.turnserver.server.TurnServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new TurnServer().startServer();
    }
}
