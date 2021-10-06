package crms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;

class HomeWindow extends JFrame{
	
	//Labels
	JLabel LoffcID,Lpassword,image,pass_msg,login_msg,head;
	
	//TextFields
	JTextField offcID;
	TextField password;
	
	//Buttons
	JButton login,admin;
	
	//Panels
	static JPanel main;
	static JPanel HighLevel;
	static JPanel LowLevel;
	static JPanel adminPanel;
	
	static Container coMain;
	
	//Other Class references
	HPofficerWindow Hlevel;
	LowLevelPoliceOfficer Llevel;
	AdminLogin Admin;
	static OfficerBean obj;
	
	HomeWindow() throws IOException
	{
		setVisible(true);
		setSize(700,700);
		setTitle("TamilNadu Police Department");
		
		
		coMain = getContentPane();
		
		//Main Panel
		main = new JPanel();
		main.setBackground(Color.white);
		main.setLayout(null);
		main.setVisible(true);
		coMain.add(main);
		
		//other panels
		Hlevel  = new HPofficerWindow();
		HighLevel = Hlevel.main;
		
		Llevel = new LowLevelPoliceOfficer();
		LowLevel = Llevel.lmain;
		
		Admin = new AdminLogin();
		adminPanel = Admin.AdminLog;
		
		
		//IconImage
		ImageIcon img = new ImageIcon("D:\\Kishore\\tnpd.jpg");
		setIconImage(img.getImage());
		
		
		//button
		login = new JButton("Login");
		admin = new JButton("Admin");
		
		admin.setBounds(10,10,90,30);
		login.setBounds(700,420,130,40);
		login.setFont(new Font("Verdana",Font.BOLD,15));
		admin.setFont(new Font("Verdana",Font.PLAIN,15));
		admin.setForeground(Color.WHITE);
		login.setForeground(Color.WHITE);
		admin.setBackground(new Color(10,150,120));
		login.setBackground(new Color(10,30,90));
		
		//textfields
		offcID = new JTextField();
		password = new TextField();
		password.setEchoChar('*');
		
		offcID.setFont(new Font("Times new roman",Font.PLAIN,17));
		password.setFont(new Font("Times new roman",Font.PLAIN,17));
		
		offcID.setBounds(650,260,260,40);
		password.setBounds(650,340,260,40);
		
		//labels
		head = new JLabel("Tamilnadu Department of Police");
		LoffcID = new JLabel("Officer ID");
		Lpassword = new JLabel("Password");
		pass_msg = new JLabel("Password Incorrect");
		login_msg = new JLabel("ID Not found");
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		
		
		head.setFont(new Font("Times new roman",Font.BOLD,30));
		LoffcID.setFont(new Font("Times new roman",Font.BOLD,20));
		Lpassword.setFont(new Font("Times new roman",Font.BOLD,20));
		pass_msg.setFont(new Font("Times new roman",Font.ITALIC,16));
		login_msg.setFont(new Font("Times new roman",Font.ITALIC,16));
		pass_msg.setForeground(Color.RED);
		login_msg.setForeground(Color.RED);
		
		head.setBounds(530,0,500,30);
		LoffcID.setBounds(530, 260,170,40);
		Lpassword.setBounds(530, 340,170,40);
		login_msg.setBounds(920,260,200,30);
		pass_msg.setBounds(920,340,200,30);
		image.setBounds(550,0,450,300);
		
		login_msg.setVisible(false);
		pass_msg.setVisible(false);
		
		main.add(image);
		main.add(LoffcID);
		main.add(offcID);
		main.add(password);
		main.add(Lpassword);
		main.add(login);
		main.add(admin);
		main.add(pass_msg);
		main.add(login_msg);
		main.add(head);
		
		
		//Event Listeners
		
		//login button
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id  = offcID.getText();
				String pass = password.getText();
				try 
				{
					Connection conn  = DatabaseConnection.getConnected();
					PreparedStatement st = conn.prepareCall("select * from officers where officerid=?");
					
					st.setString(1,id);
							
					ResultSet data = st.executeQuery();
					if(data.next())
					{
						String key=data.getString("password");
						
						if(!pass.equals(key))
						{
							pass_msg.setVisible(true);
						}
						else
						{
						    obj = new OfficerBean();
							
							long phno =Long.parseLong(data.getString("phno"));
							String station = data.getString("station");
							int age = data.getInt("age");
							String name  = data.getString("officername");
							String desg = data.getString("designation");
							
							obj.setAge(age);
							obj.setDesignation(desg);
							obj.setOfficerID(id);
							obj.setPassword(pass);
							obj.setPhoneNumber(phno);
							obj.setStation(station);
							obj.setOfficerName(name);
							
							if(id.charAt(3)=='i' || id.charAt(3)=='I')
							{
								offcID.setText("");
								password.setText("");
								login_msg.setVisible(false);
								pass_msg.setVisible(false);
								
								LowLevelPoliceOfficer.getData(obj);
								
								main.setVisible(false);
								HighLevel.setVisible(false);
								LowLevel.setVisible(true);
								adminPanel.setVisible(false);
								
								coMain.add(LowLevel);
								
							}
							else
							{
								offcID.setText("");
								password.setText("");
								login_msg.setVisible(false);
								pass_msg.setVisible(false);
								
								HPofficerWindow.getData(obj);
								
								main.setVisible(false);
								HighLevel.setVisible(true);
								LowLevel.setVisible(false);
								adminPanel.setVisible(false);
								
								coMain.add(HighLevel);
							}
						}
					
					}
					else
					{
						login_msg.setVisible(true);
					}
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(rootPane, e1);
				}
			}
		});
		
		admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				main.setVisible(false);
				HighLevel.setVisible(false);
				LowLevel.setVisible(false);
				adminPanel.setVisible(true);
				
				coMain.add(adminPanel);
			}
		});
		
	}
	
	public static void HomeScreen()
	{
		main.setVisible(true);
		HighLevel.setVisible(false);
		LowLevel.setVisible(false);
		adminPanel.setVisible(false);
		
		coMain.add(main);
	}
}

public class CrimeRecordManagement {

	public static void main(String[] args) throws IOException
	{
		new HomeWindow();
	}
}
