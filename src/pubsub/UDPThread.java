package pubsub;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import static pubsub.Difusor.queue;

public class UDPThread extends Thread{

    public UDPThread(){
        
    }
    @Override
	public void run(){
		try {
			
			byte[] receiveData = new byte[1024];
			int count = 0;
			while(count < 5)             
			{                
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);         
				Difusor.udpserverSocket.receive(receivePacket);              
				String sentence = new String( receivePacket.getData());        
				Difusor.info = Difusor.info.desempacota(sentence);
				Difusor.seq++;
				Difusor.info.setSeq(Difusor.seq);
				queue.add(Difusor.info);
				count++;
			}
			count=0;
			Difusor.udpserverSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        }

}
