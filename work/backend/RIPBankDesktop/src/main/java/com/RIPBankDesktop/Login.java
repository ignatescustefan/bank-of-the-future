package com.RIPBankDesktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/rip-ico.ico")));
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
		
		JTextArea username = new JTextArea();
		username.setToolTipText("username");
		username.setFont(new Font("SansSerif", Font.PLAIN, 14));
		username.setBounds(127, 176, 136, 23);
		username.setBorder(new LineBorder(new Color(171, 173, 179)));
		desktopPane.add(username);
		
		JLabel loginIcon = new JLabel();
		loginIcon.setBounds(0, 0, 391, 104);
		loginIcon.setIcon(new ImageIcon(Login.class.getResource("/img/logn2.jpg")));
		desktopPane.add(loginIcon);
		
		JLabel lblSignIn = new JLabel("Sign in",SwingConstants.CENTER);
		lblSignIn.setBounds(127, 127, 136, 38);
		desktopPane.add(lblSignIn);
		lblSignIn.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblSignIn.setForeground(new Color(0, 0, 102));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179)));
		passwordField.setBounds(127, 217, 136, 23);
		desktopPane.add(passwordField);
		
		JButton login = new JButton("Login");
		login.setBorder(null);
		login.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		login.setForeground(SystemColor.textHighlightText);
		//login.setBorder(new LineBorder(SystemColor.scrollbar, 1, true));
		login.setBackground(new Color(87, 184, 70));
		login.setBounds(203, 271, 60, 23);
		desktopPane.add(login);
		
		JLabel passwordIcon = new JLabel("");
		passwordIcon.setIcon(new ImageIcon(Login.class.getResource("/img/key.png")));
		passwordIcon.setBounds(103, 217, 23, 23);
		desktopPane.add(passwordIcon);
		
		JLabel userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(Login.class.getResource("/img/user.png")));
		userIcon.setBounds(103, 176, 23, 23);
		desktopPane.add(userIcon);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(87, 184, 70));
		btnCancel.setBounds(127, 271, 60, 23);
		desktopPane.add(btnCancel);
		
		JLabel lblForgotPass = new JLabel("Forgot Password?",SwingConstants.LEFT);
		lblForgotPass.setBounds(127, 246, 136, 14);
		lblForgotPass.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblForgotPass.setForeground(new Color(87, 184, 70));
		desktopPane.add(lblForgotPass);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(171, 173, 179), 1));
		panel.setBackground(new Color(250, 250, 250));
		panel.setBounds(90, 115, 211, 193);
		desktopPane.add(panel);
	}
}
