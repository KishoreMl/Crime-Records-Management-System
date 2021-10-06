package crms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.util.*;
import crms.DatabaseConnection;
import java.sql.*;
import java.text.SimpleDateFormat;

public class SearchFirl extends JFrame {
	
	JPanel Searchpan;
	
	//Buttons
	JButton dateSearch;
	JButton firIdSearch;
	JButton stationSearch;
	JButton home;

	//Labels
	JLabel dlabel,flabel,slabel,dmsg,fmsg,smsg,head,strrec,firrec,daterec,count,image;
	
	
	//Drop-down box
	JComboBox firId,station;
	
	//Table 
	DefaultTableModel dm;
	JTable table;
	JScrollPane sc;
	
	//DateChooser
	JDateChooser tdate;
	
	int c=0;
	
	//Column Labels for Table 
	String[] column= {"Date","Station","FIR id","Location","ApplicantName","ApplicantAddress","ApplicantPhone",
				"Complaint","AccusedName","AccusedAge","ComplaintStatus" };
	
	SearchFirl()
	{
		
		Searchpan = new JPanel();
		Searchpan.setLayout(null);
		Searchpan.setBackground(Color.WHITE);
		getContentPane().add(Searchpan);
		
		//Buttons
		dateSearch = new JButton("Search");
		firIdSearch = new JButton("Search");
		stationSearch = new JButton("Search");
		home = new JButton("Home");
		
		//heading-label
		head = new JLabel("Tamilnadu Department of Police");
		head.setBounds(550,20,500,40);
		head.setFont(new Font("Times new roman", Font.BOLD,25));
		
		//Labels
	   	dlabel = new JLabel("Search by date");
	   	flabel = new JLabel("Search by FIR ID");
	   	slabel = new JLabel("Search by Station");
	   	dmsg = new JLabel("Incorrect date format");
	   	fmsg = new JLabel("Select a FIR ID");
	   	smsg = new JLabel("Select a station");
	   	strrec = new JLabel();
	   	daterec = new JLabel();
	   	firrec = new JLabel();
	   	count = new JLabel();
	   	
	    //Image
	   	image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
	   	
	   	//Date chooser
	   	tdate = new JDateChooser();
	   	 
	   	//Drop-down boxes
	   	firId = new JComboBox();
	   	station = new JComboBox();
	   	 
	    //adding components to station ComboBox
	   	station.addItem("Select Station");
	   	station.addItem("B2-RS.Puram");
	   	station.addItem("B1-Selvauram");
	   	station.addItem("A2-Vadavalli");
	   	station.addItem("S2-Townhall");
	   	station.addItem("A1-Singanallur");
	   	station.addItem("B2-Gandhipuram");
	   	firId.addItem("Select FIR");
	   	 
	    //Table settings
		dm=new DefaultTableModel();
		dm.setColumnIdentifiers(column);
		dm.addRow(column);
		
		table= new JTable();
		table.setModel(dm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(20,290,1500,500);
		table.setRowHeight(33);
		table.setRowMargin(20);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("verdana",Font.PLAIN,13));
		
		sc = new JScrollPane(table);

		//setting table visibility to false
		sc.setVisible(false);
		table.setVisible(false);
		
		
	   	
	   	//Buttons
	   	dateSearch.setBounds(400,150, 110,30);
	   	firIdSearch.setBounds(800,150, 110,30);
	   	stationSearch.setBounds(1200,150, 110,30);
	   	home.setBounds(70,30,80,30);
	   	
	   	//Textfield and combobox
	   	tdate.setBounds(250,150,140,30);
	   	firId.setBounds(650,150,140,30);
	   	station.setBounds(1050,150,140,30);
	   	
	   	//Labels
	   	dlabel.setBounds(250,100,200,30);
	   	flabel.setBounds(650,100,200,30);
	   	slabel.setBounds(1050,100,200,30);
	   	dmsg.setBounds(250,180,200,30);
	   	fmsg.setBounds(650,180,200,30);
	   	smsg.setBounds(1050,180,200,30);
	   	count.setBounds(230,230,200,30);
	   	image.setBounds(20,100,180,180);
	   	
	   	dlabel.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	flabel.setFont(new Font("Times new roman", Font.PLAIN,20));   	
	   	slabel.setFont(new Font("Times new roman", Font.PLAIN,20));
	   	count.setFont(new Font("Times new roman", Font.BOLD,20));
	   	dmsg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	fmsg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	smsg.setFont(new Font("Times new roman", Font.ITALIC,15));
	   	
	   	dmsg.setForeground(Color.red);
	   	fmsg.setForeground(Color.red);
	   	smsg.setForeground(Color.red);
	   	
	   	dmsg.setVisible(false);
	   	fmsg.setVisible(false);
	   	smsg.setVisible(false);
	   	
	   	//adding components to Panel
	   	
	   	Searchpan.add(dateSearch);
	   	Searchpan.add(stationSearch);
	   	Searchpan.add(firIdSearch);
	   	Searchpan.add(head);
	   	Searchpan.add(firId);
	   	Searchpan.add(station);
	   	Searchpan.add(tdate);
	   	Searchpan.add(dlabel);
	   	Searchpan.add(slabel);
	   	Searchpan.add(flabel);
	   	Searchpan.add(dmsg);
	   	Searchpan.add(fmsg);
	   	Searchpan.add(smsg);
	   	Searchpan.add(home);
	   	Searchpan.add(strrec);
	   	Searchpan.add(daterec);
	   	Searchpan.add(firrec);
	   	Searchpan.add(count);
	   	Searchpan.add(image);
	   	Searchpan.add(table);
	   	Searchpan.add(sc);
	   	
	   	
	   	
	   //adding Components to firId ComboBox
		try {
				
				Connection conn = DatabaseConnection.getConnected();
				String query ="select * from fir";
				
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet data = pst.executeQuery();
				while(data.next())
				{
					firId.addItem(data.getString("firid"));
				}
				
			}
		
		catch(Exception e)
		{
				System.out.println(e);
		}
		
		//EventListeners
		dateSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String tdatev=sdf.format(tdate.getDate());
				
				String date="";
				String station="";
				String firid="";
				String location="";
				String appName="";
				String appAdd="";
				String appPh="";
				String Comp="";
				String accName="";
				String accAge="";
				String status="";
				
					try
					{
						for(int i=1;i<=c;i++)
						{
							dm.removeRow(i);
						}
						
						Connection conn = DatabaseConnection.getConnected();	
						String query ="select * from fir where date=? ";
						
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,tdatev);
						
						ResultSet data = pst.executeQuery();
						
						if(data==null)
						{
							JOptionPane.showMessageDialog(Searchpan, "No Records found");
						}
						
						while(data.next())
						{
							 date = data.getString("fileddate");
							 station = data.getString("stationname");
							 firid = data.getString("firid");
							 location = data.getString("location");
							 appName = data.getString("applicantname");
							 appAdd = data.getString("applicantaddress");
							 appPh = data.getString("applicantphno");
							 Comp = data.getString("complaint");
							 accName = data.getString("accusedname");
							 accAge = data.getString("accusedage");
							 status = data.getString("status");
	 
							 
							 String tbData[] = {date,station,firid,location,appName,appAdd,appPh,Comp,accName,accAge,status}; 
							 dm.addRow(tbData);
							 
							 c= table.getRowCount()-1;
							 count.setText("No of Cases found: "+c);
							
							 sc.setVisible(true);
							 table.setVisible(true);
				
							 dmsg.setVisible(false);
							 fmsg.setVisible(false);
							 smsg.setVisible(false);
						}
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(Searchpan, "Database not connected ");
					}
				}
		});
		
		stationSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String sta = (String) station.getSelectedItem();
				String date="";
				String station="";
				String firid="";
				String location="";
				String appName="";
				String appAdd="";
				String appPh="";
				String Comp="";
				String accName="";
				String accAge="";
				String status="";
				if(sta.equals("Select Station"))
				{
					smsg.setVisible(true);
				}
				else 
				{
					
					try
					{
						for(int i=1;i<=c;i++)
						{
							dm.removeRow(i);
						}
						Connection conn = DatabaseConnection.getConnected();
						String query ="select * from fir where stationname=? ";
						
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,sta);
						
						ResultSet data = pst.executeQuery();
						
						if(data==null)
						{
							JOptionPane.showMessageDialog(Searchpan, "No Records found");
						}
						
						while(data.next())
						{
							 date = data.getString("fileddate");
							 station = data.getString("stationname");
							 firid = data.getString("firid");
							 location = data.getString("location");
							 appName = data.getString("applicantname");
							 appAdd = data.getString("applicantaddress");
							 appPh = data.getString("applicantphno");
							 Comp = data.getString("complaint");
							 accName = data.getString("accusedname");
							 accAge = data.getString("accusedage");
							 status = data.getString("status");
							
							 
							 String tbData[] = {date,station,firid,location,appName,appAdd,appPh,Comp,accName,accAge,status}; 
							 dm.addRow(tbData); 
							 c= table.getRowCount()-1;
							 count.setText("No of Cases found: "+c);
							 
							 sc.setVisible(true);
							 table.setVisible(true);
							 
							 dmsg.setVisible(false);
							 fmsg.setVisible(false);
							 smsg.setVisible(false);
			    			 
						}
						
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(Searchpan, "Database not connected ");
					}
				}
				
			}
		});

		firIdSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String fir = (String) firId.getSelectedItem();
				String date="";
				String station="";
				String firid="";
				String location="";
				String appName="";
				String appAdd="";
				String appPh="";
				String Comp="";
				String accName="";
				String accAge="";
				String status="";
				if(fir.equals("Select FIR"))
				{
					fmsg.setVisible(true);
				}
				else
				{
					
					try
					{
						for(int i=1;i<=c;i++)
						{
							dm.removeRow(i);
						}
						Connection conn = DatabaseConnection.getConnected();
						String query ="select * from fir where firid=? ";
						
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1,fir);
						
						ResultSet data = pst.executeQuery();
						
						if(data==null)
						{
							JOptionPane.showMessageDialog(Searchpan, "No Records found");
						}
						
						while(data.next())
						{
							
							 date = data.getString("fileddate");
							 station = data.getString("stationname");
							 firid = data.getString("firid");
							 location = data.getString("location");
							 appName = data.getString("applicantname");
							 appAdd = data.getString("applicantaddress");
							 appPh = data.getString("applicantphno");
							 Comp = data.getString("complaint");
							 accName = data.getString("accusedname");
							 accAge = data.getString("accusedage");
							 status = data.getString("status");
			    			 
							 
							 String tbData[] = {date,station,firid,location,appName,appAdd,appPh,Comp,accName,accAge,status}; 
							 dm.addRow(tbData);
							 c= table.getRowCount()-1;
							 count.setText("No of Cases found: "+c);
							 
							 dmsg.setVisible(false);
							 fmsg.setVisible(false);
							 smsg.setVisible(false);
							 
							 sc.setVisible(true);
							 table.setVisible(true); 
						}
						
						
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(Searchpan, "Database not connected ");
					}
				}	
			}
		});
		
		home.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e)
			 { 
	
				 sc.setVisible(false);
				 table.setVisible(false);
				 count.setText(" ");
				 
				 firId.setSelectedItem("Select FIR");
				 station.setSelectedItem("Select Station");
				 tdate.setDate(null);
				 
				 LowLevelPoliceOfficer.homeDisplay();	 
			 }
		 });
	}
	

}
