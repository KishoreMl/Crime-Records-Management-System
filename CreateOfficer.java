package crms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;

public class CreateOfficer extends JFrame {

			//Textfields
			JTextField name,pass,id,age,phno;
			
			//Labels
			JLabel username,password,head2,lid,ldesg,lstation,head,lphno,lage,name_msg,age_msg,id_msg,phno_msg,image
					,station_msg,desg_msg;

			//button	
			JButton submit,home;
			
			//Combo box
			JComboBox station,desig;
			
			static JPanel Offcreg;
			
			
		CreateOfficer()
		{
			Offcreg = new JPanel();
			Offcreg.setLayout(null);
			Offcreg.setBackground(Color.WHITE);
			Offcreg.setVisible(true);
			
			//TextFields
			name = new JTextField();
			pass = new JTextField();
			id = new JTextField();
			phno = new JTextField();
			age = new JTextField();
			
			//ComboBox
			station  = new JComboBox();
			desig = new JComboBox();
			
			//adding components to ComboBox
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
			
		   	//heading
		   	head = new JLabel("TamilNadu Police Department");
			head.setFont(new Font("Times new roman",Font.BOLD,30));
			head.setBounds(530,0,500,30);
			head2 = new JLabel("Admin Panel");
			head2.setBounds(660,50,200,30);
			head2.setFont(new Font("Times new roman",Font.PLAIN,25));
		   	
		   	//Labels
			username = new JLabel("Officer name");
			password = new JLabel("Password");
			lid = new JLabel("Officer ID");
			lage = new JLabel("Age");
			ldesg = new JLabel("Designation");
			lstation = new JLabel("Station");
			lphno = new JLabel("Phone number");
			name_msg = new JLabel("Invalid Name");
			age_msg = new JLabel("Invalid Age");
			id_msg = new JLabel("Inavlid ID");
			phno_msg = new JLabel("Invalid Phone number");
			station_msg = new JLabel("Select a Station");
			desg_msg = new JLabel("Select a Designation");
			
			name_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
			age_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
			id_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
			phno_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
			desg_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
			station_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
			
			name_msg.setForeground(Color.RED);
			age_msg.setForeground(Color.RED);
			id_msg.setForeground(Color.RED);
			phno_msg.setForeground(Color.RED);
			station_msg.setForeground(Color.RED);
			desg_msg.setForeground(Color.RED);
			
			//image
			image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
			image.setBounds(20,100,180,180);
			
			name_msg.setVisible(false);
			age_msg.setVisible(false);
			id_msg.setVisible(false);
			phno_msg.setVisible(false);
			station_msg.setVisible(false);
			desg_msg.setVisible(false);
			
			//button
			submit = new JButton("submit");
			home = new JButton("Home");
			
			submit.setBounds(560, 530, 100, 30);
			home.setBounds(60,30,90,30);
			
			home.setForeground(Color.WHITE);
			home.setBackground(new Color(10,150,120));
			
			//TextFields
			name.setBounds(650, 150, 220, 40);
			pass.setBounds(650, 200, 220, 40);
			age.setBounds(650,250,220,40);
			id.setBounds(650, 300,220, 40);
			desig.setBounds(650,350,220, 40);
			station.setBounds(650, 400,220, 40);
			phno.setBounds(650,450,220,40);
			
			
			//Labels
			username.setBounds(450,150,140, 40);
			password.setBounds(450,200, 140, 40);
			lage.setBounds(450,250,250,40);
			lid.setBounds(450,300,140, 40);
			ldesg.setBounds(450,350,140,40);
			lstation.setBounds(450,400,140, 40);
			lphno.setBounds(450,450,140,40);
			
			name_msg.setBounds(880,150,140,30);
			age_msg.setBounds(880,250,140,30);
			phno_msg.setBounds(880,450,140,30);
			id_msg.setBounds(880,300,140,30);
			station_msg.setBounds(880,400,140,30);
			desg_msg.setBounds(880,350,140,30);
			
			
			username.setFont(new Font("Times new roman", Font.PLAIN,20));
			password.setFont(new Font("Times new roman", Font.PLAIN,20));
			lage.setFont(new Font("Times new roman", Font.PLAIN,20));
			lid.setFont(new Font("Times new roman", Font.PLAIN,20));
			ldesg.setFont(new Font("Times new roman", Font.PLAIN,20));
			lstation.setFont(new Font("Times new roman", Font.PLAIN,20));
			lphno.setFont(new Font("Times new roman", Font.PLAIN,20));
			
		
			Offcreg.add(age);
			Offcreg.add(desig);
			Offcreg.add(name);
			Offcreg.add(pass);
			Offcreg.add(id);
			Offcreg.add(station);
			Offcreg.add(username);
			Offcreg.add(password);
			Offcreg.add(lid);
			Offcreg.add(ldesg);
			Offcreg.add(lphno);
			Offcreg.add(phno);
			Offcreg.add(lstation);
			Offcreg.add(submit);
			Offcreg.add(name_msg);
			Offcreg.add(age_msg);
			Offcreg.add(lage);
			Offcreg.add(id_msg);
			Offcreg.add(phno_msg);
			Offcreg.add(station_msg);
			Offcreg.add(desg_msg);
			Offcreg.add(home);
			Offcreg.add(image);
			Offcreg.add(head);
			Offcreg.add(head2);
			
			
			
			//Event Listeners
			submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String Offname = name.getText();
					String pword = password.getText();
					String desi = (String) desig.getSelectedItem();
					String Offid = id.getText();
					String ag = age.getText();
					String tstation = (String) station.getSelectedItem();
					String tphno = phno.getText();
					
					if(desi.equals("Select Designation"))
					{
						desg_msg.setVisible(true);
					}
					if(tstation.equals("Select Station"))
					{
						station_msg.setVisible(true);
					}
					else
					{
						try
						{
							if(validation(Offname,Offid,ag,tphno))
							{
								Connection conn = DatabaseConnection.getConnected();
								PreparedStatement pst = conn.prepareCall("insert into officers values(?,?,?,?,?,?,?)");
					    			
				    			int fage = Integer.parseInt(ag);
				    			long ph = Long.parseLong(tphno);
				    			
				    			pst.setString(1, Offname);
				    			pst.setString(2, pword);
				    			pst.setInt(3, fage);
				    			pst.setString(4, Offid);
				    			pst.setString(5, desi);
				    			pst.setString(6,tstation);
				    			pst.setLong(7, ph);

				    			pst.executeUpdate();	
				    			conn.setAutoCommit(true);
				    			conn.close();
				    			
				    			//Success message
			    				JOptionPane.showMessageDialog(rootPane, "Registered Successfully");
				    			
				    			name.setText(" ");
				    			id.setText(" ");
				    			pass.setText(" ");
				    			phno.setText(" ");
				    			age.setText(" ");
				    			
				    			station.setSelectedItem("Select Station");
				    			desig.setSelectedItem("Select Designation");
				    			
				    			name_msg.setVisible(false);
				    			age_msg.setVisible(false);
				    			id_msg.setVisible(false);
				    			phno_msg.setVisible(false);
				    			station_msg.setVisible(false);
				    			desg_msg.setVisible(false);
								
							}
							else
							{
								JOptionPane.showMessageDialog(rootPane, "Check the Values entered");
							}
						}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(rootPane, "Database not connected"+e1);
						}
						
					}
					
					
				}
			});
			
			//home button
			home.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					name.setText(" ");
	    			id.setText(" ");
	    			pass.setText(" ");
	    			phno.setText(" ");
	    			age.setText(" ");
	    			
	    			station.setSelectedItem("Select Station");
	    			desig.setSelectedItem("Select Designation");
	    			
	    			name_msg.setVisible(false);
	    			age_msg.setVisible(false);
	    			id_msg.setVisible(false);
	    			phno_msg.setVisible(false);
	    			station_msg.setVisible(false);
	    			desg_msg.setVisible(false);
	    			
					 AdminHome.AdminDisplay();
				}
			});
	}
		
		public boolean validation(String name,String id,String age,String phno)
		{
			int flag=0;
			
			if(!checkName(name))
			{
				name_msg.setVisible(true);
				flag=1;
			}
			if(!checkID(id))
			{
				id_msg.setVisible(true);
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
		
		//check for valid age
		public boolean checkID(String id)
		{
			if(id.charAt(0)!='T')
			{
				return false;
			}
			if(id.charAt(1)!='N')
			{
				return false;
			}
			if(id.charAt(2)!='P')
			{
				return false;
			}
			if(id.charAt(3)=='H' || id.charAt(3)=='I')
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}
		
		//check for valid age
		public boolean checkPhno(String phno)
		{
			int flag=0;
			
			if(Pattern.matches("[0-9 &&[^a-zA-z]]*$",phno))
			{
				if(phno.length()<10 || phno.length()>10)
				{
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
