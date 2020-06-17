package controller;

import java.io.*;
import java.net.*;

public class Server extends TCPController{
    private ServerSocket serverSocket;

    @Override
    public void open() {
        try {
            serverSocket = new ServerSocket(PORT);
            super.setSocket(serverSocket.accept());
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            socket.close();
            serverSocket.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    
}
