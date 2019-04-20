package com.RIPBankDesktop;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AddClientPanel extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JLabel lblnregistrareClient;
	private JTextField txtNume;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField pwdParola;
	private JPasswordField pwdConfirmareparola;
	
	/**
	 * Create the panel.
	 */
	public AddClientPanel() {
		setBounds(new Rectangle(0, 0, 929, 430));

		this.setBounds(110, 71, 929, 430);
		setVisible(true);
		setLayout(null);
		
		lblnregistrareClient = new JLabel("Înregistrare client");
		lblnregistrareClient.setBounds(298, 11, 330, 82);
		lblnregistrareClient.setBackground(Color.RED);
		lblnregistrareClient.setForeground(Color.BLACK);
		lblnregistrareClient.setFont(new Font("Times New Roman", Font.ITALIC, 37));
		lblnregistrareClient.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblnregistrareClient);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(56, 77, 735, 329);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume :");
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNume.setHorizontalAlignment(SwingConstants.CENTER);
		lblNume.setBounds(253, 16, 72, 24);
		panel.add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume :");
		lblPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenume.setBounds(253, 52, 72, 24);
		panel.add(lblPrenume);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(251, 90, 72, 24);
		panel.add(lblEmail);
		
		JLabel lblCnp = new JLabel("CNP :");
		lblCnp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCnp.setBounds(251, 128, 72, 24);
		panel.add(lblCnp);
		
		JLabel lblParola = new JLabel("Parola :");
		lblParola.setHorizontalAlignment(SwingConstants.CENTER);
		lblParola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParola.setBounds(251, 166, 72, 24);
		panel.add(lblParola);
		
		JLabel lblConfirmareParola = new JLabel("Confirmare parola :");
		lblConfirmareParola.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmareParola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmareParola.setBounds(221, 204, 132, 24);
		panel.add(lblConfirmareParola);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefon.setBounds(251, 242, 72, 24);
		panel.add(lblTelefon);
		
		txtNume = new JTextField();
		txtNume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNume.setText("Nume");
		txtNume.setBounds(401, 16, 198, 24);
		panel.add(txtNume);
		txtNume.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Nume");
		textField.setColumns(10);
		textField.setBounds(401, 52, 198, 24);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Nume");
		textField_1.setColumns(10);
		textField_1.setBounds(401, 90, 198, 24);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Nume");
		textField_2.setColumns(10);
		textField_2.setBounds(401, 128, 198, 24);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("Nume");
		textField_3.setColumns(10);
		textField_3.setBounds(401, 242, 198, 24);
		panel.add(textField_3);
		
		pwdParola = new JPasswordField();
		pwdParola.setText("Parola");
		pwdParola.setBounds(401, 166, 198, 20);
		panel.add(pwdParola);
		
		pwdConfirmareparola = new JPasswordField();
		pwdConfirmareparola.setText("ConfirmareParola");
		pwdConfirmareparola.setBounds(401, 204, 198, 20);
		panel.add(pwdConfirmareparola);
		
		JButton btnInregistreaza = new JButton("Inregistreaza");
		btnInregistreaza.setBounds(253, 295, 106, 23);
		panel.add(btnInregistreaza);
		
		JButton btnAnuleaza = new JButton("Anuleaza");
		btnAnuleaza.setBounds(401, 295, 106, 23);
		panel.add(btnAnuleaza);
	}
}
