package com.hieulv.signalingserver.server;


import com.hieulv.signalingserver.model.UserModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServerThread implements Runnable {
    private UserModel user;
    private ServerThreadCallBack callBack;

    public ServerThread(UserModel user, ServerThreadCallBack callBack) {
        this.user = user;
        this.callBack = callBack;
    }

    public void run() {
        try {
            InputStream input = user.getSocket().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String text;
            while ((text = reader.readLine()) != null) {
                if (callBack != null) {
                    callBack.clientSendCommand(user, text);
                }
            }
            if (callBack != null) {
                callBack.clientDisconnected(user);
            }
        } catch (IOException ex) {
//            System.out.println("ServerThread: " + ex.getMessage());
            if (callBack != null) {
                callBack.clientDisconnected(user);
            }
        }
    }

    interface ServerThreadCallBack {
        void clientSendCommand(UserModel user, String message);
        void clientDisconnected(UserModel userModel);
    }
}