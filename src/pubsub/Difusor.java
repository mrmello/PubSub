package pubsub;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.Queue;

public class Difusor {
	
	private Informacao info =  new Informacao(0, 0, 0);
	private int seq = 0;
	private Queue<Informacao> queue = new LinkedList<Informacao>();

	public static void main(String[] args) {

		Difusor dif = new Difusor();
		
		Gerador g1 = new Gerador();
		Gerador g2 = new Gerador();
		Gerador g3 = new Gerador();
		
		while(true){
			//recebe informacao via UDP
			dif.recebeUDP();
			//recebe solicitacao via TCP
			dif.recebeTCP();
		}
		
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
				 info = info.desempacota(sentence);
				 seq++;
				 info.setSeq(seq);
				 System.out.println("Seq:"+seq+" InfoSeq: "+info.getSeq() + " InfoTipo: " +info.getTipo()+ " InfoValor: "+ info.getValor());
				 queue.add(info);
				 
			 }
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}

}
