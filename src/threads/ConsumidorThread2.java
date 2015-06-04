
package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import view.ClienteView;

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
			while(!ClienteView.parar2){
				ObjectInputStream read = new ObjectInputStream(st.getInputStream());
				String info = (String)read.readObject();
				jtaCliente2.setText(info);
				yield();
			}
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	}    
}
