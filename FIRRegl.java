package crms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;
import java.sql.*;
import java.text.SimpleDateFormat;
import crms.HighlevelPoliceOfiicer;
import com.toedter.calendar.*;

public class FIRRegl extends JFrame {

	JPanel FirPan;
	
	//Labels
	JLabel ldate,lstation,lfir_id,llocation,lcname,lac_name,lap_name,lap_phno,lad,lcs,head,lage;
	JLabel date_msg,firid_msg,apname_msg,acname_msg,phno_msg,age_msg,image;
	
	//TextFields
	JTextField tfir_id,tlocation,tcname,tac_name,tap_name,tap_phno,tad,tage;
	 
	//button
	JButton bregister,home;
	
	//combobox
	JComboBox tstation,tcs;
	
	//date chooser
	JDateChooser tdate; 

	FIRRegl()
	{
		
	  FirPan = new JPanel();
	  FirPan.setBackground(Color.WHITE);
	  FirPan.setLayout(null);
	  getContentPane().add(FirPan);
		
	  head = new JLabel("Tamilnadu Department of Police");
	  head.setBounds(560,30,500,40);
	  head.setFont(new Font("Times new roman", Font.BOLD,25));
	  
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
   	age_msg = new JLabel("Invalid age");
   	 
   	date_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
   	firid_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
   	apname_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
   	acname_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
   	phno_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
   	age_msg.setFont(new Font("Times new roman", Font.ITALIC,15));
   	   	 
   	date_msg.setForeground(Color.red);
   	firid_msg.setForeground(Color.red);
   	apname_msg.setForeground(Color.red);
   	acname_msg.setForeground(Color.red);
   	phno_msg.setForeground(Color.red);
   	age_msg.setForeground(Color.red);
   	 
   	//TextFields
   	 tdate=new JDateChooser();
   	 tfir_id=new JTextField();
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
   	 
   	 //Station items
   	 tstation.addItem("Select Station");
   	 tstation.addItem("B2-RS.Puram");
   	 tstation.addItem("B1-Selvauram");
   	 tstation.addItem("A2-Vadavalli");
   	 tstation.addItem("S2-Townhall");
   	 tstation.addItem("A1-Singanallur");
   	 tstation.addItem("B2-Gandhipuram");
   	 
   	 //status items
   	 tcs.addItem("Select");
   	 tcs.addItem("Pending");
   	 tcs.addItem("Assigned");
   	 tcs.addItem("Closed");
   	
   	 //Button
   	 bregister=new JButton("REGISTER");
   	 home = new JButton("Home");
   	
   	 //Labels
   	 ldate.setBounds(100,100,150,20);
   	 lstation.setBounds(100,170,150,20);
   	 lfir_id.setBounds(100,240,150,20);
   	 llocation.setBounds(100,310,150,20);
   	 lap_name.setBounds(100,380,150,20);
   	 lap_phno.setBounds(100,460,170,20);
   	 lad.setBounds(100,530,150,20);
 
   	 lcname.setBounds(800,100,150,20);
   	 lac_name.setBounds(800,370,150,20);
   	 lage.setBounds(800,440,170,20);
   	 lcs.setBounds(800,530,150,20);
   	
   	 //error message labels
   	 firid_msg.setBounds(320,280,200,20);
   	 apname_msg.setBounds(320,420,200,20);
   	 phno_msg.setBounds(320,500,200,20);
   	 acname_msg.setBounds(940,410,200,20);
   	 age_msg.setBounds(940,480,200,20);
   	 //image label
   	 image.setBounds(650,150,180,180);
   	 
   	 //Setting off error message visiblity
   	 date_msg.setVisible(false);
  	 firid_msg.setVisible(false);
  	 apname_msg.setVisible(false);
  	 phno_msg.setVisible(false);
  	 acname_msg.setVisible(false);
  	 age_msg.setVisible(false);
   	 
   	 //TextFields
   	 tdate.setBounds(320,100,300,30);
	 tstation.setBounds(320,170,300,30);
	 tfir_id.setBounds(320,240,300,30);
	 tlocation.setBounds(320,310,300,30);
	 tap_name.setBounds(320,380,300,30);
	 tap_phno.setBounds(320,460,300,30);
	 tad.setBounds(320,530,300,70);
	 
	 tcname.setBounds(940,100,300,140);
	 tac_name.setBounds(940,370,300,30);
	 tage.setBounds(940,440,300,30);
	 tcs.setBounds(940,530,300,30);
	 
	 //buttons
	 bregister.setBounds(660,660,150,30);
	 home.setBounds(30,30,80,30);
   	 
	 //TextFields
	 FirPan.add(tdate);
	 FirPan.add(tstation);
	 FirPan.add(tfir_id);
	 FirPan.add(tlocation);
	 FirPan.add(tcname);
	 FirPan.add(tac_name);
	 FirPan.add(tap_name);
	 FirPan.add(tap_phno);
	 FirPan.add(tad);
	 FirPan.add(tcs);
	 FirPan.add(tage);
	 FirPan.add(head);
	
	 //Labels
	 FirPan.add(ldate);
	 FirPan.add(lstation);
	 FirPan.add(lfir_id);
	 FirPan.add(llocation);
	 FirPan.add(lcname);
	 FirPan.add(lac_name);
	 FirPan.add(lap_name);
	 FirPan.add(lap_phno);
	 FirPan.add(lad);
	 FirPan.add(lcs);
	 FirPan.add(lage);
	 FirPan.add(date_msg);
	 FirPan.add(firid_msg);
	 FirPan.add(phno_msg);
	 FirPan.add(acname_msg);
	 FirPan.add(apname_msg);
	 FirPan.add(age_msg);
	 FirPan.add(image);
	 
	 
	 //button
	 FirPan.add(bregister);
	 FirPan.add(home);
	 
		 bregister.addActionListener(new ActionListener() {
			 
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
	    			 String tfir_idv=tfir_id.getText();
	    			 String tlocationv=tlocation.getText();
	    			 String tcnamev=tcname.getText();
	    			 String tac_namev=tac_name.getText();
	    			 String age = tage.getText();
	    			 String tap_namev=tap_name.getText();
	    			 String tap_phnov= tap_phno.getText();
	    			 String tadv=tad.getText();
	    			 String tcsv=(String) tcs.getSelectedItem();
	    			 
	    			 
	    			 if(validation(age,tac_namev,tap_namev,tfir_idv, tap_phnov))
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
		    				
		    				//setting off the visibility for error messages
			    			 date_msg.setVisible(false);
			    		  	 firid_msg.setVisible(false);
			    		  	 apname_msg.setVisible(false);
			    		  	 phno_msg.setVisible(false);
			    		  	 acname_msg.setVisible(false);
			    		  	 age_msg.setVisible(false);
			    		  	 
		    				//Success message
		    				JOptionPane.showMessageDialog(rootPane, "FIR Filed Successfully");
		    				
			    			 
			    			 tfir_id.setText("");
			    			 tlocation.setText("");
			    			 tcname.setText("");
			    			 tac_name.setText("");	
			    			 tap_name.setText("");
			    			 tap_phno.setText("");
			    			 tad.setText("");			    			 
			    			 tage.setText(" "); 
			    			 tcs.setSelectedItem("Select");
			    			 tstation.setSelectedItem("Select Station");
			    			 tdate.setDate(null);
			    			
			    			 
	    			 } 
	    			 else
	    			 {
	    				 JOptionPane.showMessageDialog(rootPane, "Check the values entered");
	    			 }	 	
				 }
				 
				 catch(NumberFormatException e1)
				 {
					 age_msg.setVisible(true);
					 JOptionPane.showMessageDialog(rootPane, "Values must not begin with space");
					 
					 
				 }
				 catch(SQLIntegrityConstraintViolationException e3)
				 {
					 firid_msg.setVisible(true);
					 JOptionPane.showMessageDialog(rootPane, "FIR ID already exists");
					 
				 }
				 catch(SQLException e4)
				 {
					 JOptionPane.showMessageDialog(rootPane, "Database not connected");
				 }
				
			 }
		 });
		 
		 home.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 { 
				 //clearing values of textfields
				 tfir_id.setText("");
    			 tlocation.setText("");
    			 tcname.setText("");
    			 tac_name.setText("");	
    			 tap_name.setText("");
    			 tap_phno.setText("");
    			 tad.setText("");			    			 
    			 tage.setText(" "); 
    			 tcs.setSelectedItem("Select");
    			 tstation.setSelectedItem("Select Station");
    			 tdate.setDate(null);
    			 
    			//setting off the visibility for error messages
    			 date_msg.setVisible(false);
    		  	 firid_msg.setVisible(false);
    		  	 apname_msg.setVisible(false);
    		  	 phno_msg.setVisible(false);
    		  	 acname_msg.setVisible(false);
    		  	 age_msg.setVisible(false);
    			 
    		  	LowLevelPoliceOfficer.homeDisplay();	 
			 }
		 });
	
	}
	
	//Form values validation
	public boolean validation(String age,String acname,String apname,String firid,String phno)
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
