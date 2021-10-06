package crms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class CaseAssigned extends JFrame{
	
	
	//Labels
	JLabel tn,firId,filedDate,location,appName,appPhno,appAdd,complaint,accusedName,accusedAge,status
		   ,firIdv,filedDatev,locationv,appNamev,appPhnov,appAddv,complaintv,
		   accusedNamev,accusedAgev,statusv,select_msg,case_msg;
	
	//Static labels for object vlaues
	static JLabel name,id,designation;
	
	//button
	JButton home,search;
	
	//Table
	JTable table;
	JScrollPane scroll;
	
	//Panel
	JPanel caseAssignpan;
	
	//column labels for table
	String[] column= {"FirId","Date","Complaint Status"};
	
	//ComboBox
	JComboBox cases;
	
	CaseAssigned(){
		
		caseAssignpan = new JPanel();
		caseAssignpan.setBackground(Color.WHITE);
		caseAssignpan.setLayout(null);
		getContentPane().add(caseAssignpan);
		
		//Button
		home = new JButton("Home");
		search = new JButton("View case Details");
		
		home.setBounds(40,30,70,30);
		search.setBounds(1150,170,150,30);
		
		//Table Module
		DefaultTableModel dm=new DefaultTableModel();
		dm.setColumnIdentifiers(column);
		
		//Scrollpane for table
		scroll = new JScrollPane(table);
		
		//table settings
		table=new JTable();
		table.setModel(dm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("verdana ",Font.BOLD,13));
		table.setRowMargin(20);
		table.setRowHeight(27);
		table.setFillsViewportHeight(true);
		
		//Horizontal and Vertcial scrollbars
		scroll.setHorizontalScrollBarPolicy(
		                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scroll.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//ComboBox
		cases = new JComboBox();
		cases.addItem("Select case");
		cases.setBounds(1150,130,150,30);
		
		//heading label
		tn=new JLabel("Tamil Nadu Department of Police");
		tn.setFont(new Font("Times new Roman",Font.BOLD,30));
		tn.setBounds(480, 20, 600, 30);
		
		//Labels
		name = new JLabel();
		designation = new JLabel();
		id = new JLabel();
		
		firId = new JLabel("FIR ID: ");
		filedDate = new JLabel("Filed Date: ");
		location = new JLabel("Location: ");
		appName = new JLabel("Applicant Name: ");
		appPhno = new JLabel("Applicant Phone no: ");
		appAdd = new JLabel("Applicant Address: ");
		complaint = new JLabel("Complaint: ");
		accusedName = new JLabel("Accused Name: ");
		accusedAge = new JLabel("Accused Age: ");
		status = new JLabel("Status: ");
		select_msg = new JLabel("Select a case");
		case_msg = new JLabel("Case Details");
		
		firIdv = new JLabel();
		filedDatev = new JLabel();
		locationv = new JLabel();
		appNamev = new JLabel();
		appPhnov = new JLabel();
		appAddv = new JLabel();
		complaintv = new JLabel();
		accusedNamev = new JLabel();
		accusedAgev = new JLabel();
		statusv = new JLabel();
		
		//Font Settings of lables
		select_msg.setForeground(Color.RED);
		firId.setFont(new Font("Verdana", Font.BOLD,15));
		filedDate.setFont(new Font("Verdana", Font.BOLD,15));
		location.setFont(new Font("Verdana", Font.BOLD,15));
		appName.setFont(new Font("Verdana", Font.BOLD,15));
		appPhno.setFont(new Font("Verdana", Font.BOLD,15));
		appAdd.setFont(new Font("Verdana", Font.BOLD,15));
		complaint.setFont(new Font("Verdana", Font.BOLD,15));
		accusedName.setFont(new Font("Verdana", Font.BOLD,15));
		accusedAge.setFont(new Font("Verdana", Font.BOLD,15));
		status.setFont(new Font("Verdana", Font.BOLD,15));
		
		select_msg.setFont(new Font("Times new Roman",Font.ITALIC,17));
		firIdv.setFont(new Font("Times new Roman", Font.PLAIN,20));
		filedDatev.setFont(new Font("Times new Roman", Font.PLAIN,20));
		locationv.setFont(new Font("Times new Roman", Font.PLAIN,20));
		appNamev.setFont(new Font("Times new Roman", Font.PLAIN,20));
		appPhnov.setFont(new Font("Times new Roman", Font.PLAIN,20));
		appAddv.setFont(new Font("Times new Roman", Font.PLAIN,20));
		complaintv.setFont(new Font("Times new Roman", Font.PLAIN,20));
		accusedNamev.setFont(new Font("Times new Roman", Font.PLAIN,20));
		accusedAgev.setFont(new Font("Times new Roman", Font.PLAIN,20));
		statusv.setFont(new Font("Times new Roman", Font.PLAIN,20));
		name.setFont(new Font("verdana", Font.PLAIN,20));
		designation.setFont(new Font("verdana", Font.PLAIN,20));
		id.setFont(new Font("verdana", Font.PLAIN,20));
		case_msg.setFont(new Font("verdana", Font.BOLD,20));
		
		case_msg.setForeground(new Color(30,30,180));
		name.setForeground(new Color(30,30,180));
		designation.setForeground(new Color(30,30,180));
		id.setForeground(new Color(30,30,180));
		
		//visibility of labels
		firId.setVisible(false);
		filedDate.setVisible(false);
		location.setVisible(false);
		appName.setVisible(false);
		appPhno.setVisible(false);
		appAdd.setVisible(false);
		complaint.setVisible(false);
		accusedAge.setVisible(false);
		accusedName.setVisible(false);
		status.setVisible(false); 
		select_msg.setVisible(false); 
		case_msg.setVisible(false);
		
		//Setting bounds to components
		name.setBounds(100,90,200,27);
		designation.setBounds(370,90,200,27);
		id.setBounds(530,90,200,27);
		select_msg.setBounds(1165,170,150,30);
		firId.setBounds(100,300,150,30);
		filedDate.setBounds(100,370,150,30);
		location.setBounds(100,440,150,30);
		appName.setBounds(100,510,150,30);
		appPhno.setBounds(100,580,200,30);
		appAdd.setBounds(100,650,250,30);
		complaint.setBounds(700,300,150,30);
		accusedAge.setBounds(700,380,150,30);
		accusedName.setBounds(700,450,150,30);
		status.setBounds(700,510,150,30);
		
		firIdv.setBounds(300,300,150,30);
		filedDatev.setBounds(300,370,150,30);
		locationv.setBounds(300,440,250,30);
		appNamev.setBounds(300,510,150,30);
		appPhnov.setBounds(300,580,200,30);
		appAddv.setBounds(300,650,400,30);
		complaintv.setBounds(850,300,500,30);
		accusedAgev.setBounds(850,380,150,30);
		accusedNamev.setBounds(850,450,150,30);
		statusv.setBounds(850,510,150,30);
		case_msg.setBounds(100,250,250,30);
		
		
		//adding components to Panel
		caseAssignpan.add(firId);
		caseAssignpan.add(filedDate);
		caseAssignpan.add(location);
		caseAssignpan.add(appName);
		caseAssignpan.add(appPhno);
		caseAssignpan.add(appAdd);
		caseAssignpan.add(complaint);
		caseAssignpan.add(accusedName);
		caseAssignpan.add(accusedAge);
		caseAssignpan.add(status);
		caseAssignpan.add(cases);
		caseAssignpan.add(home);
		caseAssignpan.add(search);
		caseAssignpan.add(tn);
		caseAssignpan.add(firIdv);
		caseAssignpan.add(filedDatev);
		caseAssignpan.add(locationv);
		caseAssignpan.add(appNamev);
		caseAssignpan.add(appPhnov);
		caseAssignpan.add(appAddv);
		caseAssignpan.add(complaintv);
		caseAssignpan.add(accusedNamev);
		caseAssignpan.add(accusedAgev);
		caseAssignpan.add(statusv);
		caseAssignpan.add(select_msg);
		caseAssignpan.add(name);
		caseAssignpan.add(designation);
		caseAssignpan.add(id);
		caseAssignpan.add(case_msg);
		
        
		//adding values to cases comboBox
		try 
		{
			Connection conn = DatabaseConnection.getConnected();
			String query ="select * from caseassigned";
			
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet data = pst.executeQuery();
			while(data.next())
			{
				cases.addItem(data.getString("firid"));
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Database not Connected");
		}
        
		//Setting values to Table
		try {
					
				String date="";
				String firid="";
				String status="";
					
				Connection conn  = DatabaseConnection.getConnected();
				String q="select * from caseassigned";
				Statement ps=conn.createStatement();
				JScrollPane scroll1 = new JScrollPane(table);
				ResultSet rs=ps.executeQuery(q);
				dm.addRow(column);
					
				while(rs.next())
				{
					firid=rs.getString("firid");
					date=rs.getString("assigneddate");
					status=rs.getString("status");
					String tbData[] = {firid,date,status}; 
					dm.addRow(tbData);
					conn.setAutoCommit(true);	
				}
					
				caseAssignpan.add(scroll1);
				caseAssignpan.add(table);
				table.setBounds(100, 140, 1000, 400);
				table.setRowHeight(33); 
				table.setFont(new Font("verdana ",Font.PLAIN,13));
				table.setRowMargin(20);
				conn.close();
				
			}
			catch(Exception ex) 
			{
				JOptionPane.showMessageDialog(rootPane, "Database not Connected");
			}
						
		
		//event Listeners
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				firId.setVisible(false);
				filedDate.setVisible(false);
				location.setVisible(false);
				appName.setVisible(false);
				appPhno.setVisible(false);
				appAdd.setVisible(false);
				complaint.setVisible(false);
				accusedAge.setVisible(false);
				accusedName.setVisible(false);
				status.setVisible(false); 
				select_msg.setVisible(false); 
				
				firIdv.setVisible(false);
   			    filedDatev.setVisible(false);
   			    locationv.setVisible(false);
   			    appNamev.setVisible(false);
   			    appPhnov.setVisible(false);
   			    appAddv.setVisible(false);
   			    complaintv.setVisible(false);
   			    accusedAgev.setVisible(false);
   			    accusedNamev.setVisible(false);
   			    statusv.setVisible(false); 
   			    case_msg.setVisible(false);
   			    
   			    cases.setSelectedItem("Select case");
				
				LowLevelPoliceOfficer.homeDisplay();
			}
		});
		
		//Search button
        search.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e)
        	{
        		String caseId = (String) cases.getSelectedItem();
        		if(!caseId.equals("Select case"))
        		{
        			try
            		{
            			Connection conn = DatabaseConnection.getConnected();
            			String query ="select * from fir where firId=? ";
						
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,caseId);
						
						ResultSet data = pst.executeQuery();
						if(data==null)
						{
							JOptionPane.showMessageDialog(rootPane, "No datas found");
						}
						while(data.next())
						{
						
							 //Setting values to case detail value labels
							 firIdv.setText(data.getString("firid"));  
							 filedDatev.setText(data.getString("fileddate"));
			    			 locationv.setText(data.getString("location"));
			    			 complaintv.setText(data.getString("complaint"));
			    			 accusedNamev.setText(data.getString("accusedname"));	
			    			 appNamev.setText(data.getString("applicantname"));
			    			 appPhnov.setText(data.getString("applicantphno"));
			    			 appAddv.setText(data.getString("applicantaddress"));
			    			 accusedAgev.setText(data.getString("accusedage"));
			    			 statusv.setText(data.getString("status"));
			    			 
			    			 //Setting visibilities on to case detail labels
			    			 firId.setVisible(true);
			    			 filedDate.setVisible(true);
			    			 location.setVisible(true);
			    			 appName.setVisible(true);
			    			 appPhno.setVisible(true);
			    			 appAdd.setVisible(true);
			    			 complaint.setVisible(true);
			    			 accusedAge.setVisible(true);
			    			 accusedName.setVisible(true);
			    			 status.setVisible(true); 
			    			 case_msg.setVisible(true);
			    			 
			    			 //Setting visibilities on to case detail values
			    			 firIdv.setVisible(true);
			    			 filedDatev.setVisible(true);
			    			 locationv.setVisible(true);
			    			 appNamev.setVisible(true);
			    			 appPhnov.setVisible(true);
			    			 appAddv.setVisible(true);
			    			 complaintv.setVisible(true);
			    			 accusedAgev.setVisible(true);
			    			 accusedNamev.setVisible(true);
			    			 statusv.setVisible(true); 
			    			 
			    			 select_msg.setVisible(false);
						}
            			
            		}
            		catch(Exception e1)
            		{
            			JOptionPane.showMessageDialog(rootPane, "Database not Connected");
            		}
        		}
        		else
        		{
        			select_msg.setVisible(true);
        		}
        		
        	}
        });
        
	}
	
	//getting Officer data from the OfficerBean class reference
	 public static void getData(OfficerBean obj)
 	{
 		name.setText(obj.getOfficerName());
 		id.setText(obj.getOfficerID());
 		designation.setText(obj.getDesignation());
 	}
	
}
