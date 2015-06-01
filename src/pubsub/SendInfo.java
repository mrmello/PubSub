/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubsub;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pubsub.Difusor.queue;
import static pubsub.Difusor.s;

/**
 *
 * @author Marcos
 */
public class SendInfo extends Thread{
    private int option;
    
    public SendInfo(int option){
        this.option = option;
    }
    
    public void run(){
        while(true){
        String info = "";
        for(Informacao i: queue){     
            if(i.getTipo() == option){
                info+= i.getValor();
                info+="\n";
            }
        }
        try {
            ObjectOutputStream esc = new ObjectOutputStream(s.getOutputStream());
            esc.writeObject(info); 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
    }
}
