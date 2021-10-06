package crms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.util.*;
import java.util.regex.Pattern;

import crms.DatabaseConnection;
import crms.HighlevelPoliceOfiicer;
import java.sql.*;
import java.text.SimpleDateFormat;

public class UpdateFir extends JFrame{
	
	JPanel UpdatePan;

	//Labels
	JLabel ldate,lstation,lfir_id,llocation,lcname,lac_name,lap_name,lap_phno,lad,lcs,lage;
	JLabel date_msg,firid_msg,apname_msg,acname_msg,phno_msg,age_msg;
	JLabel head,head2,image;
		
	//TextFields
	JTextField tlocation,tcname,tac_name,tap_name,tap_phno,tad,tage;
		 
	//Buttons
	JButton search,update,home;
	
	//combobox
	JComboBox tstation,tcs,tfir_id;
	
	//date chooser
	JDateChooser tdate;
	
	UpdateFir( )
	{
		UpdatePan = new JPanel();
		UpdatePan.setBackground(Color.WHITE);
		UpdatePan.setLayout(null);
		getContentPane().add(UpdatePan);
		
		search = new JButton("search");
		update = new JButton("update");
		home = new JButton("home");
		
		 //headings
		 head = new JLabel("Tamilnadu Department of Police");
		 head.setBounds(550,20,500,40);
		 head.setFont(new Font("Times new roman", Font.BOLD,30));
		 
		 head2 = new JLabel("Select a FIR");
		 head2.setBounds(350,60,260,30);
		 head2.setFont(new Font("Times new roman", Font.PLAIN,20)); 
		 
		 //Labels
		 ldate=new JLabel("Date");
	   	 lstation=new JLabel("Station Name");
	   	 lfir_id=new JLabel("FIR ID");
	   	 llocation=new JLabel("Location");
	   	 lap_name=new JLabel("Applicant Name");
	   	 lap_phno=new JLabel("Applicant Phone no");
	     lad=new JLabel("Applicant Address");
	   	 lcname=new JLabel("Complaint");
	   	 lac_name=new JLabel("Accused Name");
	   	 lage = new JLabel("Accused age");
	   	 lcs=new JLabel("File Status");
	   	 image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
	   	 
	   	 ldate.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lstation.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lfir_id.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 llocation.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lap_name.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lap_phno.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lad.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lcname.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lac_name.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lage.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 lcs.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	 
	   	 //Error message Labels
	     date_msg = new JLabel("Date cannot be null");
	     firid_msg = new JLabel("Invalid FIR Id");
	     apname_msg = new JLabel("Enter a valid name");
	     acname_msg = new JLabel(" Enter a valid name");
	     phno_msg = new JLabel("Invalid Phone number");
	     age_msg = new JLabel("Invalid");
	    	 
	     date_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	     firid_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	     apname_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	     acname_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	     phno_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	     age_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	 
	     //date
	   	 tdate=new JDateChooser();
	     //TextFields
	   	 tlocation=new JTextField();
	   	 tcname=new JTextField();
	   	 tac_name=new JTextField();
	   	 tage = new JTextField();
	   	 tap_name=new JTextField();
	   	 tap_phno=new JTextField();
	   	 tad=new JTextField();
	   	 
		 
	     //Drop-down boxes
	   	 tstation=new JComboBox();
	   	 tcs=new JComboBox();
	   	 tfir_id=new JComboBox();
	   	 
	   	 //Station items
	   	 tstation.addItem("Select Station");
	   	 tstation.addItem("B2-RS.Puram");
	   	 tstation.addItem("B1-Selvauram");
	   	 tstation.addItem("A2-Vadavalli");
	   	 tstation.addItem("S2-Townhall");
	   	 tstation.addItem("A1-Singanallur");
	   	 tstation.addItem("B2-Gandhipuram");
	   	
	   	 
	   	 //fir item
	   	 tfir_id.addItem("Select FIR ID");
	   	 
	   	 //status items
	   	 tcs.addItem("Select");
	   	 tcs.addItem("Pending");
	   	 tcs.addItem("Assigned");
	   	 tcs.addItem("Closed");
	   		 
	      //Labels
	   	 lfir_id.setBounds(100,100,150,20);
	   	 lstation.setBounds(100,170,150,20);
	   	 ldate.setBounds(100,240,150,20);
	   	 llocation.setBounds(100,310,150,20);
	   	 lap_name.setBounds(100,380,150,20);
	   	 lap_phno.setBounds(100,460,170,20);
	   	 lad.setBounds(100,530,150,20);
	 
	   	 lcname.setBounds(800,100,150,20);
	   	 lac_name.setBounds(800,370,150,20);
	   	 lage.setBounds(800,440,170,20);
	   	 lcs.setBounds(800,530,150,20);
	   	
	   	 //Error messages
	   	 firid_msg.setBounds(320,280,200,20);
	   	 apname_msg.setBounds(320,420,200,20);
	   	 phno_msg.setBounds(320,500,200,20);
	   	 acname_msg.setBounds(940,410,200,20);
	   	 age_msg.setBounds(940,480,200,20);
	   	 image.setBounds(675,150,180,180);
	   	 
	   	 firid_msg.setForeground(Color.red);
	   	 apname_msg.setForeground(Color.red);
	   	 acname_msg.setForeground(Color.red);
	   	 phno_msg.setForeground(Color.red);
	   	 age_msg.setForeground(Color.red);
	   	 
	   	 //Setting off error message visibility
	   	 date_msg.setVisible(false);
	  	 firid_msg.setVisible(false);
	  	 apname_msg.setVisible(false);
	  	 phno_msg.setVisible(false);
	  	 acname_msg.setVisible(false);
	  	 age_msg.setVisible(false);
	   	 
	   	 //TextFields
	   	 tfir_id.setBounds(320,100,300,30);
		 tstation.setBounds(320,170,300,30);
		 tdate.setBounds(320,240,300,30);
		 tlocation.setBounds(320,310,300,30);
		 tap_name.setBounds(320,380,300,30);
		 tap_phno.setBounds(320,460,300,30);
		 tad.setBounds(320,530,300,70);
		 
		 tcname.setBounds(940,100,300,140);
		 tac_name.setBounds(940,370,300,30);
		 tage.setBounds(940,440,300,30);
		 tcs.setBounds(940,530,300,30);
		 
		
		 
		 //Buttons
		 home.setBounds(35,15,80,30);
		 update.setBounds(670,660,150,30);
		 search.setBounds(630,100,80,30);
		 
		//TextFields
		 UpdatePan.add(tdate);
		 UpdatePan.add(tstation);
		 UpdatePan.add(tfir_id);
		 UpdatePan.add(tlocation);
		 UpdatePan.add(tcname);
		 UpdatePan.add(tac_name);
		 UpdatePan.add(tap_name);
		 UpdatePan.add(tap_phno);
		 UpdatePan.add(tad);
		 UpdatePan.add(tcs);
		 UpdatePan.add(tage);
		 UpdatePan.add(head);
		 
		 //Labels
		 UpdatePan.add(ldate);
		 UpdatePan.add(lstation);
		 UpdatePan.add(lfir_id);
		 UpdatePan.add(llocation);
		 UpdatePan.add(lcname);
		 UpdatePan.add(lac_name);
		 UpdatePan.add(lap_name);
		 UpdatePan.add(lap_phno);
		 UpdatePan.add(lage);
		 UpdatePan.add(lad);
		 UpdatePan.add(lcs);
		 UpdatePan.add(date_msg);
		 UpdatePan.add(age_msg);
		 UpdatePan.add(firid_msg);
		 UpdatePan.add(phno_msg);
		 UpdatePan.add(acname_msg);
		 UpdatePan.add(apname_msg);
		 UpdatePan.add(image);
		 
		 
		 //buttons
		 UpdatePan.add(search);
		 UpdatePan.add(update);
		 UpdatePan.add(home);
		 UpdatePan.add(head2);
		 
		//adding Components to drop-down box
			try 
			{
				Connection conn = DatabaseConnection.getConnected();
				String query ="select * from fir";
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet data = pst.executeQuery();
				while(data.next())
				{
					tfir_id.addItem(data.getString("firid"));
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(rootPane, "Database not connected");
			}
			
		  //EventListeners to Buttons
		  search.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 String num=(String) tfir_id.getSelectedItem();
				 
				 if(checkFirid(num))
				 {
					 try {
						 
						    Connection conn = DatabaseConnection.getConnected();
						    String query ="select * from fir where firId=? ";
							
							PreparedStatement pst = conn.prepareStatement(query);
							pst.setString(1,num);
							
							ResultSet data = pst.executeQuery();
							
							while(data.next())
							{
								
								 tdate.setDate(data.getDate("fileddate"));
				    			 tlocation.setText(data.getString("location"));
				    			 tstation.setSelectedItem(data.getString("stationname"));
				    			 tcname.setText(data.getString("complaint"));
				    			 tac_name.setText(data.getString("accusedname"));	
				    			 tap_name.setText(data.getString("applicantname"));
				    			 tap_phno.setText(data.getString("applicantphno"));
				    			 tad.setText(data.getString("applicantaddress"));
				    			 tage.setText(data.getString("accusedage"));
				    			 tcs.setSelectedItem(data.getString("status"));
				    			 
							}
							if(data==null)
							{
								JOptionPane.showMessageDialog(rootPane, "FIR not found");
							}		
					     }
					 
					    catch(Exception e1)
					 	{
						 System.out.println(e1);
					 	} 
				    }
				  else
				  {
					 JOptionPane.showMessageDialog(rootPane, "Invalid FIR ID");
				  }
				 
			 }
		 });
		 
		 
		 update.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 SimpleDateFormat sdf;
				 String tdat="";
				 try {
					
					 try {
						 sdf=new SimpleDateFormat("yyyy-MM-dd");
						  tdat=sdf.format(tdate.getDate());
					 }
					 catch(Exception e3)
					 {
						 date_msg.setVisible(true);
					 }
					 
					 String tdatev = tdat;
	    			 String tstationv=(String) tstation.getSelectedItem();
	    			 String tfir_idv=(String) tfir_id.getSelectedItem();
	    			 String tlocationv=tlocation.getText();
	    			 String tcnamev=tcname.getText();
	    			 String tac_namev=tac_name.getText();
	    			 String  age = tage.getText();
	    			 String tap_namev=tap_name.getText();
	    			 String tap_phnov= tap_phno.getText();
	    			 String tadv=tad.getText();
	    			 String tcsv=(String) tcs.getSelectedItem();
	    			 
	    			 
	    			 if(validation(age,tac_namev,tap_namev,tfir_idv, tap_phnov, tdatev))
	    			 {
	    				 Connection conn = DatabaseConnection.getConnected();
		    			 PreparedStatement pst = conn.prepareCall("insert into fir values(?,?,?,?,?,?,?,?,?,?,?)");
		    			
		    			 int fage = Integer.parseInt(age);
		    			 long phno = Long.parseLong(tap_phnov);
		    			 
		    				pst.setString(1, tdatev);
		    				pst.setString(2, tstationv);
		    				pst.setString(3, tfir_idv);
		    				pst.setString(4, tlocationv);
		    				pst.setString(5, tap_namev);
		    				pst.setString(6, tadv);
		    				pst.setLong(7, phno);
		    				pst.setString(8, tcnamev);
		    				pst.setString(9, tac_namev);
		    				pst.setInt(10, fage);
		    				pst.setString(11, tcsv);
		    				
		    				pst.executeUpdate();	
		    				conn.setAutoCommit(true);
		    				conn.close();
		    				//Success message
		    				JOptionPane.showMessageDialog(rootPane, "FIR Filed Successfully");
		    				
			    			 
			    			 tlocation.setText("");
			    			 tcname.setText("");
			    			 tac_name.setText("");	
			    			 tap_name.setText("");
			    			 tap_phno.setText("");
			    			 tad.setText("");
			    			 tage.setText(" "); 
	    			 } 
	    			 else
	    			 {
	    				 JOptionPane.showMessageDialog(rootPane, "Check the values entered");
	    			 }	 	
				 }
				 
				 catch(Exception e1)
				 {
					System.out.println(e1);
				 }
				
			 }
		 });
		 
		 
		 home.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 {
				 //clearing off tetxfields
				 tlocation.setText("");
    			 tcname.setText("");
    			 tac_name.setText("");	
    			 tap_name.setText("");
    			 tap_phno.setText("");
    			 tad.setText("");
    			 tage.setText(" "); 
    			 tdate.setDate(null);
    			 tstation.setSelectedItem("Select Station");
    			 tfir_id.setSelectedItem("Select FIR ID");
    			 tcs.setSelectedItem("Select");
    			 
    			 //setting off the visibility for error messages
    			 date_msg.setVisible(false);
    		  	 firid_msg.setVisible(false);
    		  	 apname_msg.setVisible(false);
    		  	 phno_msg.setVisible(false);
    		  	 acname_msg.setVisible(false);
    		  	 age_msg.setVisible(false);
    		  	 
				 HPofficerWindow.homeDisplay();
					 
			 }
		 });
		
	}
	
	//Form values validation
		public boolean validation(String age,String acname,String apname,String firid,String phno,String date)
		{
			int flag=0;
			
			if(!this.checkAge(age))
			{
				age_msg.setVisible(true);
				flag=1;
			}
			
			if(!this.checkFirid(firid))
			{
				firid_msg.setVisible(true);
				flag=1;
			}
			if(!this.checkName(apname))
			{
				apname_msg.setVisible(true);
				flag=1;
			}
			if(!this.checkName(acname))
			{
				acname_msg.setVisible(true);
				flag=1;
			}
			if(!this.checkPhno(phno))
			{
				phno_msg.setVisible(true);
				flag=1;
			}
			
			if(flag==0)
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
		
		//check for valid name
		public boolean checkName(String name)
		{
			for(int i=0;i<name.length();i++)
			{
				if(Character.isDigit(name.charAt(i)))
				{
					return false;
				}		
			}	
			return true;
		}
		
		//check for valid phone number
		public boolean checkPhno(String phno)
		{
			
			if(Pattern.matches("[0-9 &&[^a-zA-z]]*$",phno))
			{
				if(phno.length()==10)
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
		public boolean checkFirid(String id)
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
		
		
		
	
}
