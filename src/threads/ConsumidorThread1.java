/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConsumidorThread1 extends Thread{

	public int option;
	public Socket st;
	public javax.swing.JTextArea jtaCliente1;

	public ConsumidorThread1(int option, Socket st, javax.swing.JTextArea jtaCliente1) {
		this.option = option;
		this.st = st;
		this.jtaCliente1 = jtaCliente1;
	}

	public void run() {
		try {
			ObjectOutputStream esc = new ObjectOutputStream(st.getOutputStream());
			esc.writeObject(option);
			while(!ConsumidorThread1.currentThread().isInterrupted()){
				ObjectInputStream read = new ObjectInputStream(st.getInputStream());
				String info = (String)read.readObject();
				jtaCliente1.setText(info);
				yield();
			}
			ConsumidorThread1.currentThread().interrupt();
			Thread.currentThread().interrupt();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
}
