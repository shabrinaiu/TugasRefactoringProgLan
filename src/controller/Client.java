package controller;

import java.io.*;
import java.net.*;

public class Client extends TCPController{

    private final String serverName;

    public Client() {
        serverName = "localhost";
    }

    @Override
    public void open() {
        try {
            super.setSocket(new Socket(serverName, PORT));
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            socket.close();
            System.out.println("Client closed");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
}
