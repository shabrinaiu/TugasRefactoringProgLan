package controller;

import java.io.*;
import java.net.*;
import model.EnemyStatus;

public abstract class TCPController extends Thread{
    protected static final int PORT = 2020;
    protected Socket socket;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutput;
    private InputStream inputStream;
    private ObjectInputStream objectInput;
    
    public abstract void open();
    public abstract void close();
    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public void sendMessage(EnemyStatus message){
        try {
            outputStream = socket.getOutputStream();
            objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(message);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public EnemyStatus receiveMessage() throws ClassNotFoundException{
        try {
            inputStream = socket.getInputStream();
            objectInput = new ObjectInputStream(inputStream);
            EnemyStatus message = (EnemyStatus) objectInput.readObject();
            return message;
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
