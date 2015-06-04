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

public class ConsumidorThread2 extends Thread{

	public int option;
	public Socket st;
	public javax.swing.JTextArea jtaCliente2;

	public ConsumidorThread2(int option, Socket st, javax.swing.JTextArea jtaCliente2) {
		this.option = option;
		this.st = st;
		this.jtaCliente2 = jtaCliente2;
	}

	public void run() {
		try {
			ObjectOutputStream esc = new ObjectOutputStream(st.getOutputStream());
			esc.writeObject(option);
			while(!Thread.currentThread().isInterrupted()){
				ObjectInputStream read = new ObjectInputStream(st.getInputStream());
				String info = (String)read.readObject();
				jtaCliente2.setText(info);
				yield();
				if(Thread.currentThread().isInterrupted()){
					System.out.println("interrupt thread 2");
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			 
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}    
}
