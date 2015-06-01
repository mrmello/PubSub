package threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

import pubsub.Informacao;

public class InfoThread extends Thread{

	private int tipo;
	private int vMax;
	private int vMin;
	private int tMax;
	private int tMin;

	public InfoThread(int tipo, int vMax, int vMin, int tMax, int tMin) {
		this.tipo = tipo;
		this.vMax = vMax;
		this.vMin = vMin;
		this.tMax = tMax;
		this.tMin = tMin;
	}

	public void run(){
		while(true){
			Random rand = new Random();
			int dorme = rand.nextInt(tMax) + tMin;
			int valor = rand.nextInt(vMax) + vMin;
			try {
				sleep(dorme);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Informacao info = new Informacao(0, tipo, valor);
			String msg = info.empacota();
			sendInfo(msg);
		}
	}
	public void sendInfo(String msg){
		DatagramSocket clientSocket;
		try {
			clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];       
			sendData = msg.getBytes();       
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
