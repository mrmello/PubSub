/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.ClienteView.s;

/**
 *
 * @author dionatan
 */
public class ConsumidorThread extends Thread{
    
    public ConsumidorThread() {

    }
   
    public void run() {
       try {
            ObjectInputStream read = new ObjectInputStream(s.getInputStream());
            int info = (Integer)read.readObject();
            System.out.println(info);
            } catch (IOException ex) {
                   System.out.println("consumidor time out");
            } catch (ClassNotFoundException ex) {  
            Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
