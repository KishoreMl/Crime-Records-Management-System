package crms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import crms.DatabaseConnection;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AssignCase {

	JPanel assignpan;
	//Labels
	JLabel head;
	JLabel head2;
	JLabel head3,image,case_msg,officer_msg;
	
	//Buttons
	JButton home,assign;
	
	//Drop-down boxes
	JComboBox cases,officer;
	
	//date chooser
	JDateChooser tdate;
	
	AssignCase()
	{
		//main panel
		assignpan = new JPanel();
		assignpan.setBackground(Color.white);
		assignpan.setLayout(null);
		
		//Labels
		head = new JLabel("Tamilnadu Department of Police");
		head2 = new JLabel("Pending cases");
		head3 = new JLabel("List of Police officers");
		case_msg = new JLabel("Select a case");
		officer_msg  = new JLabel("Select an officer");
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		
		case_msg.setForeground(Color.RED);
		officer_msg.setForeground(Color.RED);
		
		case_msg.setVisible(false);
		officer_msg.setVisible(false);
		
		head.setFont(new Font("Times new roman", Font.BOLD,30));
		head2.setFont(new Font("Times new roman", Font.PLAIN,20));
		head3.setFont(new Font("Times new roman", Font.PLAIN,20));
		case_msg.setFont(new Font("Times new roman", Font.ITALIC,17));
		officer_msg.setFont(new Font("Times new roman", Font.ITALIC,17));
		
		//Buttons
		home = new JButton("Home");
		assign = new JButton("Assign case");
		
		//drop down list box
		cases = new JComboBox();
		officer = new JComboBox();
		
		//datechooser
		tdate = new JDateChooser();
		
		//heading labels
		head.setBounds(550,30,500,40);
		head2.setBounds(500, 140, 150, 30);
		head3.setBounds(800, 140, 200, 30);
		case_msg.setBounds(500, 220, 180, 30);
		officer_msg.setBounds(800, 220, 180, 30);
		
		//image
		image.setBounds(40,100,180,180);
		
		//home-button
		home.setBounds(70,30,80,30);
		
		//combobox and  button
		cases.setBounds(500, 180, 200, 30);
		cases.addItem("Select a FIR");
		officer.setBounds(800, 180, 200, 30);
		officer.addItem("Select Officer");
		assign.setBounds(640, 300, 200, 30);
		
		assignpan.add(head);
		assignpan.add(home);
		assignpan.add(cases);
		assignpan.add(head2);
		assignpan.add(head3);
		assignpan.add(assign);
		assignpan.add(officer);
		assignpan.add(image);
		assignpan.add(case_msg);
		assignpan.add(officer_msg);
		
		//adding Components to cases ComboBox
		try {
			
			Connection conn = DatabaseConnection.getConnected();
			String query ="select * from fir where status=? ";
			
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,"Pending");
			
			ResultSet data = pst.executeQuery();
			while(data.next())
			{
				cases.addItem(data.getString("firid"));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//Adding Components to officer ComboBox
		try {
			
			Connection conn = DatabaseConnection.getConnected();
			String query ="select * from officers";
			Statement st = conn.createStatement();
			ResultSet data = st.executeQuery(query);
			while(data.next())
			{
				String offi=data.getString("officername");
				String id = data.getString("officerid");
				if(id.charAt(3)=='i' || id.charAt(3)=='I')
				{
					officer.addItem(offi);
				}
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		//Event Listeners
		
		//Home Button
		home.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 officer.setSelectedItem("Select Officer");
				 cases.setSelectedItem("Select a FIR");
				 case_msg.setVisible(false);
			     officer_msg.setVisible(false);
				 HPofficerWindow.homeDisplay();
			 }
		 });
		
		//Assign button
		assign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String firid = (String) cases.getSelectedItem();
				String off = (String) officer.getSelectedItem();
				String offid="";
				
				if(!cases.getSelectedItem().equals("Select a FIR"))
				{
					if(!officer.getSelectedItem().equals("Select Officer"))
					{
						//getting officerId value form officers table
						try 
						{
							Connection conn = DatabaseConnection.getConnected();
							String query ="select * from officers where officername=? ";
							PreparedStatement pst = conn.prepareStatement(query);
							pst.setString(1, off);
							ResultSet data = pst.executeQuery();
							while(data.next())
							{	
								offid=data.getString("officerid");
							}
							
							//Inserting values in caseAssigned Table
							try
							{
								Connection conc = DatabaseConnection.getConnected();
								PreparedStatement pst1 = conn.prepareCall("insert into caseassigned values(?,?,?,?,?)");
								String tdat="";
								
								//setting current date to date  chooser
								SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
								Date date = new Date();
								sdf.format(date);
								tdate.setDate(date);
								tdat=sdf.format(tdate.getDate());
								
								
								
								pst1.setString(1, off);
								pst1.setString(2, offid);
								pst1.setString(3, firid);
								pst1.setString(4, tdat);
								pst1.setString(5, "assigned");
								
								pst1.executeUpdate();
			    				conc.setAutoCommit(true);
			    				conc.close();
			    				JOptionPane.showMessageDialog(assign, "Case Assigned");
			    				
			    				//Updating fir status to assigned in FIR Table
			    				try 
								{
									Connection con = DatabaseConnection.getConnected();
									PreparedStatement pst2 = conn.prepareCall("UPDATE fir SET status=? where firid=?");
									pst2.setString(1,"assigned");
									pst2.setString(2,firid);
									pst2.executeUpdate();
				    				con.setAutoCommit(true);
				    				con.close();
								}
								catch(Exception e1)
								{
									JOptionPane.showMessageDialog(assign, "Database not connected e1"+e1);
								}
								
							}
							
							catch(Exception e2)
							{
								JOptionPane.showMessageDialog(assign, "Database not connected e2 "+e2);
								
							} 
							
						}
						catch(Exception e3)
						{
							JOptionPane.showMessageDialog(assign, "Database not connected e3"+e3);
							
						}
							
					}
					else
					{
						//displaying selection error message
						officer_msg.setVisible(true);
					}
					
				}
				else
				{
					//displaying selection error message
					case_msg.setVisible(true);
				}
				
			}
		});
		
		
		
	}
}
