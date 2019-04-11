package com.RIPBankDesktop;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;

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
	private JPanel firstPanel;
	private JPanel panelWelc;
	private JLabel lblBineAiVenit;
	private JPanel panelContent;

	/**
	 * Launch the demo Board.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoardRIP frame = new DashBoardRIP(new Employee("Aline", "Dua", "alina@mail.com"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

		btnSetariCont.setBounds(69, 49, 110, 23);
		rightPanel.add(btnSetariCont);

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel = new LoginPanel();
				loginPanel.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(69, 463, 110, 23);
		rightPanel.add(btnLogout);

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(52, 97, 144, 29);
		lblName.setVisible(false);
		rightPanel.add(lblName);

		lblPrenume.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenume.setBounds(52, 137, 144, 29);
		lblPrenume.setVisible(false);
		rightPanel.add(lblPrenume);

		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(52, 177, 144, 29);
		lblEmail.setVisible(false);
		rightPanel.add(lblEmail);
		
		
		btnModifica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifica.setBounds(69, 217, 110, 23);
		btnModifica.setVisible(false);
		rightPanel.add(btnModifica);

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
		
		firstPanel = new JPanel();
		firstPanel.setBorder(new LineBorder(new Color(105, 105, 105)));
		firstPanel.setBackground(new Color(235, 238, 239));
		firstPanel.setBounds(83, 27, 954, 521);
		mainPanel.add(firstPanel);
		firstPanel.setLayout(null);
		
		panelWelc = new JPanel();
		panelWelc.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		panelWelc.setBounds(374, 38, 400, 74);
		panelWelc.setBackground(new Color(251, 141, 2));
		firstPanel.add(panelWelc);
		panelWelc.setLayout(null);
		
		lblBineAiVenit = new JLabel("Bine ai venit ");
		lblBineAiVenit.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 29));
		lblBineAiVenit.setHorizontalAlignment(SwingConstants.CENTER);
		lblBineAiVenit.setForeground(SystemColor.window);
		lblBineAiVenit.setBounds(10, 11, 380, 53);
		panelWelc.add(lblBineAiVenit);
		
		panelContent = new JPanel();
		panelContent.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		panelContent.setBackground(UIManager.getColor("Button.highlight"));
		panelContent.setBounds(68, 169, 818, 312);
		firstPanel.add(panelContent);
		panelContent.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("username");
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textArea.setBorder(new LineBorder(new Color(171, 173, 179)));
		textArea.setBounds(316, 50, 186, 38);
		panelContent.add(textArea);
		
		JLabel lblCautaClient = new JLabel("Cauta client");
		lblCautaClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblCautaClient.setBounds(193, 50, 91, 38);
		panelContent.add(lblCautaClient);
		
		JButton btnCauta = new JButton("");
		btnCauta.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/client_search.png")));
		btnCauta.setBounds(532, 50, 38, 38);
		panelContent.add(btnCauta);

	}

	public boolean getThisResizable() {
		return isResizable();
	}

	public void setThisResizable(boolean resizable) {
		setResizable(resizable);
	}
}
