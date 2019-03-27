package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Intro
 * @Author liutengfei
 * @Date 2019-03-27 11:18
 */
public class BioClient {
    private static final int PORT = 8088;
    private static  final String HOST = "127.0.0.1";
    public static void main(String[] args){
        Socket socket = null;
        BufferedReader in =null;
        PrintWriter out = null;

        try {
            socket = new Socket(HOST,PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("i an client");
            String resp = in.readLine();
            System.out.println("now time is " + resp);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null){
                out.close();
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
