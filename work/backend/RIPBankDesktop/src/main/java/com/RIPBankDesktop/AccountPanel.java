package com.RIPBankDesktop;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
 
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
     
    public AccountPanel(){
        super();
        setBounds(10, 285, 820, 134);
        setVisible(true);
		//setLayout(null);
        // constructs the table
        /*
        String[] columnNames = new String[] {"IBAN", "Tip Cont", "Sold"};
        String[][] rowData = new String[][] {
        };
        */
        setLayout(null);
                 
       // table = new JTable(rowData, columnNames);
       // table.getTableHeader().setDefaultRenderer(new AccountPanel());
        DefaultTableModel model = new DefaultTableModel(); 
        JTable table = new JTable(model); 

        // Create a couple of columns 
        model.addColumn("Col1"); 
        model.addColumn("Col2"); 

        // Append a row 
        model.addRow(new Object[]{"v1", "v2"});
        model.addRow(new Object[]{"v1", "v2"});
        model.addRow(new Object[]{"v1", "v2"});
        model.addRow(new Object[]{"v1", "v2"});
        
        table.setSize(820, 134);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 5, 820, 129);
        add(scrollPane);
       //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setSize(722, 154);
  //      setLocationRelativeTo(null);
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AccountPanel().setVisible(true);
            }
        });
    }
 
}