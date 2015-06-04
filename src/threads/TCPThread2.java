package threads;

import static pubsub.Difusor.queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import pubsub.Informacao;

public class TCPThread2 extends Thread{

	ServerSocket sst2;

	public TCPThread2(){
	}

	public void run(){
		try {
			System.out.println("Connecting... 2");
			sst2 = new ServerSocket(1972);
			sst2.setSoTimeout(20000);
			Socket s2 = sst2.accept();
			ObjectInputStream read = new ObjectInputStream(s2.getInputStream());
			int option = (Integer)read.readObject();

			while(!sst2.isClosed()){
				send(option, s2);
				sleep(2000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void send(int option, Socket s2){
		String info = "";
		for(Informacao i: queue){     
			if(i.getTipo() == option){
				info+= "Valor: "+i.getValor()+" tipo: "+i.getTipo();
				info+="\n";
			}
		}
		try {
			ObjectOutputStream esc = new ObjectOutputStream(s2.getOutputStream());
			esc.writeObject(info);
		} catch (IOException ex) {
			try {
				sst2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

}
