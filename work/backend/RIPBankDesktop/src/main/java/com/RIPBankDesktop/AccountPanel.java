package com.RIPBankDesktop;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ripbank.response.Account;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
/**
 * A Swing program demonstrates how to use a custom renderer for
 * all column headers of a JTable component.
 * @author www.codejava.net
 *
 */
public class AccountPanel extends JPanel{
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public DefaultTableModel model;
	private JPanel panel;
	private JButton btnAdaugaCont;
	private JButton btnTranzactie;
	public JButton btnAnuleaza;
	private AddAccount addAccount;
	public String cnp;
	private TransactionPanel transactionPanel;
    public AccountPanel(){
        super();
        //this.cnp=cnp;
        setBounds(10, 285, 893, 134);
        setVisible(true);
        setLayout(null);
        model = new DefaultTableModel(); 
        table = new JTable(model);
        table.setDefaultEditor(Object.class, null);
        // Create a couple of columns 
        model.addColumn("IBAN"); 
        model.addColumn("Tip Cont"); 
        model.addColumn("Sold");
        transactionPanel=new TransactionPanel();
        transactionPanel.setBounds(0, 62, 893, 72);
        transactionPanel.btnAnulare.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		transactionPanel.setVisible(false);
        		panel.setVisible(true);
        	}
        });
        transactionPanel.setVisible(false);
        addAccount = new AddAccount();
        addAccount.btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		addAccount.cnp=cnp;
        		addAccount.executeAddAccount();
        		accountImport(cnp);
        		addAccount.setVisible(false);
        		
        	}
        });
        addAccount.btnAnuleaza.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		panel.setVisible(true);
        		addAccount.setVisible(false);
        	}
        });
        addAccount.setVisible(false);
        add(addAccount);
        add(transactionPanel);

        // Append a row 
        
        
        table.setSize(820, 60);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 5, 893, 54);
        add(scrollPane);
        
        panel = new JPanel();
        panel.setBounds(0, 57, 893, 77);
        add(panel);
        panel.setLayout(null);
        
        btnAdaugaCont = new JButton("Adauga cont");
        btnAdaugaCont.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		panel.setVisible(false);
        		addAccount.setVisible(true);
        	}
        });
        btnAdaugaCont.setBounds(0, 11, 107, 23);
        panel.add(btnAdaugaCont);
        
        btnTranzactie = new JButton("Tranzactie");
        btnTranzactie.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		transactionPanel.setVisible(true);
        		addAccount.setVisible(false);
        		panel.setVisible(false);
        	}
        });
        btnTranzactie.setBounds(0, 45, 107, 23);
        panel.add(btnTranzactie);
        
        btnAnuleaza = new JButton("Anuleaza");
        btnAnuleaza.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        	}
        });
        
        btnAnuleaza.setBounds(804, 45, 89, 23);
        panel.add(btnAnuleaza);
       }
    
    public void accountImport(String cnp) {
    	model.setRowCount(0);
    	Account a = new Account(cnp);
    	Response responseInformation = a.extractAccountInformation();
		
    	System.out.println(responseInformation);
    	
    	String informationAsString = responseInformation.readEntity(String.class);
		
    	System.out.println(informationAsString);
    	JSONObject jsonInformation = new JSONObject(informationAsString);
		JSONArray jsonAccount = (JSONArray) jsonInformation.get("account");
		System.out.println(jsonAccount);
		
		
		for(int i=0;i<jsonAccount.length();i++) {
			JSONObject item=(JSONObject) jsonAccount.get(i);			
			//System.out.println(item);
			
			
			String iban=item.getString("iban");
			String tipCont=item.getString("tipCont");
			double sold= item.getDouble("sold");
				
			model.addRow(new Object[]{iban, tipCont,sold});
	        
		}
		
    	
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AccountPanel().setVisible(true);
            }
        });
    }
}