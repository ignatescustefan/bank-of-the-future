package com.RIPBankDesktop;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.net.URI;

public class AddAccount extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSuma;
	private JComboBox<String> comboBox;
	public JButton btnNewButton;
	public JButton btnAnuleaza;
	String cnp;
	/**
	 * Create the panel.
	 */
	public AddAccount() {
		setBounds(0, 57, 893, 77);
		setLayout(null);
		comboBox = new JComboBox<String>();
		btnAnuleaza = new JButton("Anuleaza");
		txtSuma = new JTextField();
		txtSuma.setText("Suma");
		txtSuma.setBounds(101, 46, 86, 20);
		add(txtSuma);
		txtSuma.setColumns(10);
		btnNewButton = new JButton("Salveaza");
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"depozit", "economii", "altele"}));
		comboBox.setBounds(101, 11, 86, 20);
		add(comboBox);
		
		
		btnNewButton.setBounds(197, 45, 89, 23);
		add(btnNewButton);
		
		
		btnAnuleaza.setBounds(804, 45, 89, 23);
		add(btnAnuleaza);
		
		JLabel lblTipCont = new JLabel("Tip cont");
		lblTipCont.setBounds(10, 11, 81, 20);
		add(lblTipCont);
		
		JLabel lblSuma = new JLabel("Suma");
		lblSuma.setBounds(10, 42, 81, 24);
		add(lblSuma);
		
	}
	public void executeAddAccount() {
		ClientConfig config = new ClientConfig();
        //config.register(Custom);
        Client client = ClientBuilder.newClient(config);
        // Next line of code is a workaround for using PATCH
        // A value of true declares that the client will try to set unsupported HTTP method to java.net.HttpURLConnection via reflection.
        // PATCH workaround:
        //    - alternative to client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        //    - also allow PATCH to have a response body
        //    - see user1648865 response from https://stackoverflow.com/questions/17897171/how-to-have-a-patch-annotation-for-jax-rs 
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        WebTarget service = client.target(getBaseURI());
        Response response;;
        double suma=Double.parseDouble(txtSuma.getText());
        response = service.path("createAccount").path(cnp+"&"+comboBox.getSelectedItem().toString()+"&"+suma).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
        System.out.println(response);
    	
    	String informationAsString = response.readEntity(String.class);
    	System.out.println(informationAsString);
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/RIPBankServiciiWeb/api/").build();
	}
}
