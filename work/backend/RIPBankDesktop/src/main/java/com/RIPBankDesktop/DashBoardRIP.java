package com.RIPBankDesktop;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import org.json.JSONObject;

import com.ripbank.core.ClientInfo;
import com.ripbank.core.Employee;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.JTextField;

public class DashBoardRIP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7456512844086031995L;
	private JPanel contentPane;
	private LoginPanel loginPanel;
	private JLabel lblName;
	private JLabel bannerLabel;
	private JPanel rightPanel;
	private JButton btnSetariCont;
	private JButton btnLogout;
	private JLabel lblPrenume;
	private JLabel lblEmailEmployee;
	private JPanel employeePanel;
	private JLabel employeeLbl;
	private JLabel employeeNameLbl;
	private Employee angajat;
	private JPanel mainPanel;
	private JLabel lblBackimage;
	private JPanel userSearch;
	private JTextField textCnp;
	private JLabel lblNoClient;
	private JPanel panelClientSearch;
	private JLabel lblTelefon;
	private JLabel labelClientName;
	private JLabel labelClientPrenume;
	private JLabel labelClientEmail;
	private JLabel labelClientTelefon;
	private ModificaClient modificaClient;
	private String cnp;
	private AddClientPanel addClientPanel;
	private AccountPanel accountPanel;
	private JLabel lblClientStatus;
	/**
	 * Launch the demo Board.
	 */

	public static void main(String[] args) { EventQueue.invokeLater(new
			Runnable() { public void run() { try { DashBoardRIP frame = new
			DashBoardRIP(new Employee("Aline", "Dua", "alina@mail.com"));
			frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	}

	/**
	 * Create the frame.
	 */
	public DashBoardRIP(Employee employee) {
		super("RIP Bank");
		angajat = new Employee(employee.getNume(), employee.getPrenume(), employee.getEmail());
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPanel.class.getResource("/img/rip_icon.png")));
		lblName = new JLabel("Nume");
		bannerLabel = new JLabel("");
		contentPane = new JPanel();
		rightPanel = new JPanel();
		btnSetariCont = new JButton("Detalii cont");
		lblClientStatus = new JLabel("Status");
		btnSetariCont.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSetariCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (btnSetariCont.getText().equals("Detalii cont")) {

					lblName.setVisible(true);
					lblPrenume.setVisible(true);
					lblEmailEmployee.setVisible(true);
					btnSetariCont.setText("Ascunde detalii");
				} else {
					lblName.setVisible(false);
					lblPrenume.setVisible(false);
					lblEmailEmployee.setVisible(false);
					btnSetariCont.setText("Detalii cont");
				}
			}
		});
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrenume = new JLabel("Prenume");
		lblEmailEmployee = new JLabel("Email");
		employeePanel = new JPanel();
		employeeLbl = new JLabel("");
		employeeNameLbl = new JLabel("", SwingConstants.CENTER);

		lblName.setText(angajat.getNume());
		lblPrenume.setText(angajat.getPrenume());
		lblEmailEmployee.setText(angajat.getEmail());

		System.out.println("dashboard angajat " + angajat.toString());
		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1384, 754);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		bannerLabel.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/banner.png")));
		bannerLabel.setBounds(0, 0, 1200, 140);
		contentPane.add(bannerLabel);

		rightPanel.setBounds(0, 139, 249, 576);
		rightPanel.setBackground(new Color(21, 98, 114));
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);

		btnSetariCont.setBounds(61, 210, 127, 23);
		rightPanel.add(btnSetariCont);

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel = new LoginPanel();
				loginPanel.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(61, 483, 127, 23);
		rightPanel.add(btnLogout);

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 258, 229, 29);
		lblName.setVisible(false);
		rightPanel.add(lblName);

		lblPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenume.setBounds(10, 298, 229, 29);
		lblPrenume.setVisible(false);
		rightPanel.add(lblPrenume);

		lblEmailEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailEmployee.setBounds(10, 338, 229, 29);
		lblEmailEmployee.setVisible(false);
		rightPanel.add(lblEmailEmployee);

		JButton btnCautareClient = new JButton("Cautare client");
		btnCautareClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCautareClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				userSearch.setVisible(true);
				addClientPanel.setVisible(false);
			}
		});
		btnCautareClient.setBounds(61, 84, 127, 23);
		rightPanel.add(btnCautareClient);

		JButton btnAgaugareClient = new JButton("Agaugare client");
		btnAgaugareClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClientPanel.setVisible(true);
				userSearch.setVisible(false);
			}
		});
		btnAgaugareClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgaugareClient.setBounds(61, 135, 127, 23);
		rightPanel.add(btnAgaugareClient);

		JButton btnAcasa = new JButton("Acasa");
		btnAcasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userSearch.setVisible(false);
				addClientPanel.setVisible(false);
			}
		});
		btnAcasa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAcasa.setBounds(61, 27, 127, 23);
		rightPanel.add(btnAcasa);

		employeePanel.setBounds(1200, 0, 168, 140);
		employeePanel.setBackground(new Color(251, 141, 2));
		contentPane.add(employeePanel);
		employeePanel.setLayout(null);

		employeeLbl.setBounds(42, 11, 83, 83);
		employeePanel.add(employeeLbl);
		employeeLbl.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/manager.png")));

		employeeNameLbl.setBounds(14, 96, 140, 33);
		employeePanel.add(employeeNameLbl);
		employeeNameLbl.setText(angajat.getNume() + " " + angajat.getPrenume());


		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(250,250,250));
		mainPanel.setBounds(247, 139, 1121, 576);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		addClientPanel = new AddClientPanel();
		addClientPanel.setVisible(false);

		userSearch = new JPanel();
		userSearch.setBounds(110, 71, 929, 430);
		userSearch.setOpaque(true);
		mainPanel.add(userSearch);
		userSearch.setLayout(null);
		userSearch.setVisible(false);
		accountPanel = new AccountPanel(cnp);
		accountPanel.setVisible(false);
		accountPanel.setBounds(18, 285, 893, 134);
		userSearch.add(accountPanel);
		textCnp = new JTextField();
		textCnp.setBounds(331, 104, 264, 38);
		userSearch.add(textCnp);
		textCnp.setColumns(10);
		final JButton btnCauta = new JButton("");
		btnCauta.setBounds(620, 104, 38, 38);
		btnCauta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				accountPanel.setVisible(false);
				modificaClient.setVisible(false);
				ClientConfig config = new ClientConfig();
				Client client = ClientBuilder.newClient(config);
				client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
				WebTarget service = client.target(getBaseSearchURI());
				cnp=textCnp.getText();
				ClientInfo clientInfo;
				clientInfo=new ClientInfo();
				Response response = service.path(cnp).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
				System.out.println("CNP : "+ cnp);
				System.out.println("my response");
				System.out.println(response);

				String myResponseAsString=response.readEntity(String.class);

				System.out.println(myResponseAsString);

				JSONObject jsonInfo=new JSONObject(myResponseAsString);

				if(jsonInfo.isNull("Error")==false){
					lblNoClient.setVisible(true);
					lblNoClient.setText("Nu s-a gasit nici un client cu aceest cnp");
					System.out.println("Not found");
					panelClientSearch.setVisible(false);
				}
				else {

					System.out.println("Client found");
					lblNoClient.setVisible(false);
					lblNoClient.setText("");

					String telefonString=jsonInfo.getString("telefon");
					String prenumeString = jsonInfo.getString("prenume");
					String numeString = jsonInfo.getString("nume");
					String emailString = jsonInfo.getString("email");
					String statusString =jsonInfo.getString("status");
					clientInfo.setEmail(emailString);
					clientInfo.setNume(numeString);
					clientInfo.setPrenume(prenumeString);
					clientInfo.setTelefon(telefonString);
					System.out.println(clientInfo.toString());

					panelClientSearch.setVisible(true);
					labelClientEmail.setText(clientInfo.getEmail());
					labelClientName.setText(clientInfo.getNume());
					labelClientPrenume.setText(clientInfo.getPrenume());
					labelClientTelefon.setText(clientInfo.getTelefon());
					lblClientStatus.setText(statusString);
				}



			}
		});
		btnCauta.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/client_search.png")));
		userSearch.add(btnCauta);

		JLabel lblCautareClient = new JLabel("Cautare Client");
		lblCautareClient.setBounds(298, 11, 330, 82);
		lblCautareClient.setBackground(Color.RED);
		lblCautareClient.setForeground(Color.BLACK);
		lblCautareClient.setFont(new Font("Times New Roman", Font.ITALIC, 37));
		lblCautareClient.setHorizontalAlignment(SwingConstants.CENTER);
		userSearch.add(lblCautareClient);

		lblNoClient = new JLabel("text");
		lblNoClient.setBounds(209, 153, 264, 27);
		lblNoClient.setForeground(Color.RED);
		lblNoClient.setVisible(false);
		userSearch.add(lblNoClient);

		panelClientSearch = new JPanel();
		panelClientSearch.setVisible(false);

		modificaClient = new ModificaClient();
		modificaClient.setLocation(18, 285);
		modificaClient.btnSalveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelClientName.setText(modificaClient.textNumeUpdate.getText());
				labelClientPrenume.setText(modificaClient.textPrenumeUpdate.getText());
				labelClientTelefon.setText(modificaClient.textTelefonUpdate.getText());
			}
		});
		modificaClient.setVisible(false);
		userSearch.add(modificaClient);
		panelClientSearch.setBounds(18, 181, 893, 69);
		panelClientSearch.setBackground(Color.LIGHT_GRAY);
		userSearch.add(panelClientSearch);
		panelClientSearch.setLayout(null);



		JLabel lblNume = new JLabel("Nume");
		lblNume.setHorizontalAlignment(SwingConstants.CENTER);
		lblNume.setBounds(10, 11, 123, 20);
		panelClientSearch.add(lblNume);

		JLabel labelPrenume = new JLabel("Prenume");
		labelPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrenume.setBounds(127, 11, 123, 20);
		panelClientSearch.add(labelPrenume);

		JLabel lblEmailClient = new JLabel("Email");
		lblEmailClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailClient.setBounds(250, 11, 151, 20);
		panelClientSearch.add(lblEmailClient);

		lblTelefon = new JLabel("Telefon");
		lblTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefon.setBounds(401, 11, 97, 20);
		panelClientSearch.add(lblTelefon);

		labelClientName = new JLabel("Nume");
		labelClientName.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientName.setBounds(10, 38, 123, 20);
		panelClientSearch.add(labelClientName);

		labelClientPrenume = new JLabel("Prenume");
		labelClientPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientPrenume.setBounds(127, 38, 123, 20);
		panelClientSearch.add(labelClientPrenume);

		labelClientEmail = new JLabel("Email");
		labelClientEmail.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientEmail.setBounds(250, 38, 151, 20);
		panelClientSearch.add(labelClientEmail);

		labelClientTelefon = new JLabel("Telefon");
		labelClientTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientTelefon.setBounds(401, 38, 97, 20);
		panelClientSearch.add(labelClientTelefon);

		JButton btnNewButton = new JButton("Conturi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountPanel.setVisible(true);
				accountPanel.accountImport(cnp);
			}
		});
		btnNewButton.setBounds(611, 38, 84, 23);
		panelClientSearch.add(btnNewButton);

		JButton btnModifica_1 = new JButton("Modifica");
		btnModifica_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountPanel.setVisible(false);
				modificaClient.setVisible(true);
				modificaClient.setCnp(cnp);
			}
		});
		btnModifica_1.setBounds(705, 38, 84, 23);
		panelClientSearch.add(btnModifica_1);

		JButton btnSterge = new JButton("Sterge");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accountPanel.setVisible(false);
				modificaClient.setVisible(false);
				ClientConfig config = new ClientConfig();
				Client client = ClientBuilder.newClient(config);
				client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);

				WebTarget service = client.target(getBaseURI());

				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Your Message", "Title on Box", dialogButton);
				if(dialogResult == 0) {
					System.out.println("Yes option");
					Response myresponse = service.path(cnp).request().accept(MediaType.APPLICATION_JSON).delete(Response.class);

					String informationAsString = myresponse.readEntity(String.class);					
					System.out.println(informationAsString);

					JSONObject jsonObject = new JSONObject(informationAsString); 

					System.out.println(informationAsString);

					boolean updateStatus = jsonObject.getBoolean("Deleted");
					System.out.println("Status Deleted : " + updateStatus);

					panelClientSearch.setVisible(false);

				} else {
					System.out.println("No Option");
				} 
			}
		});
		btnSterge.setBounds(799, 38, 84, 23);
		panelClientSearch.add(btnSterge);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(499, 14, 97, 20);
		panelClientSearch.add(lblStatus);
		
		
		lblClientStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientStatus.setBounds(499, 41, 97, 20);
		panelClientSearch.add(lblClientStatus);
		mainPanel.add(addClientPanel);

		lblBackimage = new JLabel("backImage");
		lblBackimage.setBounds(0, 0, 1121, 576);
		lblBackimage.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/WelcomeWallpaper.png")));
		mainPanel.add(lblBackimage);

	}

	protected URI getBaseURI() {
		// TODO Auto-generated method stub
		return UriBuilder.fromUri("http://localhost:8080/RIPBankServiciiWeb/api/delete").build();
	}
	protected URI getBaseSearchURI() {
		// TODO Auto-generated method stub
		return UriBuilder.fromUri("http://localhost:8080/RIPBankServiciiWeb/api/clients").build();
	}
	public boolean getThisResizable() {
		return isResizable();
	}

	public void setThisResizable(boolean resizable) {
		setResizable(resizable);
	}
}
