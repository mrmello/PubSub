package threads;

import static pubsub.Difusor.queue;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;

import pubsub.Difusor;

public class UDPThread extends Thread{

    public UDPThread(){
        
    }
    @Override
	public void run(){
		try {
			
			byte[] receiveData = new byte[1024];
			while(true)             
			{                
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);         
				Difusor.udpserverSocket.receive(receivePacket);              
				String sentence = new String( receivePacket.getData());        
				Difusor.info = Difusor.info.desempacota(sentence);
				Difusor.seq++;
				Difusor.info.setSeq(Difusor.seq);
				queue.add(Difusor.info);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        }

}
