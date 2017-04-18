package com.netty.java.bio;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;
    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if(body == null){
                    break;
                }
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString():"Bad order";
                out.println(currentTime );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null) {try {
                in.close();
                in = null;
            } catch (IOException e) {
                e.printStackTrace();
            }}
            if(out != null){
                out.close();
                out = null;
            }
            if(this.socket != null){
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.socket = null;
            }

        }

    }
}
