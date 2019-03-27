package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Intro
 * @Author liutengfei
 * @Date 2019-03-27 9:53
 */
public class BioServer {
    private static final int PORT = 8088;
    public static void main(String[] args){
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);

            System.out.println("the time server is start in port :" + PORT);
            Socket socket = null;
            while (true){
                try {
                    socket = serverSocket.accept();
                    new Thread(new TimeServerHander(socket)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
