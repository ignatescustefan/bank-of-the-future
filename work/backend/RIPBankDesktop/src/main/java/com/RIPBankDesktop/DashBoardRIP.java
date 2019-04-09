package com.RIPBankDesktop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DashBoardRIP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7456512844086031995L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoardRIP frame = new DashBoardRIP();
					GraphicsEnvironment localEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
					GraphicsDevice defaultDevice = localEnvironment.getDefaultScreenDevice();
					defaultDevice.setFullScreenWindow(frame);
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
	public DashBoardRIP() {
		super("RIP Bank");
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1376, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bannerLabel = new JLabel("");
		bannerLabel.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/banner.png")));
		bannerLabel.setBounds(0, 0, 1200, 140);
		contentPane.add(bannerLabel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(0, 139, 200, 593);
		rightPanel.setBackground(new Color(21, 98, 114));
		contentPane.add(rightPanel);
		
		JPanel employeePanel = new JPanel();
		employeePanel.setBounds(1200, 0, 176, 140);
		employeePanel.setBackground(new Color(251, 141, 2));
		contentPane.add(employeePanel);
	}

	public boolean getThisResizable() {
		return isResizable();
	}
	public void setThisResizable(boolean resizable) {
		setResizable(resizable);
	}
}
