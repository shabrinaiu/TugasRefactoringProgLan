/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Asus
 */
public abstract class TCPController {
    protected static final int PORT = 2020;
    
    public abstract void open();
    public abstract void close();
}
