package crms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class ViewOfficer {

	static JPanel viewpan;
	
	//button
	JButton home;
	
	//labels
	JLabel head,head2,head3;
	
	//Table 
	DefaultTableModel dm;
	JTable table;
	JScrollPane sc;
	
	//Column Labels for Table 
		String[] column= {"OfficerName","Password","Age","OfficerID","Designation","Station","Phone number"};
	
	ViewOfficer()
	{
		viewpan = new JPanel();
		viewpan.setLayout(null);
		viewpan.setBackground(Color.WHITE);
		viewpan.setVisible(true);
		
		//button
		home  = new JButton("Home");
		home.setForeground(Color.WHITE);
		home.setBackground(new Color(10,150,120));
		home.setBounds(30,30,80,30);
		
		//Heading
		head = new JLabel("TamilNadu Police Department");
		head.setFont(new Font("Times new roman",Font.BOLD,30));
		head.setBounds(530,0,500,30);
		
		head2 = new JLabel("Admin Panel");
		head2.setBounds(660,50,200,30);
		head2.setFont(new Font("Times new roman",Font.PLAIN,25));
		
		head3 = new JLabel("List of Police Officers");
		head3.setFont(new Font("verdana",Font.PLAIN,20));
		head3.setBounds(30,90,290,30);

		
		//Table-settings
		 dm=new DefaultTableModel();
		 dm.setColumnIdentifiers(column);
		 dm.addRow(column);
		 table = new JTable();
		 table.setModel(dm);
		 table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 table.setBounds(20,150,1500,500);
		 table.setFillsViewportHeight(true);
		 table.setRowHeight(37); 
		 table.setFont(new Font("verdana",Font.BOLD,13));
		 table.setRowMargin(20);
		 
		 sc = new JScrollPane(table);
		
		 
		 viewpan.add(head);
		 viewpan.add(table);
		 viewpan.add(home);
		 viewpan.add(sc);
		 viewpan.add(head2);
		 viewpan.add(head3);
		 
		  //Setting Table values
			try
			{
				Connection conn = DatabaseConnection.getConnected();
				Statement st = conn.createStatement();
				String query="select * from officers";
				ResultSet data = st.executeQuery(query);
				
				String name="";
				String password="";
				String age="";
				String id="";
				String desg="";
				String station="";
				String phno="";
				
				while(data.next())
				{
					 name = data.getString("officername");
					 station = data.getString("station");
					 password = data.getString("password");
					 id = data.getString("officerid");
					 desg = data.getString("designation");
					 phno = data.getString("phno");
					 age = data.getString("age");
					 
					 String tbData[] = {name,password,age,id,desg,station,phno}; 
					 dm.addRow(tbData);	
					 
				}
			
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(viewpan, "Database not connected "+e);
			}
		 
		 
		//EventListeners
		//home button
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				 AdminHome.AdminDisplay();
			}
		});
	}
}
