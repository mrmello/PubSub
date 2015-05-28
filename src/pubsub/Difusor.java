package pubsub;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Difusor {
	private Informacao info = null;
	private int seq = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Difusor dif = new Difusor();
		
		Gerador g1 = new Gerador(2, 10000, 1000, 10000, 1000);
		g1.run();
		Gerador g2 = new Gerador(4, 10000, 1000, 20000, 2000);
		g2.run();
		Gerador g3 = new Gerador(5, 10000, 1000, 30000, 3000);
		g3.run();
		
		//recebe informacao via UDP
		dif.recebeUDP();
		//recebe solicitacao via TCP
		dif.recebeTCP();
		
	}
	
	public void recebeTCP(){
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(1972);
			System.out.println("Waiting...");
			Socket s = serverSocket.accept();
			System.out.println("Connected!");
			InputStream ip = s.getInputStream();
			ObjectInputStream read = new ObjectInputStream(ip);
			int option = (Integer)read.readObject();
			System.out.println(option);
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void recebeUDP(){
		 DatagramSocket serverSocket;
		try {
			serverSocket = new DatagramSocket(9876);
			byte[] receiveData = new byte[1024];
			while(true)             
			{                
				 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);         
				 serverSocket.receive(receivePacket);              
				 String sentence = new String( receivePacket.getData());        
				 System.out.println("RECEIVED: " + sentence);
				 
				 info = info.desempacota(sentence);
				 seq++;
				 info.setSeq(seq);
				 //TODO adicionar info na fila
			 }
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}

}
