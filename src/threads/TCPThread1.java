package threads;

import static pubsub.Difusor.queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import pubsub.Informacao;

public class TCPThread1 extends Thread{
	ServerSocket sst1;

	public TCPThread1(){
	}

	public void run(){
		try {
			System.out.println("Connecting... 1");
			sst1 = new ServerSocket(1971);
			sst1.setSoTimeout(20000);
			Socket s1 = sst1.accept();
			ObjectInputStream read = new ObjectInputStream(s1.getInputStream());
			int option = (Integer)read.readObject();
			
			while(!sst1.isClosed()){
				send(option, s1);
				sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(int option, Socket s1){
		String info = "";
		for(Informacao i: queue){     
			if(i.getTipo() == option){
				info+= "Valor: "+i.getValor()+" tipo: "+i.getTipo();
				info+="\n";
			}
		}
		try {
			ObjectOutputStream esc = new ObjectOutputStream(s1.getOutputStream());
			esc.writeObject(info);
		} catch (IOException ex) {
			try {
				sst1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

}
