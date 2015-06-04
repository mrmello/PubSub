package threads;

import static pubsub.Difusor.queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import pubsub.Informacao;

public class TCPThread3 extends Thread{

	ServerSocket sst3;
	
	public TCPThread3(){
	}

	public void run(){
		try {
			System.out.println("Connecting... 3");
			sst3 = new ServerSocket(1973);
			sst3.setSoTimeout(20000);
			Socket s3 = sst3.accept();
			ObjectInputStream read = new ObjectInputStream(s3.getInputStream());
			int option = (Integer)read.readObject();
			
			while(!sst3.isClosed()){
				send(option, s3);
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
	
	public void send(int option, Socket s3){
		String info = "";
		for(Informacao i: queue){     
			if(i.getTipo() == option){
				info+= "Valor: "+i.getValor()+" tipo: "+i.getTipo();
				info+="\n";
			}
		}
		try {
			ObjectOutputStream esc = new ObjectOutputStream(s3.getOutputStream());
			esc.writeObject(info);
		} catch (IOException ex) {
			try {
				sst3.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

}
