package crms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;

public class AdminLogin  extends JFrame{

	//Panels
	static JPanel AdminLog;
	static JPanel adminpan;
	
	//AdminHome class reference
	AdminHome adHome;
	
	//TextFields
	JTextField name;
	TextField password;
	
	//labels
	JLabel username,lpassword,head,head2,login_msg,pass_msg,image;
	
	//button
	JButton login,back;
	
	//container
	static Container co;
	
	AdminLogin()
	{
		co = HomeWindow.coMain;
		
		AdminLog = new JPanel();
		AdminLog.setLayout(null);
		AdminLog.setBackground(Color.WHITE);
		AdminLog.setVisible(true);
		
		adHome = new AdminHome();
		adminpan = adHome.home;
		
		//TextFields
		name = new JTextField();
		password = new TextField();
		password.setEchoChar('*');
		
		name.setBounds(650,290,260,40);
		password.setBounds(650,370,260,40);
		
		name.setFont(new Font("Times new roman",Font.PLAIN,17));
		password.setFont(new Font("Times new roman",Font.PLAIN,17));
		
		//heading
		head = new JLabel("TamilNadu Police Department");
		head2 = new JLabel("Admin Panel");
		head.setFont(new Font("Times new roman",Font.BOLD,30));
		head2.setFont(new Font("Times new roman",Font.PLAIN,25));
		head.setBounds(550,0,500,30);
		head2.setBounds(690,50,200,30);
		
		//Labels
		username = new JLabel("Username");
		lpassword = new JLabel("Password");
		login_msg = new JLabel("UserId Not found");
		pass_msg = new JLabel("incorrect password");
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		
		username.setBounds(490,290,170,40);
		lpassword.setBounds(490,370,150,40);
		login_msg.setBounds(930,290,170,30);
		pass_msg.setBounds(930,370,170,30);
		image.setBounds(541,40,450,300);
		
		username.setFont(new Font("Times new roman",Font.BOLD,20));
		lpassword.setFont(new Font("Times new roman",Font.BOLD,20));
		login_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
		pass_msg.setFont(new Font("Times new roman",Font.ITALIC,15));
		
		login_msg.setForeground(Color.RED);
		pass_msg.setForeground(Color.RED);
		
		login_msg.setVisible(false);
		pass_msg.setVisible(false);
		
		//buttons
		login = new JButton("Login");
		back = new JButton("Back");
		
		back.setBounds(20,20,80,30);
		login.setBounds(710,440,120,40);
				
		login.setFont(new Font("Verdana",Font.BOLD,15));
		back.setFont(new Font("Verdana",Font.BOLD,15));
		back.setBackground(new Color(10,150,120));
		login.setBackground(new Color(10,30,90));
		login.setForeground(Color.WHITE);
		back.setForeground(Color.WHITE);
		
		AdminLog.add(name);
		AdminLog.add(password);
		AdminLog.add(username);
		AdminLog.add(lpassword);
		AdminLog.add(login);
		AdminLog.add(back);
		AdminLog.add(password);
		AdminLog.add(login_msg);
		AdminLog.add(pass_msg);
		AdminLog.add(head);
		AdminLog.add(head2);
		AdminLog.add(image);
		
		//Event Listneners 
		//Login button
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String uname = name.getText();
				String pword = password.getText();
				
				try
				{
					Connection conn = DatabaseConnection.getConnected();
					PreparedStatement st = conn.prepareCall("select * from admin where name=?");
					
					st.setString(1,uname);
							
					ResultSet data = st.executeQuery();
					if(data.next())
					{
						String key=data.getString("password");
						
						if(!pword.equals(key))
						{
							pass_msg.setVisible(true);
						}
						else
						{
							
							name.setText(" ");
							password.setText(" ");
							pass_msg.setVisible(false);
							login_msg.setVisible(false);
							
							AdminLog.setVisible(false);
							adminpan.setVisible(true);
							co.add(adminpan);
							
						}
						
					}
					
					else
					{
						login_msg.setVisible(true);
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(rootPane, "Database not connected"+e1);
				}
			}
		});
		
		//back button
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				HomeWindow.HomeScreen();
			}
		});
	}
	
	public static void AdminDisplay()
	{
		AdminLog.setVisible(true);
		adminpan.setVisible(false);
		co.add(AdminLog);
	}
}
