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
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import view.ConsumidorThread;

public class Difusor {

	public static Informacao info =  new Informacao(0, 0, 0);
	public static int seq = 0;
	public static ArrayList <Informacao> queue = new ArrayList<Informacao>();
	public static ServerSocket serverSocket;
	public static Socket s;
        public static DatagramSocket udpserverSocket;

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
                    System.out.println("Connecting...");
			serverSocket = new ServerSocket(1972);
			serverSocket.setSoTimeout(1000);
                        udpserverSocket = new DatagramSocket(9876);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void recebeTCP(){
            try {
                s = serverSocket.accept();
                TCPThread rtt = new TCPThread();
                rtt.start();
            } catch (IOException ex) {
                System.out.println("");
            }
	}
	

	public void recebeUDP(){
		UDPThread rut = new UDPThread();
                rut.start();

	}

}
