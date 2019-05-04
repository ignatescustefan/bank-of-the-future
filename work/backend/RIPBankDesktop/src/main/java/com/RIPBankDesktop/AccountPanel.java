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
	DefaultTableModel model;
	
    public AccountPanel(String cnp){
        super();
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

        // Append a row 
        
        
        table.setSize(820, 134);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 5, 893, 129);
        add(scrollPane);
       //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setSize(722, 154);
  //      setLocationRelativeTo(null);
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
                new AccountPanel("").setVisible(true);
            }
        });
    }
 
}