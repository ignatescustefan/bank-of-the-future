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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JTextArea txtUsername;
	private JDesktopPane desktopPane;
	private JLabel loginIcon;
	private JLabel lblSignIn;
	private JLabel lblIncorrect;
	private JButton login;
	private EmployeeDTO user;
	private JLabel passwordIcon;
	private JLabel userIcon;
	private JButton btnCancel;
	private JLabel lblForgotPass;
	private JPanel panel;

	/**
	 * Launch the Login application.
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

	public LoginPanel() {

		super("Login");

		txtUsername = new JTextArea();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_TAB) {
					if (arg0.getModifiers() > 0) {
                        txtUsername.transferFocusBackward();
                    } else {
                    	txtUsername.transferFocus();
                    }
                    arg0.consume();
                }
				
			}
		});
		desktopPane = new JDesktopPane();
		loginIcon = new JLabel();
		lblSignIn = new JLabel("Sign in", SwingConstants.CENTER);
		lblIncorrect = new JLabel("Incorrect credentials.", SwingConstants.LEFT);
		login = new JButton("Login");
		login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_ENTER)
					login.doClick();
			}
		});
		passwordIcon = new JLabel("");
		userIcon = new JLabel("");
		btnCancel = new JButton("Cancel");
		lblForgotPass = new JLabel("Forgot Password?", SwingConstants.LEFT);
		panel = new JPanel();

		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPanel.class.getResource("/img/rip_icon.png")));
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane.setVerifyInputWhenFocusTarget(false);
		desktopPane.setToolTipText("");
		desktopPane.setBackground(new java.awt.Color(235, 238, 239));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		txtUsername.setToolTipText("username");
		txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtUsername.setBounds(127, 176, 136, 23);
		txtUsername.setBorder(new LineBorder(new Color(171, 173, 179)));
		desktopPane.add(txtUsername);

		loginIcon.setBounds(0, 0, 391, 104);
		loginIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/img/logn2.jpg")));
		desktopPane.add(loginIcon);

		lblSignIn.setBounds(127, 127, 136, 38);
		desktopPane.add(lblSignIn);
		lblSignIn.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblSignIn.setForeground(new Color(0, 0, 102));

		txtPasswordField = new JPasswordField();
		txtPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_ENTER) {
					login.doClick();
				}
			}
		});
		txtPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPasswordField.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtPasswordField.setBounds(127, 217, 136, 23);
		desktopPane.add(txtPasswordField);

		lblIncorrect = new JLabel("Incorrect credentials.", SwingConstants.LEFT);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String userString = txtUsername.getText();
				char[] passwordString = txtPasswordField.getPassword();

				String final_pass = "";
				for (char x : passwordString) {
					final_pass += x;
				}

				System.out.println(userString + " " + final_pass);

				user = new EmployeeDTO(userString, final_pass);

				// send request

				Manager m = new Manager();

				Response myResponse = m.createJsonUtilizator(user);

				System.out.println("My response");
				System.out.println(myResponse);

				String responseAsString = myResponse.readEntity(String.class);
				JSONObject jsonObject = new JSONObject(responseAsString);

				int loginOk = jsonObject.getInt("LoginOk");
				System.out.println(loginOk);

				System.out.println("My response");
				System.out.println(myResponse);

				if (loginOk == 0) {
					// false
					// set label date incorecte
					System.out.println("Date incorecte : loginOk=" + loginOk);
					txtUsername.setText("");
					txtPasswordField.setText("");
					lblIncorrect.setVisible(true);
					txtPasswordField.transferFocusBackward();
				} else {

					System.out.println("Date valide : loginOk=" + loginOk);

					String numeString = jsonObject.getString("Nume");
					String prenumeString = jsonObject.getString("Prenume");
					String emailString = jsonObject.getString("Email");

					angajat = new Employee(numeString, prenumeString, emailString);

					DashBoardRIP window = new DashBoardRIP(angajat);

					System.out.println("loginpanel angajat " + angajat.toString());
					window.setVisible(true);
					dispose();
				}
			}

		});
		login.setBorder(null);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		login.setForeground(SystemColor.textHighlightText);
		login.setBackground(new Color(87, 184, 70));
		login.setBounds(203, 287, 60, 23);

		desktopPane.add(login);

		passwordIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/img/key.png")));
		passwordIcon.setBounds(103, 217, 23, 23);
		desktopPane.add(passwordIcon);

		userIcon.setIcon(new ImageIcon(LoginPanel.class.getResource("/img/user.png")));
		userIcon.setBounds(103, 176, 23, 23);
		desktopPane.add(userIcon);

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

		lblForgotPass.setBounds(127, 262, 136, 14);
		lblForgotPass.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblForgotPass.setForeground(new Color(87, 184, 70));
		desktopPane.add(lblForgotPass);

		lblIncorrect.setVisible(false);
		lblIncorrect.setForeground(Color.RED);
		lblIncorrect.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblIncorrect.setBounds(127, 247, 136, 14);
		desktopPane.add(lblIncorrect);

		panel.setBackground(new Color(250, 250, 250));
		panel.setBounds(86, 115, 219, 214);
		desktopPane.add(panel);
	}
}
