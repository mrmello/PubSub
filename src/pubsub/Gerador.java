package pubsub;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import threads.EletronicosThread;
import threads.EsportesThread;
import threads.NegociosThread;
import threads.NovidadesInternetThread;
import threads.PoliticaThread;
import threads.ViagensThread;

public class Gerador{
	
	private EsportesThread 			esp;
	private NovidadesInternetThread         nov;
	private EletronicosThread 		ele;
	private PoliticaThread 			pol;
	private NegociosThread 			neg;
	private ViagensThread 			via;
	
	
	public Gerador(){
		esp = new EsportesThread(1, 10000, 1000, 10000, 1000);
		esp.start();
		nov = new NovidadesInternetThread(2, 20000, 2000, 20000, 2000);
		nov.start();
		ele = new EletronicosThread(3, 30000, 3000, 30000, 3000);
		ele.start();
		pol = new PoliticaThread(4, 40000, 4000, 40000, 4000);
		pol.start();
		neg = new NegociosThread(5, 50000, 5000, 50000, 5000);
		neg.start();
		via = new ViagensThread(6, 60000, 6000, 60000, 6000);
		via.start();
	
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
