package com.RIPBankDesktop;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.ripbank.core.ClientStatus;
import com.ripbank.core.User;
import com.ripbank.response.AddManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;



public class AddClientPanel extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JLabel lblnregistrareClient;
	private JTextField txtNume;
	private JTextField txtPrenume;
	private JTextField txtEmail;
	private JTextField txtCnp;
	private JTextField txtTelefon;
	private JPasswordField pwdParola;
	private JPasswordField pwdConfirmareparola;
	private User newClient;
	/**
	 * Create the panel.
	 */
	public AddClientPanel() {
		setBounds(new Rectangle(0, 0, 929, 430));

		this.setBounds(110, 71, 929, 430);
		setVisible(true);
		setLayout(null);
		newClient = new User();
		lblnregistrareClient = new JLabel("Înregistrare client");
		lblnregistrareClient.setBounds(298, 11, 330, 82);
		lblnregistrareClient.setBackground(Color.RED);
		lblnregistrareClient.setForeground(Color.BLACK);
		lblnregistrareClient.setFont(new Font("Times New Roman", Font.ITALIC, 37));
		lblnregistrareClient.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblnregistrareClient);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(251, 141, 2));;
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
		txtNume.setText("");
		txtNume.setBounds(401, 16, 198, 24);
		panel.add(txtNume);
		txtNume.setColumns(10);
		
		txtPrenume = new JTextField();
		txtPrenume.setText("");
		txtPrenume.setColumns(10);
		txtPrenume.setBounds(401, 52, 198, 24);
		panel.add(txtPrenume);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(401, 90, 198, 24);
		panel.add(txtEmail);
		
		txtCnp = new JTextField();
		txtCnp.setText("");
		txtCnp.setColumns(10);
		txtCnp.setBounds(401, 128, 198, 24);
		panel.add(txtCnp);
		
		txtTelefon = new JTextField();
		txtTelefon.setText("");
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(401, 242, 198, 24);
		panel.add(txtTelefon);
		
		pwdParola = new JPasswordField();
		pwdParola.setText("");
		pwdParola.setBounds(401, 166, 198, 20);
		panel.add(pwdParola);
		
		pwdConfirmareparola = new JPasswordField();
		pwdConfirmareparola.setText("");
		pwdConfirmareparola.setBounds(401, 204, 198, 20);
		panel.add(pwdConfirmareparola);
		
		JButton btnInregistreaza = new JButton("Inregistreaza");
		btnInregistreaza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nume=txtNume.getText();
				String prenume=txtPrenume.getText();
				String email=txtEmail.getText();
				char[] passwordString = pwdParola.getPassword();
				char[] passwordConfirm = pwdConfirmareparola.getPassword();
				String cnp=txtCnp.getText();
				String telefon=txtTelefon.getText();
				if(Arrays.equals(passwordString, passwordConfirm)){
					System.out.println("Parole identice");
					String final_pass = "";
					for (char x : passwordString) {
						final_pass += x;
					}
					newClient.setNume(nume);
					newClient.setPrenume(prenume);
					newClient.setEmail(email);
					newClient.setCnp(cnp);
					newClient.setTelefon(telefon);
					newClient.setParola(final_pass);
					newClient.setClientStatus(ClientStatus.activ);
					AddManager m = new AddManager();

					try {
						Response myResponse = m.createJsonClient(newClient);			
						System.out.println("My response");
						System.out.println(myResponse);
						
						String responseAsString = myResponse.readEntity(String.class);
						System.out.println(responseAsString);
						
						JSONObject jsonObject = new JSONObject(responseAsString);

						boolean result=jsonObject.getBoolean("Created");
						
						if(result==true) {
							System.out.println("client created true");
							JOptionPane.showMessageDialog(null, "Client creat cu succes");
							txtNume.setText("");
							txtPrenume.setText("");
							txtTelefon.setText("");
							txtEmail.setText("");
							pwdConfirmareparola.setText("");
							pwdParola.setText("");
							setVisible(false);
						}
						else {
							System.out.println("client created false ");
							JOptionPane.showMessageDialog(null, "Eroare la creare client");
						}
					}
					catch(Exception e) {
						System.out.println("eroare");
					}

				}
				else {
					System.out.println("Parole diferite");
				}
				
				
			}
		});
		btnInregistreaza.setBounds(238, 295, 121, 23);
		panel.add(btnInregistreaza);
		
		JButton btnAnuleaza = new JButton("Anuleaza");
		btnAnuleaza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		btnAnuleaza.setBounds(401, 295, 121, 23);
		panel.add(btnAnuleaza);
	}
}
