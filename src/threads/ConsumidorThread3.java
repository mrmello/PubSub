
package threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import view.ClienteView;

public class ConsumidorThread3 extends Thread{

	public int option;
	public Socket st;
	public javax.swing.JTextArea jtaCliente3;

	public ConsumidorThread3(int option, Socket st, javax.swing.JTextArea jtaCliente3) {
		this.option = option;
		this.st = st;
		this.jtaCliente3 = jtaCliente3;
	}

	public void run() {
		try {
			ObjectOutputStream esc = new ObjectOutputStream(st.getOutputStream());
			esc.writeObject(option);
			while(!ClienteView.parar3){
				ObjectInputStream read = new ObjectInputStream(st.getInputStream());
				String info = (String)read.readObject();
				jtaCliente3.setText(info);
				yield();
			}
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	}    
}
