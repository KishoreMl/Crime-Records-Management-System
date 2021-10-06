package crms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import crms.UpdateFir;
import java.sql.*;
import crms.DatabaseConnection;
import crms.HighlevelPoliceOfiicer;

public class DeleteFir extends JFrame {

	JPanel DelPan;
	
	JComboBox num;
	
	JLabel Firid;
	JLabel head;
	JLabel head2;
	JLabel head3;
	JLabel image;
	
	JButton del,home;
	
	DeleteFir()
	{
		//Main Panel
		DelPan = new JPanel();
		DelPan.setBackground(Color.WHITE);
		DelPan.setLayout(null);
		DelPan.setSize(700,700);
		
		//Labels
		Firid = new JLabel();
		head = new JLabel("TamilNadu Police Department");
		head2 = new JLabel("Delete FIR Records");
		head3  = new JLabel("Select a FIR Number to delete");
		
		head.setFont(new Font("Times new roman", Font.BOLD,30));
		head2.setFont(new Font("Times new roman", Font.PLAIN,25));
		head3.setFont(new Font("Times new roman", Font.PLAIN,20));
		
		//image
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		
		//Drop-down Box
		num = new JComboBox();
		num.addItem("Select a FIR");
		
		//Buttons
		del = new JButton("Delete case File");
		home = new JButton("Home");
		
		Firid.setBounds(100,100,100,30);
		del.setBounds(750,200,140,30);
		num.setBounds(590,200,140,30);
		home.setBounds(60,30,80,30);

		head.setBounds(550,30,500,40);
		head2.setBounds(650,90,300,30);
		head3.setBounds(630,150,300,30);
		image.setBounds(20,100,180,180);
		
		DelPan.add(Firid);
		DelPan.add(head);
		DelPan.add(head2);
		DelPan.add(head3);
		DelPan.add(del);
		DelPan.add(num);
		DelPan.add(home);
		DelPan.add(image);
		
		this.addcomp();
		//Event Listeners
		home.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 num.setSelectedItem("Select a FIR");
				 HPofficerWindow.homeDisplay(); 
			 }
		 });
		
		
		del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				DeleteFir obj = new DeleteFir();
				obj.addcomp();
				String firid = (String) num.getSelectedItem();
				if(obj.checkFirId(firid))
				{
					try {
						
						Connection conn = DatabaseConnection.getConnected();
						String query = "delete from fir where firid=?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, firid);
						pst.executeUpdate();
						conn.setAutoCommit(true);
						JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(rootPane, "FIR Number not found");
					}
					
					//deleting case file if it's stored in caseAssigned table
					try
					{
						Connection conn = DatabaseConnection.getConnected();
						String query = "delete from caseassigned where firid=?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, firid);
						pst.executeUpdate();
						conn.setAutoCommit(true);
					}
					catch(Exception e2)
					{
						
					}
					
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Invalid FIR Number");
				}
			}
		});
		
		
	}
	
	public boolean checkFirId(String id)
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
		if(id.charAt(3)!='D')
		{
			return false;
		}
		
		return true;
	}
	//adding Components to drop-down box
			public void addcomp()
			{
				try 
				{
					Connection conn = DatabaseConnection.getConnected();
					String query ="select * from fir";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet data = pst.executeQuery();
					while(data.next())
					{
						num.addItem(data.getString("firid"));
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(rootPane, "Database not connected");
				}
			}
}
