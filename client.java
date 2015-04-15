//package com.jiawh.net;
import java.net.*;
import java.io.*;

public class client {
    private static final String ip = "127.0.0.1";
    private static final int port = 8090; 

    public static void main(String args[]) {
        try {
            Socket sock = new Socket(ip, port);
            if (sock.isConnected()) {
                System.out.println("sock already connected");
            }
            InputStream in = sock.getInputStream();
            byte[] b = new byte[16];
            in.read(b);
            System.out.println(new String(b));
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}
