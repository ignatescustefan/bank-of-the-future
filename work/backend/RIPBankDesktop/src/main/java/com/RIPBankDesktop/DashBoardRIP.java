package com.RIPBankDesktop;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JButton btnModifica;
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
		btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnSetariCont.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSetariCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (btnSetariCont.getText().equals("Detalii cont")) {

					lblName.setVisible(true);
					lblPrenume.setVisible(true);
					lblEmailEmployee.setVisible(true);
					btnModifica.setVisible(true);
					btnSetariCont.setText("Ascunde detalii");
				} else {
					lblName.setVisible(false);
					lblPrenume.setVisible(false);
					lblEmailEmployee.setVisible(false);
					btnModifica.setVisible(false);
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

		btnSetariCont.setBounds(69, 173, 127, 23);
		rightPanel.add(btnSetariCont);

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel = new LoginPanel();
				loginPanel.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(69, 483, 127, 23);
		rightPanel.add(btnLogout);

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 221, 229, 29);
		lblName.setVisible(false);
		rightPanel.add(lblName);

		lblPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenume.setBounds(10, 261, 229, 29);
		lblPrenume.setVisible(false);
		rightPanel.add(lblPrenume);

		lblEmailEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailEmployee.setBounds(10, 301, 229, 29);
		lblEmailEmployee.setVisible(false);
		rightPanel.add(lblEmailEmployee);


		btnModifica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifica.setBounds(69, 341, 127, 23);
		btnModifica.setVisible(false);
		rightPanel.add(btnModifica);

		JButton btnCautareClient = new JButton("Cautare client");
		btnCautareClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCautareClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				userSearch.setVisible(true);
			}
		});
		btnCautareClient.setBounds(69, 47, 127, 23);
		rightPanel.add(btnCautareClient);

		JButton btnAgaugareClient = new JButton("Agaugare client");
		btnAgaugareClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgaugareClient.setBounds(69, 98, 127, 23);
		rightPanel.add(btnAgaugareClient);

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

		userSearch = new JPanel();
		userSearch.setVisible(false);
		userSearch.setOpaque(true);
		userSearch.setBounds(117, 114, 927, 390);
		mainPanel.add(userSearch);
		userSearch.setLayout(null);

		textCnp = new JTextField();
		textCnp.setBounds(331, 104, 264, 38);
		userSearch.add(textCnp);
		textCnp.setColumns(10);

		JButton btnCauta = new JButton("");
		btnCauta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String cnp=textCnp.getText();
				ClientSearch client=new ClientSearch(cnp);
				ClientInfo clientInfo;
				clientInfo=new ClientInfo();
				Response myResponse=client.createJsonClient(cnp);
				System.out.println("CNP : "+ cnp);
				System.out.println("my response");
				System.out.println(myResponse);

				String myResponseAsString=myResponse.readEntity(String.class);

				System.out.println(myResponseAsString);

				JSONObject jsonInfo=new JSONObject(myResponseAsString);

				//int findUser=jsonObject.getInt("Error");
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
					JSONArray jsonArr=(JSONArray) jsonInfo.get("client");
					for(int i=0;i<jsonArr.length();i++) {
						JSONObject jsonClient=(JSONObject) jsonArr.get(i);			

						String telefonString=jsonClient.getString("telefon");
						String prenumeString = jsonClient.getString("prenume");
	//					String paroString=jsonClient.getString("parola");
						String numeString = jsonClient.getString("nume");
						String emailString = jsonClient.getString("email");
						clientInfo.setEmail(emailString);
						clientInfo.setNume(numeString);
						clientInfo.setPrenume(prenumeString);
						clientInfo.setTelefon(telefonString);
						System.out.println(clientInfo.toString());
						
					}
					panelClientSearch.setVisible(true);
					labelClientEmail.setText(clientInfo.getEmail());
					labelClientName.setText(clientInfo.getNume());
					labelClientPrenume.setText(clientInfo.getPrenume());
					labelClientTelefon.setText(clientInfo.getTelefon());
				}



			}
		});
		btnCauta.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/client_search.png")));
		btnCauta.setBounds(620, 104, 38, 38);
		userSearch.add(btnCauta);
		
		JLabel lblCautareClient = new JLabel("Cautare Client");
		lblCautareClient.setBackground(Color.RED);
		lblCautareClient.setForeground(Color.BLACK);
		lblCautareClient.setFont(new Font("Times New Roman", Font.ITALIC, 37));
		lblCautareClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblCautareClient.setBounds(298, 11, 330, 82);
		userSearch.add(lblCautareClient);
		
		lblNoClient = new JLabel("text");
		lblNoClient.setForeground(Color.RED);
		lblNoClient.setBounds(209, 153, 264, 27);
		lblNoClient.setVisible(false);
		userSearch.add(lblNoClient);
		
		panelClientSearch = new JPanel();
		panelClientSearch.setVisible(false);
		panelClientSearch.setBackground(Color.LIGHT_GRAY);
		panelClientSearch.setBounds(53, 180, 820, 69);
		userSearch.add(panelClientSearch);
		panelClientSearch.setLayout(null);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setHorizontalAlignment(SwingConstants.CENTER);
		lblNume.setBounds(10, 11, 97, 20);
		panelClientSearch.add(lblNume);
		
		JLabel labelPrenume = new JLabel("Prenume");
		labelPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrenume.setBounds(117, 11, 97, 20);
		panelClientSearch.add(labelPrenume);
		
		JLabel lblEmailClient = new JLabel("Email");
		lblEmailClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailClient.setBounds(224, 11, 97, 20);
		panelClientSearch.add(lblEmailClient);
		
		lblTelefon = new JLabel("Telefon");
		lblTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefon.setBounds(331, 11, 97, 20);
		panelClientSearch.add(lblTelefon);
		
		labelClientName = new JLabel("Nume");
		labelClientName.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientName.setBounds(10, 38, 97, 20);
		panelClientSearch.add(labelClientName);
		
		labelClientPrenume = new JLabel("Prenume");
		labelClientPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientPrenume.setBounds(117, 38, 97, 20);
		panelClientSearch.add(labelClientPrenume);
		
		labelClientEmail = new JLabel("Email");
		labelClientEmail.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientEmail.setBounds(224, 38, 97, 20);
		panelClientSearch.add(labelClientEmail);
		
		labelClientTelefon = new JLabel("Telefon");
		labelClientTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		labelClientTelefon.setBounds(331, 38, 97, 20);
		panelClientSearch.add(labelClientTelefon);
		
		JButton btnNewButton = new JButton("Conturi");
		btnNewButton.setBounds(483, 38, 84, 23);
		panelClientSearch.add(btnNewButton);
		
		JButton btnModifica_1 = new JButton("Modifica");
		btnModifica_1.setBounds(577, 38, 84, 23);
		panelClientSearch.add(btnModifica_1);
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.setBounds(671, 38, 84, 23);
		panelClientSearch.add(btnSterge);

		lblBackimage = new JLabel("backImage");
		lblBackimage.setBounds(0, 0, 1121, 576);
		lblBackimage.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/WelcomeWallpaper.jpg")));
		mainPanel.add(lblBackimage);

	}

	public boolean getThisResizable() {
		return isResizable();
	}

	public void setThisResizable(boolean resizable) {
		setResizable(resizable);
	}
}
