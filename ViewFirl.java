package crms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import crms.DatabaseConnection;
import java.sql.*;

public class ViewFirl extends JFrame{

	
	JPanel ViewPan;
	
	JButton home;
	
	JLabel ldate,lstation,lfir_id,llocation,lcname,lac_name,lap_name,lap_phno,lad,lcs,lage,head,head2,count;
	
	//Table 
	DefaultTableModel dm;
	JTable table;
	JScrollPane sc;
	
	//Column Labels for Table 
	String[] column= {"Date","Station","FIR ID","Location","ApplicantName","ApplicantAddress","ApplicantPhone",
			"Complaint","AccusedName","AccusedAge","ComplaintStatus" };
	
	ViewFirl()
	{
		 ViewPan = new JPanel();
		 ViewPan.setBackground(Color.WHITE);
		 ViewPan.setLayout(null);
		 getContentPane().add(ViewPan);
		
		 //headings
		 head = new JLabel("Tamilnadu Department of Police");
		 head2 = new JLabel("Crime Records");
		 head.setBounds(560,20,500,40);
		 head2.setBounds(660,70,200,30);
		 head.setFont(new Font("Times new roman", Font.BOLD,28));
		 head2.setFont(new Font("Times new roman", Font.PLAIN,20));
		 
		 //Table-settings
		 dm=new DefaultTableModel();
		 dm.setColumnIdentifiers(column);
		 dm.addRow(column);
		 table = new JTable();
		 table.setModel(dm);
		 table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 table.setBounds(20,150,1500,500);
		 table.setFillsViewportHeight(true);
		 table.setRowHeight(33); 
		 table.setFont(new Font("verdana ",Font.PLAIN,13));
		 table.setRowMargin(20);
		 
		 sc = new JScrollPane(table);
		
		 //Button
		 home = new JButton("Home");
		 home.setBounds(30,30,80,30);
		
		 //Labels
		 count = new JLabel();
		 count.setBounds(40,95,200,30);
		 count.setFont(new Font("Times new roman",Font.BOLD,21));
		 
		 ViewPan.add(home);
		 ViewPan.add(head);
		 ViewPan.add(head2);
		 ViewPan.add(table);
		 ViewPan.add(sc);
		 ViewPan.add(count);
		
		//Setting Table values
		try
		{
			Connection conn = DatabaseConnection.getConnected();
			Statement st = conn.createStatement();
			String query="select * from fir";
			ResultSet data = st.executeQuery(query);
			
			String date="";
			String station="";
			String firid="";
			String location="";
			String appName="";
			String appAdd="";
			String appPh="";
			String Comp="";
			String accName="";
			String accAge="";
			String status="";
			
			while(data.next())
			{
				 date = data.getString("fileddate");
				 station = data.getString("stationname");
				 firid = data.getString("firid");
				 location = data.getString("location");
				 appName = data.getString("applicantname");
				 appAdd = data.getString("applicantaddress");
				 appPh = data.getString("applicantphno");
				 Comp = data.getString("complaint");
				 accName = data.getString("accusedname");
				 accAge = data.getString("accusedage");
				 status = data.getString("status");
				
				
				 String tbData[] = {date,station,firid,location,appName,appAdd,appPh,Comp,accName,accAge,status}; 
				 dm.addRow(tbData);
				 int c = table.getRowCount()-1;
				 count.setText("No of Cases Filed: "+c);
				 
			}
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(ViewPan, "Database not connected ");
		}
		
		
		home.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
		
				 LowLevelPoliceOfficer.homeDisplay(); 
				
			 }
		 });
		
		
	}
	
	
	
}
