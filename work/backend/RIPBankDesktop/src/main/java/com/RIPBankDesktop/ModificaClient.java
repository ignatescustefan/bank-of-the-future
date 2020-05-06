package com.RIPBankDesktop;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.json.JSONObject;

import DTO.PersonDTO;

import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;

public class ModificaClient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	public JTextField textNumeUpdate;
	public JTextField textPrenumeUpdate;
	public JTextField textTelefonUpdate;
	public JButton btnSalveaza;
	public JButton btnAnuleaza;
	private String cnp;
	public int status;
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public PersonDTO executeModificaClient() {
		PersonDTO  user = new PersonDTO();
		String nume = textNumeUpdate.getText();
		String prenume = textPrenumeUpdate.getText();
		String telefon = textTelefonUpdate.getText();
		if(nume.length()==0 || prenume.length()==0 || telefon.length()==0) {
			JOptionPane.showMessageDialog(null, "Nu lasati campuri necompletate!");
			status=1;
		}
		else {
			status=0;

			user.setNume(nume);
			user.setPrenume(prenume);
			user.setTelefon(telefon);

			ClientConfig config = new ClientConfig();
			Client client = ClientBuilder.newClient(config);
			client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);

			WebTarget service = client.target(getBaseURI());


			Response myresponse =service.path(cnp).request(MediaType.APPLICATION_JSON)
					.method("PATCH", Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);

			String informationAsString = myresponse.readEntity(String.class);					
			JSONObject jsonObject = new JSONObject(informationAsString); 

			System.out.println(informationAsString);

			int updateStatus = jsonObject.getInt("UpdateUserInfo");
			System.out.println(updateStatus);

			System.out.println(myresponse);
			if(updateStatus==1) {
				JOptionPane.showMessageDialog(null, "Modificari efectuate");
				textNumeUpdate.setText("");
				textPrenumeUpdate.setText("");
				textTelefonUpdate.setText("");

				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "Eroare");
				textNumeUpdate.setText("");
				textPrenumeUpdate.setText("");
				textTelefonUpdate.setText("");
				setVisible(true);
			}
		}
		return user;
	}
	public ModificaClient()
	{
		super();
		status=0;
		setBackground(Color.GRAY);
		setBounds(10, 285, 893, 134);
		setLayout(null);
		setVisible(true);
		label = new JLabel("Nume");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 123, 20);
		add(label);

		label_1 = new JLabel("Prenume");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 40, 123, 20);
		add(label_1);

		label_2 = new JLabel("Telefon");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(23, 86, 97, 20);
		add(label_2);

		textNumeUpdate = new JTextField();
		textNumeUpdate.setBounds(136, 11, 123, 20);
		add(textNumeUpdate);
		textNumeUpdate.setColumns(10);

		textPrenumeUpdate = new JTextField();
		textPrenumeUpdate.setColumns(10);
		textPrenumeUpdate.setBounds(136, 40, 123, 20);
		add(textPrenumeUpdate);

		textTelefonUpdate = new JTextField();
		textTelefonUpdate.setColumns(10);
		textTelefonUpdate.setBounds(136, 86, 123, 20);
		add(textTelefonUpdate);

		btnSalveaza = new JButton("Salveaza");
		
		btnSalveaza.setBounds(582, 100, 91, 23);
		add(btnSalveaza);
		
		btnAnuleaza = new JButton("Anuleaza");
		btnAnuleaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNumeUpdate.setText("");
				textPrenumeUpdate.setText("");
				textTelefonUpdate.setText("");
				setVisible(false);
			}
		});
		btnAnuleaza.setBounds(696, 100, 91, 23);
		add(btnAnuleaza);
	}
	private URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RIPBankServiciiWeb/api/update/userInfo/").build();
	}
}
