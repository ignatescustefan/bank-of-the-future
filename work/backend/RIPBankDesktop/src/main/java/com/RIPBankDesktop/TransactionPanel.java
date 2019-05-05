package com.RIPBankDesktop;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TransactionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIbanSursa;
	private JTextField txtIbanDestina;
	private JTextField txtSuma;
	public JButton btnAnulare;
	public JButton btnEfectuare;

	/**
	 * Create the panel.
	 */
	public TransactionPanel() {
		setLayout(null);
		setBounds(0, 57, 893, 77);
		btnAnulare = new JButton("Anulare");
		btnEfectuare = new JButton("Efectuare");
		txtIbanSursa = new JTextField();
		txtIbanSursa.setText("IBAN sursa");
		txtIbanSursa.setBounds(195, 11, 86, 20);
		add(txtIbanSursa);
		txtIbanSursa.setColumns(10);
		
		txtIbanDestina = new JTextField();
		txtIbanDestina.setText("IBAN destinatie");
		txtIbanDestina.setColumns(10);
		txtIbanDestina.setBounds(195, 42, 86, 20);
		add(txtIbanDestina);
		
		txtSuma = new JTextField();
		txtSuma.setText("Suma");
		txtSuma.setBounds(440, 11, 86, 20);
		add(txtSuma);
		txtSuma.setColumns(10);
		
		
		btnEfectuare.setBounds(705, 41, 89, 23);
		add(btnEfectuare);
		
		btnAnulare.setBounds(804, 41, 89, 23);
		add(btnAnulare);
		
		JLabel lblIbanSursa = new JLabel("IBAN sursa");
		lblIbanSursa.setBounds(10, 14, 86, 17);
		add(lblIbanSursa);
		
		JLabel lblIbanDestinatie = new JLabel("IBAN destinatie");
		lblIbanDestinatie.setBounds(10, 45, 86, 17);
		add(lblIbanDestinatie);
	}
}
