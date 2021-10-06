package crms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;

public class DeleteOfficer extends JFrame {

	static JPanel delpan;
	
	//comboBox
	JComboBox offid;
	
	//Button
	JButton home,delete;
	
	//Labels
	JLabel head,image,head2,head3;
	
	DeleteOfficer()
	{
		//Panel
		delpan = new JPanel();
		delpan.setLayout(null);
		delpan.setBackground(Color.WHITE);
		delpan.setVisible(true);
		
		//buttons
		home = new JButton("Home");
		delete = new JButton("Delete");
		
		home.setForeground(Color.WHITE);
		home.setBackground(new Color(10,150,120));
		
		home.setBounds(60,30,80,30);
		delete.setBounds(750,200,150,40);
		
		//officers ID ComboBox
		offid = new JComboBox();
		offid.addItem("Select an ID");
		
		offid.setBounds(550,200,150,40);
		
		//heading
		head = new JLabel("TamilNadu Police Department");
		head.setFont(new Font("Times new roman",Font.BOLD,30));
		head.setBounds(530,0,500,30);
		
		head2 = new JLabel("Admin Panel");
		head2.setBounds(640,50,200,30);
		head2.setFont(new Font("Times new roman",Font.PLAIN,25));
		
		head3 = new JLabel("Select an ID to Delete");
		head3.setBounds(630,100,200,30);
		head3.setFont(new Font("Times new roman",Font.PLAIN,20));

		
		//image
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		image.setBounds(20,100,180,180);
		
		delpan.add(delete);
		delpan.add(home);
		delpan.add(image);
		delpan.add(head);
		delpan.add(offid);
		delpan.add(head2);
		delpan.add(head3);
	
		//adding components to officerId comboBox
		try{
			Connection con = DatabaseConnection.getConnected();
			
			String query = "select * from officers";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet data = st.executeQuery();
			
			while(data.next())
			{
				offid.addItem(data.getString("officerid"));
			}
			
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(rootPane, "Database not Connected"+e1);
		}
		
		//Event Listeners
		//delete button
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String i = offid.getSelectedItem().toString();
				
				try {
					Connection conn  = DatabaseConnection.getConnected();
					String query = "delete from officers where officerid=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, i);
					pst.executeUpdate();
					conn.setAutoCommit(true);
					
					JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
					
					offid.setSelectedItem("Select an ID");
				} 
				
				catch (Exception ee)
				{
					JOptionPane.showMessageDialog(rootPane, "Database not Connected"+ee);
				}	
			}
			
		});
		
		//home button
		home.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				offid.setSelectedItem("Select an ID");
				AdminHome.AdminDisplay();
			}
		});
	}
}
