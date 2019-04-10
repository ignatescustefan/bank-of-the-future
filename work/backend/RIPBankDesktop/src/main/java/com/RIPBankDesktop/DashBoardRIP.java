package com.RIPBankDesktop;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashBoardRIP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7456512844086031995L;
	private JPanel contentPane;
	JLabel lblName = new JLabel("");
	/**
	 * Create the frame.
	 */
	public DashBoardRIP(final Employee angajat) {
		
		super("RIP Bank");
		
		System.out.println("dashboard angajat "+ angajat.toString());
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1376, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//JLabel lblName = new JLabel("");
		JLabel bannerLabel = new JLabel("");
		bannerLabel.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/banner.png")));
		bannerLabel.setBounds(0, 0, 1200, 140);
		contentPane.add(bannerLabel);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(0, 139, 200, 593);
		rightPanel.setBackground(new Color(21, 98, 114));
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		JButton btnSetariCont = new JButton("Detalii cont");
		btnSetariCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(angajat.getNume());
			}
		});
		btnSetariCont.setBounds(58, 49, 89, 23);
		rightPanel.add(btnSetariCont);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setVisible(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel loginPanel=new LoginPanel();
				loginPanel.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(58, 494, 89, 23);
		rightPanel.add(btnLogout);
		
		
		lblName.setBounds(10, 89, 180, 30);
		rightPanel.add(lblName);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 129, 180, 30);
		rightPanel.add(label);
		
		JPanel employeePanel = new JPanel();
		employeePanel.setBounds(1200, 0, 160, 140);
		employeePanel.setBackground(new Color(251, 141, 2));
		contentPane.add(employeePanel);
		employeePanel.setLayout(null);
		
		JLabel employeeLbl = new JLabel("");
		employeeLbl.setBounds(38, 11, 83, 83);
		employeePanel.add(employeeLbl);
		employeeLbl.setIcon(new ImageIcon(DashBoardRIP.class.getResource("/img/manager.png")));
		
		JLabel employeeNameLbl = new JLabel("",SwingConstants.CENTER);
		employeeNameLbl.setBounds(10, 96, 140, 33);
		employeePanel.add(employeeNameLbl);
		employeeNameLbl.setText(angajat.getNume()+" "+angajat.getPrenume());
		
	}

	public boolean getThisResizable() {
		return isResizable();
	}
	public void setThisResizable(boolean resizable) {
		setResizable(resizable);
	}
}
