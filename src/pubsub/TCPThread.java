package pubsub;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import static pubsub.Difusor.queue;
import static pubsub.Difusor.s;
import pubsub.Informacao;
import static pubsub.Difusor.serverSocket;

public class TCPThread extends Thread{

	public TCPThread(){

	}

	public void run(){
		try {
                    while(true){
			ObjectInputStream read = new ObjectInputStream(s.getInputStream());
			int option = (Integer)read.readObject();
			ObjectOutputStream esc = new ObjectOutputStream(s.getOutputStream());
                        String info = "";
                           for(Informacao i: queue){
                               
                               if(i.getTipo() == option){
                                info+= i.getValor();
                                info+="\n";
                               }
                           }
                        esc.writeObject(info);      
                    }
		} catch (IOException e) {
			System.out.println("TCP timeout");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
