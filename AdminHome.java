package crms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.sql.*;


public class AdminHome extends JFrame {
	
	//Buttons
	JButton create,update,delete,view,logout;
	
	//labels
	JLabel head,head2,image;
	
	//Panel
	static JPanel home;
	static JPanel createpan;
	static JPanel viewpan;
	static JPanel updatepan;
	static JPanel deletepan;
	
	//other class references
	CreateOfficer coff;
	UpdateOfficer uoff;
	DeleteOfficer doff;
	ViewOfficer voff;
	
	
	static Container co;
	
	AdminHome()
	{
		co = HomeWindow.coMain;
		
		home = new JPanel();
		home.setLayout(null);
		home.setBackground(Color.WHITE);
		home.setVisible(true);
		
		coff = new CreateOfficer();
		createpan = coff.Offcreg;
		
		uoff = new UpdateOfficer();
		updatepan = uoff.updpan;
		
		doff = new DeleteOfficer();
		deletepan = doff.delpan;
		
		voff = new ViewOfficer();
		viewpan = voff.viewpan;
		
		
		//labels
		head = new JLabel("TamilNadu Police Department");
		head.setFont(new Font("Times new roman",Font.BOLD,30));
		head.setBounds(530,0,500,30);
		head2 = new JLabel("Admin Panel");
		head2.setBounds(660,50,200,30);
		head2.setFont(new Font("Times new roman",Font.PLAIN,25));
		
		//image
		image = new JLabel(new ImageIcon("D:\\Kishore\\tnpd.jpg"));
		image.setBounds(450,170,500,500);
		
		
		//buttons
		create = new JButton("Create Officer");
		update = new JButton("Update Officer");
		delete = new JButton("Delete Officer");
		view  = new JButton("View Details");
		logout = new JButton("Logout");
		
		create.setBounds(300,170,200,40);
		update.setBounds(530,170,200,40);
		delete.setBounds(760,170,200,40);
		view.setBounds(990,170,200,40);
		logout.setBounds(30,30,100,40);
		
		logout.setBackground(new Color(10,30,90));
		create.setBackground(new Color(10,150,120));
		delete.setBackground(new Color(10,150,120));
		view.setBackground(new Color(10,150,120));
		update.setBackground(new Color(10,150,120));
		
		logout.setFont(new Font("Verdana",Font.PLAIN,15));
		create.setFont(new Font("Verdana",Font.PLAIN,20));
		delete.setFont(new Font("Verdana",Font.PLAIN,20));
		view.setFont(new Font("Verdana",Font.PLAIN,20));
		update.setFont(new Font("Verdana",Font.PLAIN,20));
		
		logout.setForeground(Color.WHITE);
		create.setForeground(Color.WHITE);
		delete.setForeground(Color.WHITE);
		view.setForeground(Color.WHITE);
		update.setForeground(Color.WHITE);
		
		home.add(create);
		home.add(update);
		home.add(delete);
		home.add(view);
		home.add(head);
		home.add(logout);
		home.add(head2);
		home.add(image);
		
		create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				home.setVisible(false);
				createpan.setVisible(true);
				viewpan.setVisible(false);
				updatepan.setVisible(false);
				deletepan.setVisible(false);
				
				co.add(createpan);
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				home.setVisible(false);
				createpan.setVisible(false);
				viewpan.setVisible(false);
				updatepan.setVisible(true);
				deletepan.setVisible(false);
				
				co.add(updatepan);
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				home.setVisible(false);
				createpan.setVisible(false);
				viewpan.setVisible(false);
				updatepan.setVisible(false);
				deletepan.setVisible(true);
				
				co.add(deletepan);
			}
		});
		view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				home.setVisible(false);
				createpan.setVisible(false);
				viewpan.setVisible(true);
				updatepan.setVisible(false);
				deletepan.setVisible(false);
				
				co.add(viewpan);
			}
		});
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AdminLogin.AdminDisplay();
			}
		});
	}

	public static void AdminDisplay()
	{
		home.setVisible(true);
		createpan.setVisible(false);
		viewpan.setVisible(false);
		updatepan.setVisible(false);
		deletepan.setVisible(false);
		
	}
}
