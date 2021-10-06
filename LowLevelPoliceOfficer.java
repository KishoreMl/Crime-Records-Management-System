package crms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class LowLevelPoliceOfficer extends JFrame {
	
	//Labels
	JLabel head,name,desg,station,image;
	static JLabel nameVal,desgVal,stationVal;
	
	//BUttons
	JButton file,view,search,va,logout;
	
	//container
	static Container co;
	
	//Panels
	static JPanel lmain;
	static JPanel firreg;
	static JPanel viewpan;
	static JPanel searchpan;
	static JPanel assignpan;
	
	//Other panel references
	ViewFirl viewp;
	CaseAssigned assp;
	SearchFirl ser;
	FIRRegl reg;
	static OfficerBean low;
	
	
	
	LowLevelPoliceOfficer() throws IOException
	{
		
		co = HomeWindow.coMain;
		
		//Main Panel
		lmain = new JPanel();
		lmain.setBackground(Color.white);
		lmain.setLayout(null);
		lmain.setVisible(true);
		
		//Panel objects
		reg = new FIRRegl();
		firreg = reg.FirPan;
		
		viewp = new ViewFirl();
		viewpan = viewp.ViewPan;
		
		assp = new CaseAssigned();
		assignpan = assp.caseAssignpan;
		
		ser = new SearchFirl();
		searchpan = ser.Searchpan;
		
		
		//Buttons
		view=new JButton("View");
		search=new JButton("Search");
		va=new JButton("Assigned cases");
		file=new JButton("File FIR");
		logout = new JButton("Logout");
		
		file.setBounds(900,100,150,30);
		view.setBounds(900,150,150,30);
		search.setBounds(900,200,150,30);
		va.setBounds(900,250,150,30);
		logout.setBounds(47,300,120,30);
		
		logout.setBackground(new Color(10,30,90));
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("verdana", Font.BOLD,15));
		
		//Labels
		head = new JLabel("Tamilnadu Department of Police");
		name = new JLabel("Name of the officer: ");
		desg = new JLabel("Designation: ");
		station  = new JLabel("Current Station: ");
		nameVal = new JLabel();
		desgVal = new JLabel();
		stationVal = new JLabel();
	
		//Image
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		
		head.setFont(new Font("Times new roman", Font.BOLD,30));
		station.setFont(new Font("Times new roman", Font.BOLD,20));
		name.setFont(new Font("Times new roman", Font.BOLD,20));
		desg.setFont(new Font("Times new roman", Font.BOLD,20));
		stationVal.setFont(new Font("Times new roman", Font.PLAIN,20));
		nameVal.setFont(new Font("Times new roman", Font.PLAIN,20));
		desgVal.setFont(new Font("Times new roman", Font.PLAIN,20));
		
		nameVal.setForeground(new Color(30,30,180));
		desgVal.setForeground(new Color(30,30,180));
		stationVal.setForeground(new Color(30,30,180));
		
		head.setBounds(530,20,500,30);
		name.setBounds(270,120,190,30);
		desg.setBounds(270,180,190,30);
		station.setBounds(270,240,190,30);
		nameVal.setBounds(450,120,190,30);
		desgVal.setBounds(450,180,190,30);
		stationVal.setBounds(450,240,190,30);
		image.setBounds(20,100,180,180);
	
		
		//adding components to panel
		lmain.add(va);
		lmain.add(view);
		lmain.add(search);
		lmain.add(file);
		lmain.add(logout);
		lmain.add(name);
		lmain.add(desg);
		lmain.add(station);
		lmain.add(head);
		lmain.add(image);
		lmain.add(nameVal);
		lmain.add(desgVal);
		lmain.add(stationVal);
		
		
		//Event Listeners
		file.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				firreg.setVisible(true);
				lmain.setVisible(false);
				viewpan.setVisible(false);
				assignpan.setVisible(false);
				searchpan.setVisible(false);
				
				co.add(firreg);
			}
		});
		
		view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				firreg.setVisible(false);
				lmain.setVisible(false);
				viewpan.setVisible(true);
				assignpan.setVisible(false);
				searchpan.setVisible(false);
				
				co.add(viewpan);
				
				
			}
		});
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				firreg.setVisible(false);
				lmain.setVisible(false);
				viewpan.setVisible(false);
				assignpan.setVisible(false);
				searchpan.setVisible(true);
				
				co.add(searchpan);
				
				
			}
		});
		
		va.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				firreg.setVisible(false);
				lmain.setVisible(false);
				viewpan.setVisible(false);
				assignpan.setVisible(true);
				searchpan.setVisible(false);
				
				co.add(assignpan);
				
			}
		});
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				HomeWindow.HomeScreen();
			}
		});
			
	}
	
	public static void homeDisplay()
	{
		
		firreg.setVisible(false);
		lmain.setVisible(true);
		viewpan.setVisible(false);
		assignpan.setVisible(false);
		searchpan.setVisible(false);
		
		co.add(lmain);
	}
	
	public static void getData(OfficerBean obj)
	{
		CaseAssigned.getData(obj);
		nameVal.setText(obj.getOfficerName());
		desgVal.setText(obj.getDesignation());
		stationVal.setText(obj.getStation());
	}
	
	public static void main(String[] args) throws IOException
	{
		new LowLevelPoliceOfficer();

	}

}

