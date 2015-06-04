package pubsub;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import threads.TCPThread1;
import threads.TCPThread2;
import threads.TCPThread3;
import threads.UDPThread;

public class Difusor {

	public static Informacao 				info =  new Informacao(0, 0, 0);
	public static int						seq = 0;
	public static ArrayList <Informacao> 	queue = new ArrayList<Informacao>();
	public static DatagramSocket 			udpserverSocket;

	public static void main(String[] args) {

		Difusor dif = new Difusor();

		Gerador g1 = new Gerador();
		g1.initializeThreads();
		Gerador g2 = new Gerador();
		g2.initializeThreads();
		Gerador g3 = new Gerador();
		g3.initializeThreads();
		
		try {
			udpserverSocket = new DatagramSocket(9876);
		} catch (SocketException e) {
			e.printStackTrace();
		}

		dif.recebeUDP();
		dif.recebeTCP();

	}

	public void recebeTCP(){
		TCPThread1 t1 = new TCPThread1();
		t1.start();
		TCPThread2 t2 = new TCPThread2();
		t2.start();
		TCPThread3 t3 = new TCPThread3();
		t3.start();
	}

	public void recebeUDP(){
		UDPThread rut = new UDPThread();
		rut.start();
	}
}
