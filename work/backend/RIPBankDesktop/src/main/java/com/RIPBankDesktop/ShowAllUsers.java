package com.RIPBankDesktop;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.net.URI;

public class ShowAllUsers extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public DefaultTableModel model;
	private JScrollPane scrollPanel;
	public ShowAllUsers() {
		setBounds(110, 71, 929, 430);
		setVisible(true);
		setLayout(null);
		model = new DefaultTableModel(); 
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);

		model.addColumn("Nume");
		model.addColumn("Prenume");
		model.addColumn("Email");
		model.addColumn("Telefon");
		model.addColumn("Status client");
		table.setSize(820, 60);

		scrollPanel= new JScrollPane(table);
		scrollPanel.setBounds(5, 146, 919, 256);
		add(scrollPanel);
		JLabel lblClientiInregistrati = new JLabel("Clienți înregistrați");
		lblClientiInregistrati.setBackground(Color.RED);
		lblClientiInregistrati.setForeground(Color.BLACK);
		lblClientiInregistrati.setFont(new Font("Times New Roman", Font.ITALIC, 37));
		lblClientiInregistrati.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientiInregistrati.setBounds(274, 35, 380, 62);
		add(lblClientiInregistrati);
	}
	public void userImport() {
		model.setRowCount(0);
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
		WebTarget service = client.target(getBaseSearchURI());
		Response response = service.path("user").request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		System.out.println("my response");
		System.out.println(response);

		String myResponseAsString=response.readEntity(String.class);

		System.out.println(myResponseAsString);

		JSONObject jsonInformatin=new JSONObject(myResponseAsString);
		
		JSONArray jsonUser = (JSONArray) jsonInformatin.get("user");
		//System.out.println(jsonUser);
		for(int i=0;i<jsonUser.length();i++) {
			JSONObject item=(JSONObject) jsonUser.get(i);
			String nume=item.getString("nume");
			String prenume=item.getString("prenume");
			String email=item.getString("email");
			String telefon=item.getString("telefon");
			String status=item.getString("status");
			model.addRow(new Object[] {nume,prenume,email,telefon,status});
		}
		

	}
	private static URI getBaseSearchURI() {
		return UriBuilder.fromUri("http://localhost:8080/RIPBankServiciiWeb/api").build();
	}
}