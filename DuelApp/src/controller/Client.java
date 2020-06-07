/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.net.*;
import model.Message;

/**
 *
 * @author Asus
 */
public class Client extends TCPController{
    private String serverName;
    private Socket socket;
    private InputStream inputStream;
    private ObjectInputStream objectInput;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutput;

    public Client() {
        serverName = "localhost";
    }

    @Override
    public void open() {
        try {
            socket = new Socket(serverName, PORT);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void sendMessage(Message message){
        try {
            outputStream = socket.getOutputStream();
            objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(message);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    public Message receiveMessage() throws ClassNotFoundException{
        try {
            inputStream = socket.getInputStream();
            objectInput = new ObjectInputStream(inputStream);
            Message message = (Message) objectInput.readObject();
            return message;
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
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
