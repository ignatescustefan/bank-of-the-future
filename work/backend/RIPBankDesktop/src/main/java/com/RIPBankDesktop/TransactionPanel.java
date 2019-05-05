package com.RIPBankDesktop;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import DTO.TransactionDTO;
import proiect.SendTransaction;
import proiect.TipTranzactie;

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
	public String operator;

	/**
	 * Create the panel.
	 */
	public TransactionPanel() {
		setLayout(null);
		setBounds(0, 57, 893, 77);
		operator="nuLL";
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
	public void executeTransaction() {
		TransactionDTO transaction=new TransactionDTO();
		transaction.setOperatorTranzactie(operator);
		transaction.setIbanSource(txtIbanSursa.getText());
		transaction.setIbanDest(txtIbanDestina.getText());
		transaction.setAmount(Double.parseDouble(txtSuma.getText()));
		TipTranzactie tip_tranzactie = TipTranzactie.depunere;			
		transaction.setTipTranzactie(tip_tranzactie);
		SendTransaction myTransaction=new SendTransaction();
		Response myResponse = myTransaction.getAnswer(transaction);
		
		System.out.println(myResponse);
		
		String informationAsString = myResponse.readEntity(String.class);					
		JSONObject jsonObject = new JSONObject(informationAsString); 
		
		System.out.println(informationAsString);
		
		Boolean transactionResult = jsonObject.getBoolean("TransactionResult");
		System.out.println(transactionResult);
		
		if(transactionResult==true)	{
			System.out.println("tranzactie reusita");
		}
		else {
			System.out.println("tranzactie esuata");
		}
		
		
	}
}
