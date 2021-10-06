package crms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;


public class UpdateOfficer extends JFrame {

	
	//Textfields
	JTextField offName,age,phno,password;
	
	//Labels
	JLabel loffName,loffId,lpassword,ldesg,lstation,lage,lphno,head,head2,name_msg,phno_msg,age_msg,image;
	
	//Button
	JButton update,search,home;
	
	//ComboBox
	JComboBox station,desig,offId;
	
	static JPanel updpan;
	
	UpdateOfficer()
	{
		updpan = new JPanel();
		updpan.setLayout(null);
		updpan.setBackground(Color.WHITE);
		updpan.setVisible(true);
		
		//ComboBox
		station  = new JComboBox();
		desig = new JComboBox();
		offId = new JComboBox();
				
		
		//Textfield
		offName = new JTextField();
		age = new JTextField();
		phno = new JTextField();
		password = new JTextField();
		
		offId.setBounds(650, 150, 220, 40);
		offName.setBounds(650, 200, 220, 40);
		password.setBounds(650,250,220,40);
		desig.setBounds(650, 300,220, 40);
		age.setBounds(650,350,220, 40);
		station.setBounds(650, 400,220, 40);
		phno.setBounds(650,450,220,40);
		
		//Button
		home = new JButton("Home");
		update = new JButton("Update");
		search = new JButton("Search");
		
		home.setForeground(Color.WHITE);
		home.setBackground(new Color(10,150,120));
		
		home.setBounds(60,30,80,30);
		search.setBounds(880, 150, 140, 30);
		update.setBounds(650, 550, 100, 30);
		
		//heading
		head = new JLabel("TamilNadu Police Department");
		head.setFont(new Font("Times new roman",Font.BOLD,30));
		head.setBounds(530,0,500,30);
		head2 = new JLabel("Admin Panel");
		head2.setBounds(640,50,200,30);
		head2.setFont(new Font("Times new roman",Font.PLAIN,25));

		
		//labels
		loffName = new JLabel("Officer Name");
		loffId = new JLabel("Officer ID");
		lpassword = new JLabel("Password");
		ldesg = new JLabel("Designation");
		lstation = new JLabel("Station");
		lage = new JLabel("Age");
		lphno = new JLabel("Phone Number");
		name_msg = new JLabel("Invalid Name");
		phno_msg = new JLabel("Invalid Phone No");
		age_msg = new JLabel("Invalid Age");
		
		loffId.setBounds(450, 150, 140, 40);
		loffName.setBounds(450, 200, 140, 40);
		lpassword.setBounds(450,250 ,250,40);
		ldesg.setBounds(450,300, 140, 40);
		lage.setBounds(450,350, 140, 40);
		lstation.setBounds(450,400, 140, 40);
		lphno.setBounds(450,450,140,40);
		
		name_msg.setBounds(880,200,140,30);
		age_msg.setBounds(880,350,140,30);
		phno_msg.setBounds(880,450,140,30);
		
		
		loffName.setFont(new Font("Times new roman", Font.PLAIN,20));
		lpassword.setFont(new Font("Times new roman", Font.PLAIN,20));
		lage.setFont(new Font("Times new roman", Font.PLAIN,20));
		loffId.setFont(new Font("Times new roman", Font.PLAIN,20));
		ldesg.setFont(new Font("Times new roman", Font.PLAIN,20));
		lstation.setFont(new Font("Times new roman", Font.PLAIN,20));
		lphno.setFont(new Font("Times new roman", Font.PLAIN,20));
		
		name_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
		age_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
		phno_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
		
		name_msg.setForeground(Color.RED);
		age_msg.setForeground(Color.RED);
		phno_msg.setForeground(Color.RED);
		
		name_msg.setVisible(false);
		age_msg.setVisible(false);
		phno_msg.setVisible(false);
		
		
		//image
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		image.setBounds(20,100,180,180);
		
		
		//adding Items to ComboBox
		offId.addItem("Select ID");
		
		station.addItem("Select Station");
	   	station.addItem("B2-RS.Puram");
	   	station.addItem("B1-Selvauram");
	   	station.addItem("A2-Vadavalli");
	   	station.addItem("S2-Townhall");
	   	station.addItem("A1-Singanallur");
	   	station.addItem("B2-Gandhipuram");
	   	
	   	desig.addItem("Select Designation");
	   	desig.addItem("Dept.Commissioner");
	   	desig.addItem("Asst..Commissioner");
	   	desig.addItem("Inspector");
	   	desig.addItem("Sub-Inspector");
	   	desig.addItem("Constable");
	   	
	   	updpan.add(age);
	   	updpan.add(phno);
	   	updpan.add(password);
	   	updpan.add(offName);
	   	updpan.add(desig);
	   	updpan.add(station);
	   	updpan.add(offId);
	   	updpan.add(lpassword);
	   	updpan.add(loffName);
	   	updpan.add(lage);
	   	updpan.add(lstation);
	   	updpan.add(ldesg);
	   	updpan.add(lphno);
	   	updpan.add(loffId);
	   	updpan.add(image);
	   	updpan.add(age_msg);
	   	updpan.add(phno_msg);
	   	updpan.add(name_msg);
	   	updpan.add(home);
	   	updpan.add(search);
	   	updpan.add(update);
	   	updpan.add(head2);
	   	updpan.add(head);
		
	   	//adding Items to Officer ID ComboBox
	   	try
	   	{
	   		Connection conn = DatabaseConnection.getConnected();
	   		String query ="select * from officers";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet data = pst.executeQuery();
			while(data.next())
			{
				offId.addItem(data.getString("officerid"));
			}
	   	}
	   	catch(Exception e)
	   	{
	   		JOptionPane.showMessageDialog(rootPane, "Database not connected"+e);
	   	}
	   	
	   	
	   	//EventListeners
		//search button
		search.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String id = (String) offId.getSelectedItem();
				 try
				 {
					 Connection conn = DatabaseConnection.getConnected(); 
					 String query ="select * from officers where officerid=? ";
						
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,id);
						
						ResultSet data = pst.executeQuery();
						
						while(data.next())
						{
							
							 offId.setSelectedItem(data.getString("officerid"));
							 desig.setSelectedItem(data.getString("designation"));
							 station.setSelectedItem(data.getString("station"));
							 offName.setText(data.getString("officername"));
							 age.setText(data.getString("age"));
							 phno.setText(data.getString("phno"));
							 password.setText(data.getString("password"));	 
						}
					 
				 }
				 catch(Exception e1)
				 {
					 JOptionPane.showMessageDialog(rootPane, "Database not connected"+e1);
				 }
			}
		});
	   	
		update.addActionListener(new ActionListener()
		{	
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String Offnam = offName.getText();
				String pword = password.getText();
				String desi = (String) desig.getSelectedItem();
				String Offid = (String) offId.getSelectedItem();
				String ag = age.getText();
				String tstation = (String) station.getSelectedItem();
				String tphno = phno.getText();
				
				try
				{
					if(validation(Offnam,ag,tphno))
					{
						Connection conn = DatabaseConnection.getConnected();
						PreparedStatement pst = conn.prepareCall("insert into officers values(?,?,?,?,?,?,?)");
			    			
		    			int fage = Integer.parseInt(ag);
		    			long ph = Long.parseLong(tphno);
		    			
		    			pst.setString(1, Offnam);
		    			pst.setString(2, pword);
		    			pst.setInt(3, fage);
		    			pst.setString(4, Offid);
		    			pst.setString(5, desi);
		    			pst.setString(6,tstation);
		    			pst.setLong(7, ph);

		    			pst.executeUpdate();	
		    			conn.setAutoCommit(true);
		    			conn.close();
		    			
		    			offName.setText(" ");
		    			password.setText(" ");
		    			phno.setText(" ");
		    			age.setText(" ");
		    			
		    			station.setSelectedItem("Select Station");
		    			desig.setSelectedItem("Select Designation");
		    			offId.setSelectedItem("Select ID");
		    			
		    			name_msg.setVisible(false);
		    			age_msg.setVisible(false);
		    			phno_msg.setVisible(false);
		    			
		    			//Success message
	    				JOptionPane.showMessageDialog(rootPane, "Updated Successfully");
		    			
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane, "Check the Values entered");
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(rootPane, "Registered Successfully");
				}
				
			}
		});
		
		//home button
		home.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				offName.setText(" ");
    			password.setText(" ");
    			phno.setText(" ");
    			
    			station.setSelectedItem("Select Station");
    			desig.setSelectedItem("Select Designation");
    			offId.setSelectedItem("Select ID");
    			
    			name_msg.setVisible(false);
    			age_msg.setVisible(false);
    			phno_msg.setVisible(false);
    			
				 AdminHome.AdminDisplay();
			}
		});
		
	}
	
	public boolean validation(String name,String age,String phno)
	{
		int flag=0;
		
		if(!checkName(name))
		{
			name_msg.setVisible(true);
			flag=1;
		}
		
		if(!checkAge(age))
		{
			age_msg.setVisible(true);
			flag=1;
		}
		if(!checkPhno(phno))
		{
			phno_msg.setVisible(true);
			flag=1;
		}
		if(flag==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//check for valid name
	public boolean checkName(String name)
	{
		if( Pattern.matches("[a-zA-z &&[^0-9]]*$",name))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	//check for valid age
	public boolean checkAge(String age)
	{
		if(Pattern.matches("[0-9 &&[^a-zA-z]]*$",age))
		{
			int a=Integer.parseInt(age);
			if(a>18 || a<110)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	
	//check for valid Phno number
	public boolean checkPhno(String phno)
	{
		int flag=0;
		
		if(Pattern.matches("[0-9 &&[^a-zA-z]]*$",phno))
		{
			if(phno.length()<10 || phno.length()>10)
			{
				phno_msg.setVisible(true);
				flag=1;
			}
		}
		else
		{
			return false;
		}
		
		if(flag==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
}
