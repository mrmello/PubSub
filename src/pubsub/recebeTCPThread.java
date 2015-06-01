package pubsub;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class recebeTCPThread extends Thread{

	public recebeTCPThread(){

	}

	public void run(){
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(1972);
			serverSocket.setSoTimeout(1000);
				Socket s = serverSocket.accept();
				System.out.println("Connected!");
				InputStream ip = s.getInputStream();
				ObjectInputStream read = new ObjectInputStream(ip);
				int option = (Integer) read.readObject();
				System.out.println(option);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
