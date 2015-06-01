package pubsub;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import view.ConsumidorThread;

public class Difusor {

	private Informacao info =  new Informacao(0, 0, 0);
	private int seq = 0;
	private Queue<Informacao> queue = new LinkedList<Informacao>();
	public static ServerSocket serverSocket;
	public static Socket s;

	public static void main(String[] args) {

		Difusor dif = new Difusor();

		Gerador g1 = new Gerador();
		Gerador g2 = new Gerador();
		Gerador g3 = new Gerador();
		dif.connections();
		while(true){
			//recebe informacao via UDP
			dif.recebeUDP();
			//recebe solicitacao via TCP
			dif.recebeTCP();
		}

	}
	
	public void connections(){
		try {
			serverSocket = new ServerSocket(1972);
			serverSocket.setSoTimeout(1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void recebeTCP(){
		System.out.println("TCP Waiting...");
		try {
			s = serverSocket.accept();
			System.out.println("Connected!");
			InputStream ip = s.getInputStream();
			ObjectInputStream read = new ObjectInputStream(ip);
			int option = (Integer)read.readObject();
			enviaTCP("teste");
		} catch (IOException e) {
			System.out.println("TCP timeout");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void enviaTCP(String obj){
		try {
			s.setSoTimeout(10000);
			ObjectOutputStream esc = new ObjectOutputStream(s.getOutputStream());
			esc.writeObject(obj);
		} catch (IOException ex) {
			Logger.getLogger(ConsumidorThread.class.getName()).log(Level.SEVERE, null, ex);
		}  
	}

	public void recebeUDP(){
		DatagramSocket serverSocket;
		try {
			serverSocket = new DatagramSocket(9876);
			byte[] receiveData = new byte[1024];
			int count = 0;
			while(count < 5)             
			{                
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);         
				serverSocket.receive(receivePacket);              
				String sentence = new String( receivePacket.getData());        
				info = info.desempacota(sentence);
				seq++;
				info.setSeq(seq);
				System.out.println("Seq:"+seq+" InfoSeq: "+info.getSeq() + " InfoTipo: " +info.getTipo()+ " InfoValor: "+ info.getValor());
				queue.add(info);
				count++;
			}
			count=0;
			serverSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
