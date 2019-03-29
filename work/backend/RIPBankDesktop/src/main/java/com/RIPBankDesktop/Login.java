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
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new java.awt.Color(235, 238, 239));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JTextArea username = new JTextArea();
		username.setBounds(136, 176, 136, 23);
		username.setBorder(new LineBorder(new Color(0, 0, 0)));
		desktopPane.add(username);
		
		JLabel loginIcon = new JLabel();
		loginIcon.setBounds(0, 0, 391, 104);
		loginIcon.setIcon(new ImageIcon("C:\\Users\\Stefan\\Documents\\bank-of-the-future\\work\\backend\\RIPBankDesktop\\img\\logn2.jpg"));
		desktopPane.add(loginIcon);
		
		JLabel lblSignIn = new JLabel("Sign in",SwingConstants.CENTER);
		lblSignIn.setBounds(136, 127, 136, 38);
		desktopPane.add(lblSignIn);
		lblSignIn.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblSignIn.setForeground(new Color(0, 0, 102));
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179)));
		passwordField.setBounds(136, 218, 136, 23);
		desktopPane.add(passwordField);
		
		JButton Login = new JButton("Login");
		Login.setBounds(160, 258, 89, 23);
		desktopPane.add(Login);
		
		JLabel lblPass = new JLabel("");
		lblPass.setIcon(new ImageIcon("C:\\Users\\Stefan\\Documents\\bank-of-the-future\\work\\backend\\RIPBankDesktop\\img\\key.png"));
		lblPass.setBounds(97, 218, 29, 23);
		desktopPane.add(lblPass);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Stefan\\Documents\\bank-of-the-future\\work\\backend\\RIPBankDesktop\\img\\user_2.png"));
		lblNewLabel.setBounds(97, 176, 21, 23);
		desktopPane.add(lblNewLabel);
	}
}
