package com.RIPBankDesktop;

import java.awt.Color;

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
	private JLabel lblEmail;
	private JPanel employeePanel;
	private JLabel employeeLbl;
	private JLabel employeeNameLbl;
	private Employee angajat;
	private JButton btnModifica;
	private JPanel mainPanel;
	private JLabel lblBackimage;
	private JPanel userSearch;
	private JTextField textCnp;

	/**
	 * Launch the demo Board.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { DashBoardRIP frame = new
	 * DashBoardRIP(new Employee("Aline", "Dua", "alina@mail.com"));
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */
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
					lblEmail.setVisible(true);
					btnModifica.setVisible(true);
					btnSetariCont.setText("Ascunde detalii");
				} else {
					lblName.setVisible(false);
					lblPrenume.setVisible(false);
					lblEmail.setVisible(false);
					btnModifica.setVisible(false);
					btnSetariCont.setText("Detalii cont");
				}
			}
		});
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrenume = new JLabel("Prenume");
		lblEmail = new JLabel("Email");
		employeePanel = new JPanel();
		employeeLbl = new JLabel("");
		employeeNameLbl = new JLabel("", SwingConstants.CENTER);


		lblName.setText(angajat.getNume());
		lblPrenume.setText(angajat.getPrenume());
		lblEmail.setText(angajat.getEmail());

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

		btnSetariCont.setBounds(69, 173, 110, 23);
		rightPanel.add(btnSetariCont);

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel = new LoginPanel();
				loginPanel.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(69, 483, 110, 23);
		rightPanel.add(btnLogout);

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(52, 221, 144, 29);
		lblName.setVisible(false);
		rightPanel.add(lblName);

		lblPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenume.setBounds(52, 261, 144, 29);
		lblPrenume.setVisible(false);
		rightPanel.add(lblPrenume);

		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(52, 301, 144, 29);
		lblEmail.setVisible(false);
		rightPanel.add(lblEmail);


		btnModifica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifica.setBounds(69, 341, 110, 23);
		btnModifica.setVisible(false);
		rightPanel.add(btnModifica);

		JButton btnCautareClient = new JButton("Cautare client");
		btnCautareClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				userSearch.setVisible(true);
			}
		});
		btnCautareClient.setBounds(69, 47, 110, 23);
		rightPanel.add(btnCautareClient);

		JButton btnAgaugareClient = new JButton("Agaugare client");
		btnAgaugareClient.setBounds(69, 98, 110, 23);
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
		userSearch.setBounds(219, 114, 682, 390);
		mainPanel.add(userSearch);
		userSearch.setLayout(null);

		textCnp = new JTextField();
		textCnp.setBounds(137, 104, 264, 38);
		userSearch.add(textCnp);
		textCnp.setColumns(10);

		JButton btnCauta = new JButton("");
		btnCauta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String cnp=textCnp.getText();
				ClientSearch client=new ClientSearch(cnp);

				Response myResponse=client.createJsonClient(cnp);
				System.out.println("CNP : "+ cnp);
				System.out.println("my response");
				System.out.println(myResponse);

				String myResponseAsString=myResponse.readEntity(String.class);

				System.out.println(myResponseAsString);

				JSONObject jsonInfo=new JSONObject(myResponseAsString);

				//int findUser=jsonObject.getInt("Error");

				if(jsonInfo.isNull("Error")==false){
					System.out.println("Not found");
				}
				else {
					System.out.println("Client found");

					JSONArray jsonArr=(JSONArray) jsonInfo.get("client");
					for(int i=0;i<jsonArr.length();i++) {
						JSONObject jsonClient=(JSONObject) jsonArr.get(i);			

						String telefonString=jsonClient.getString("telefon");
						String prenumeString = jsonClient.getString("prenume");
	//					String paroString=jsonClient.getString("parola");
						String numeString = jsonClient.getString("nume");
						String emailString = jsonClient.getString("email");
						ClientInfo clientInfo=new ClientInfo(numeString,prenumeString,emailString,telefonString);
						System.out.println(clientInfo.toString());
					}
				}



			}
		});
		btnCauta.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/client_search.png")));
		btnCauta.setBounds(422, 104, 38, 38);
		userSearch.add(btnCauta);

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
