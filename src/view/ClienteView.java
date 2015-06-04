/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import threads.ConsumidorThread1;
import threads.ConsumidorThread2;
import threads.ConsumidorThread3;

public class ClienteView extends javax.swing.JFrame {
	
	/**
	 * Auto generated serial version
	 */
	private static final long serialVersionUID = -2780378464626420227L;
	public ConsumidorThread1 ct1;
	public ConsumidorThread2 ct2;
	public ConsumidorThread3 ct3;

	public ClienteView() {
		initComponents();
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		btnParar1 = new javax.swing.JButton();
		btnParar2 = new javax.swing.JButton();
		btnParar3 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtaCliente1 = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtaCliente2 = new javax.swing.JTextArea();
		jScrollPane3 = new javax.swing.JScrollPane();
		jtaCliente3 = new javax.swing.JTextArea();
		jcb1 = new javax.swing.JComboBox();
		jcb2 = new javax.swing.JComboBox();
		jcb3 = new javax.swing.JComboBox();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
		jLabel1.setText("Consumidor");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(293, 293, 293)
						.addComponent(jLabel1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 22, Short.MAX_VALUE))
				);

		btnParar1.setText("Parar");
		btnParar1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnParar1ActionPerformed(evt);
			}
		});

		btnParar2.setText("Parar");
		btnParar2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnParar2ActionPerformed(evt);
			}
		});

		btnParar3.setText("Parar");
		btnParar3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnParar3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(68, 68, 68)
						.addComponent(btnParar1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnParar2)
						.addGap(176, 176, 176)
						.addComponent(btnParar3)
						.addGap(88, 88, 88))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnParar1)
								.addComponent(btnParar2)
								.addComponent(btnParar3))
								.addContainerGap(14, Short.MAX_VALUE))
				);

		jtaCliente1.setColumns(20);
		jtaCliente1.setRows(5);
		jScrollPane1.setViewportView(jtaCliente1);

		jtaCliente2.setColumns(20);
		jtaCliente2.setRows(5);
		jScrollPane2.setViewportView(jtaCliente2);

		jtaCliente3.setColumns(20);
		jtaCliente3.setRows(5);
		jScrollPane3.setViewportView(jtaCliente3);

		jcb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um item", "Esportes", "Novidades Internet", "Eletronicos", "Politica", "Negócios ", "Viagens" }));
		jcb1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jcb1ItemStateChanged(evt);
			}
		});
		jcb1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jcb1ActionPerformed(evt);
			}
		});

		jcb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um item", "Esportes", "Novidades Internet", "Eletronicos", "Politica", "Negócios ", "Viagens" }));
		jcb2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jcb12ItemStateChanged(evt);
			}
		});

		jcb3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um item", "Esportes", "Novidades Internet", "Eletronicos", "Politica", "Negócios ", "Viagens" }));
		jcb3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jcb3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
										.addGroup(layout.createSequentialGroup()
												.addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jcb2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(jcb3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(20, 20, 20))))
												.addGroup(layout.createSequentialGroup()
														.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 12, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
										.addComponent(jScrollPane1)
										.addComponent(jScrollPane3))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
				);

		pack();
	}// </editor-fold>                        

	private void jcb1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
		// TODO add your handling code here:
	}                                    

	private void jcb1ItemStateChanged(java.awt.event.ItemEvent evt) {                                      
		if(jcb1.getSelectedIndex() != 0){
			try {
				Socket st1 = new Socket("localhost", 1971);
				st1.setSoTimeout(100000);
				ct1 = new ConsumidorThread1(jcb1.getSelectedIndex(), st1, jtaCliente1);
				ct1.start();
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}                                     

	private void jcb12ItemStateChanged(java.awt.event.ItemEvent evt) {                                       
		if(jcb2.getSelectedIndex() != 0){
			try {
				Socket st2 = new Socket("localhost", 1972);
				st2.setSoTimeout(100000);
				ct2 = new ConsumidorThread2(jcb2.getSelectedIndex(), st2, jtaCliente2);
				ct2.start();
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}                                      

	private void jcb3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
		if(jcb3.getSelectedIndex() != 0){
			try {
				Socket st3 = new Socket("localhost", 1973);
				st3.setSoTimeout(100000);
				ct3 = new ConsumidorThread3(jcb3.getSelectedIndex(), st3, jtaCliente3);
				ct3.start();
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}                                    


	private void btnParar1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
		try {
			ct1.interrupt();
			ct1.join(10);
			System.out.println("parou 1");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void btnParar2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
		try {
			ct2.interrupt();
			ct2.join(10);
			System.out.println("parou 2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	private void btnParar3ActionPerformed(java.awt.event.ActionEvent evt) {                                          
		try {
			ct3.interrupt();
			ct3.join(10);
			System.out.println("parou 3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ClienteView().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton btnParar1;
	private javax.swing.JButton btnParar2;
	private javax.swing.JButton btnParar3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jcb1;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jcb2;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jcb3;
	private javax.swing.JTextArea jtaCliente1;
	private javax.swing.JTextArea jtaCliente2;
	private javax.swing.JTextArea jtaCliente3;
	// End of variables declaration                   
}
