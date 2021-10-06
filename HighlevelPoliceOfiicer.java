package crms;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

class HPofficerWindow extends JFrame{
	
	JButton create;
	JButton view;
	JButton update;
	JButton delete;
	JButton assign;
	JButton logout;
	JButton search;
	
	JLabel head;
	JLabel name;
	JLabel desg;
	JLabel station;
	JLabel icon;
	JLabel pic;
	JLabel image;
	static JLabel nameVal;
	static JLabel desgVal;
	static JLabel stationVal;
	
	static Container co;
	//Panels
	static JPanel  main;
	static JPanel firreg;
	static JPanel delpan;
	static JPanel updpan;
	static JPanel viewpan;
	static JPanel assignpan;
	static JPanel searchpan;
	
	
	//Other panel references
	FIRReg reg;
	DeleteFir del;
	UpdateFir upd;
	ViewFir viewp;
	AssignCase assp;
	SearchFir ser;
	OfficerBean obj;
	
	HPofficerWindow()
	{
		co = HomeWindow.coMain;
		
		//Main Panel
		main = new JPanel();
		main.setBackground(Color.white);
		main.setLayout(null);
		main.setVisible(true);
		
		
		//Panel objects
		reg = new FIRReg();
		firreg = reg.FirPan;
		
		del = new DeleteFir();
		delpan = del.DelPan;
		
		upd = new UpdateFir();
		updpan = upd.UpdatePan;
		
		viewp = new ViewFir();
		viewpan = viewp.ViewPan;
		
		assp = new AssignCase();
		assignpan = assp.assignpan;
		
		ser = new SearchFir();
		searchpan = ser.Searchpan;

		
		//Buttons-MainPanel
		create = new JButton("File FIR");
		view  = new JButton("View Cases");
		update = new JButton("Update FIR");
		delete  = new JButton("Delete FIR");
		assign  = new JButton("Assign Case");
		logout = new JButton("LOGOUT");
		search = new JButton("Search");
		
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
		name.setFont(new Font("Times new roman", Font.BOLD,20));
		desg.setFont(new Font("Times new roman", Font.BOLD,20));
		station.setFont(new Font("Times new roman", Font.BOLD,20));
		nameVal.setFont(new Font("Times new roman", Font.PLAIN,20));
		desgVal.setFont(new Font("Times new roman", Font.PLAIN,20));
		stationVal.setFont(new Font("Times new roman", Font.PLAIN,20));
		
		//Buttons
		create.setBounds(920, 120,120,30);
		view.setBounds(920, 160,120,30);
		update.setBounds(920, 200,120,30);
		delete.setBounds(1050, 120,120,30);
		assign.setBounds(1050, 160,120,30);
		search.setBounds(1050,200,120,30);
		logout.setBounds(47,300,120,30);
		
		create.setFont(new Font("Verdana", Font.BOLD,12));
		view.setFont(new Font("Verdana", Font.BOLD,12));
		update.setFont(new Font("Verdana", Font.BOLD,12));
		delete.setFont(new Font("Verdana", Font.BOLD,12));
		assign.setFont(new Font("Verdana", Font.BOLD,12));
		search.setFont(new Font("Verdana", Font.BOLD,12));
		logout.setFont(new Font("Verdana", Font.BOLD,12));
		
		//Labels
		head.setBounds(530,20,500,30);
		name.setBounds(270,120,190,30);
		desg.setBounds(270,180,190,30);
		station.setBounds(270,240,190,30);
		nameVal.setBounds(450,120,190,30);
		desgVal.setBounds(450,180,230,30);
		stationVal.setBounds(450,240,190,30);
		image.setBounds(20,100,180,180);
		
		nameVal.setForeground(new Color(30,30,180));
		desgVal.setForeground(new Color(30,30,180));
		stationVal.setForeground(new Color(30,30,180));
		
		
		logout.setBackground(new Color(10,30,90));
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("verdana", Font.BOLD,15));
		
		
		main.add(create);
		main.add(view);
		main.add(update);
		main.add(delete);
		main.add(assign);	
		main.add(desg);
		main.add(name);
		main.add(head);
		main.add(station);
		main.add(image);
		main.add(logout);
		main.add(search);
		main.add(stationVal);
		main.add(nameVal);
		main.add(desgVal);
		
		
		//EventListeners
		create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				firreg.setVisible(true);
				main.setVisible(false);
				updpan.setVisible(false);
				viewpan.setVisible(false);
				assignpan.setVisible(false);
				delpan.setVisible(false);
				searchpan.setVisible(false);
				
				co.add(firreg);
				
			}
		});
		
		view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				main.setVisible(false);
				updpan.setVisible(false);
				firreg.setVisible(false);
				viewpan.setVisible(true);
				assignpan.setVisible(false);
				delpan.setVisible(false);
				searchpan.setVisible(false);
				
				co.add(viewpan);
				
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				main.setVisible(false);
				updpan.setVisible(true);
				firreg.setVisible(false);
				viewpan.setVisible(false);
				assignpan.setVisible(false);
				delpan.setVisible(false);
				searchpan.setVisible(false);
				
				co.add(updpan);
				
				
			}
		});
		
			assign.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					main.setVisible(false);
					updpan.setVisible(false);
					firreg.setVisible(false);
					viewpan.setVisible(false);
					assignpan.setVisible(true);
					delpan.setVisible(false);
					searchpan.setVisible(false);
					
					co.add(assignpan);
					
				}
			});
			
			delete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					delpan.setVisible(true);
					firreg.setVisible(false);
					main.setVisible(false);
					updpan.setVisible(false);
					viewpan.setVisible(false);
					assignpan.setVisible(false);
					searchpan.setVisible(false);
					
					co.add(delpan);
					
				}
			});	
			
			search.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					delpan.setVisible(false);
					firreg.setVisible(false);
					main.setVisible(false);
					updpan.setVisible(false);
					viewpan.setVisible(false);
					assignpan.setVisible(false);
					searchpan.setVisible(true);
					
					co.add(searchpan);
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
			delpan.setVisible(false);
			firreg.setVisible(false);
			main.setVisible(true);
			updpan.setVisible(false);
			viewpan.setVisible(false);
			assignpan.setVisible(false);
			searchpan.setVisible(false);
			
		}
		
		public static void getData(OfficerBean obj)
		{
			nameVal.setText(obj.getOfficerName());
			desgVal.setText(obj.getDesignation());
			stationVal.setText(obj.getStation());
		}
}

public class HighlevelPoliceOfiicer {

	public static void main(String[] args)
	{
		new HPofficerWindow();
	}
}
