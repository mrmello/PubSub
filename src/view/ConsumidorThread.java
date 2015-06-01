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

/**
 *
 * @author dionatan
 */
public class ConsumidorThread extends Thread{
    private String host;
    private Integer porta;
    String msg;

    public ConsumidorThread(String host, Integer porta, String msg) {
        this.host = host;
        this.porta = porta;
        this.msg = msg;
    }
 
    public void connectar(){
        try {
            System.out.println("entrou function");

            Socket s = new Socket(host, porta);
            System.out.println("tentou chamar server");
            ObjectInputStream in  = new ObjectInputStream(s.getInputStream());
            System.out.println("conectou");
            msg = (String)in.readObject();
            System.out.println("Buscando informacao "+msg);  
            
            ObjectOutputStream esc = new ObjectOutputStream(s.getOutputStream());
            String res = msg;
            esc.writeObject(res);
        } catch (IOException ex) {
            Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    public void run() {
       //To change body of generated methods, choose Tools | Templates.
        connectar();
        
    }
    
    
}
