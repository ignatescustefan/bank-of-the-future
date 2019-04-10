package com.RIPBankDesktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 812408638340163190L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JPasswordField txtPasswordField;
	private Employee angajat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel frame = new LoginPanel();
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
	public static final String encrypt(String md5) {
	    try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {}
	    return null;
	}
	public LoginPanel() {
		
		
		super("Login");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPanel.class.getResource("/img/rip_icon.png")));
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setVerifyInputWhenFocusTarget(false);
		desktopPane.setToolTipText("");
		desktopPane.setBackground(new java.awt.Color(235, 238, 239));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		final JTextArea txtUsername = new JTextArea();
		txtUsername.setToolTipText("username");
		txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtUsername.setBounds(127, 176, 136, 23);
		txtUsername.setBorder(new LineBorder(new Color(171, 173, 179)));
		desktopPane.add(txtUsername);
		
		JLabel loginIcon = new JLabel();
		loginIcon.setBounds(0, 0, 391, 104);
		loginIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/img/logn2.jpg")));
		desktopPane.add(loginIcon);
		
		JLabel lblSignIn = new JLabel("Sign in",SwingConstants.CENTER);
		lblSignIn.setBounds(127, 127, 136, 38);
		desktopPane.add(lblSignIn);
		lblSignIn.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblSignIn.setForeground(new Color(0, 0, 102));
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPasswordField.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtPasswordField.setBounds(127, 217, 136, 23);
		desktopPane.add(txtPasswordField);
		
		
		
		final JLabel lblIncorrect = new JLabel("Incorrect credentials.", SwingConstants.LEFT);
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//GraphicsEnvironment localEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
				//GraphicsDevice defaultDevice = localEnvironment.getDefaultScreenDevice();
				//.setFullScreenWindow(window);
				
				//TODO: logica de login
				
	
				String userString=txtUsername.getText();
				char[] passwordString=txtPasswordField.getPassword();
				
				//char[] pass = tb_pwd.getPassword();
				String final_pass = "";
				for (char x : passwordString) {
				    final_pass += x;
				}
				
				System.out.println(userString+" "+ final_pass);
				
				EmployeeDTO user= new EmployeeDTO(userString, final_pass);
				
				//send request
				
				Manager m=new Manager();
				
				Response myResponse=m.createJsonUtilizator(user);
				
				System.out.println("My response");
				System.out.println(myResponse);
				
				String responseAsString = myResponse.readEntity(String.class);
				JSONObject jsonObject = new JSONObject(responseAsString);
				
				
				int loginOk=jsonObject.getInt("LoginOk");
				System.out.println(loginOk);
				
				System.out.println("My response");
				System.out.println(myResponse);
				
				if(loginOk==0) {
					//false
					//set label date incorecte
					System.out.println("Date incorecte : loginOk="+loginOk);
					lblIncorrect.setVisible(true);;
				}
				else{
					
					System.out.println("Date valide : loginOk="+loginOk);
					
					String numeString=jsonObject.getString("Nume");
					String prenumeString=jsonObject.getString("Prenume");
					String emailString=jsonObject.getString("Email");
					
					angajat=new Employee(numeString,prenumeString,emailString);
					
					DashBoardRIP window=new DashBoardRIP(angajat);
					
					System.out.println("loginpanel angajat "+ angajat.toString());
					window.setVisible(true);
		            dispose();
				}
				}
				
		});
		login.setBorder(null);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		login.setForeground(SystemColor.textHighlightText);
		//login.setBorder(new LineBorder(SystemColor.scrollbar, 1, true));
		login.setBackground(new Color(87, 184, 70));
		login.setBounds(203, 287, 60, 23);
		desktopPane.add(login);
		
		JLabel passwordIcon = new JLabel("");
		passwordIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/img/key.png")));
		passwordIcon.setBounds(103, 217, 23, 23);
		desktopPane.add(passwordIcon);
		
		JLabel userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/img/user.png")));
		userIcon.setBounds(103, 176, 23, 23);
		desktopPane.add(userIcon);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(87, 184, 70));
		btnCancel.setBounds(127, 287, 60, 23);
		desktopPane.add(btnCancel);
		
		JLabel lblForgotPass = new JLabel("Forgot Password?",SwingConstants.LEFT);
		lblForgotPass.setBounds(127, 262, 136, 14);
		lblForgotPass.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblForgotPass.setForeground(new Color(87, 184, 70));
		desktopPane.add(lblForgotPass);
		
		lblIncorrect.setVisible(false);
		lblIncorrect.setForeground(Color.RED);
		lblIncorrect.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblIncorrect.setBounds(127, 247, 136, 14);
		desktopPane.add(lblIncorrect);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250,250,250));
		panel.setBounds(86, 115, 219, 214);
		desktopPane.add(panel);
	}
}
