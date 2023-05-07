//Home-Page

package Project_Files;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import Project_Files.*;
public class Home_Page extends JFrame implements ActionListener
{

	JFrame frame=new JFrame("HOME PAGE");
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	ImageIcon i1,i2,i3,i4,i5,i6;
	String f_name;
	
Home_Page(String f_name)
	{
		this.f_name=f_name;
		frame.setSize(1366,768);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we)
			{
			System.exit(0);
			}
		});
		Container con=getContentPane();
		con.setLayout(null);	
		l1=new JLabel("Welcome "+ f_name);
		
		i1=new ImageIcon("Images/Home_Page.png");
		l2=new JLabel(i1);//bg

		i2=new ImageIcon("Images/c.png");
		b1=new JButton("c",i2);//c++
		l3=new JLabel("C++");
		
		i3=new ImageIcon("Images/python.jpg");
		b2=new JButton("p",i3);//python
		l4=new JLabel("Python");
		
		i4=new ImageIcon("Images/sql.png");
		b3=new JButton("s",i4);//sql
		l5=new JLabel("MySQL");
		
		i5=new ImageIcon("Images/java.png");
		b4=new JButton("j",i5);//java
		l6=new JLabel("Java");
		
		
		i6=new ImageIcon("Images/gk.png");
		b5=new JButton("q",i6);//gk
		l7=new JLabel("GK");
		
		
		b6=new JButton("Profile");
		b7=new JButton("Sign Out");
		b8=new JButton("My Score");
		
		Font f1=new Font("cyrillic", Font.BOLD, 20);
		l1.setFont(f1);
		l1.setForeground(Color.gray);
		l2.setFont(f1);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		Font f3=new Font("cyrillic", Font.BOLD, 18);
		
		b6.setFont(f3);
		b6.setOpaque(false);
		b6.setContentAreaFilled(false);
		b6.setBorderPainted(false);
		b6.setForeground(Color.gray);
		
		b7.setFont(f3);
		b7.setOpaque(false);
		b7.setContentAreaFilled(false);
		b7.setBorderPainted(false);
		b7.setForeground(Color.white);
		
		b8.setFont(f3);
		b8.setOpaque(false);
		b8.setContentAreaFilled(false);
		b8.setBorderPainted(false);
		b8.setForeground(Color.gray);

		l1.setBounds(620,70,300,70);
		l2.setBounds(0,0,1366,768);
		
		b1.setBounds(250,170,190,190); //C++
		l3.setBounds(320,380,190,25);
		l3.setFont(f1);
		l3.setForeground(Color.gray);
		
		b2.setBounds(600,170,190,190); //Python
		l4.setBounds(660,380,190,25);
		l4.setFont(f1);
		l4.setForeground(Color.gray);
		
		b4.setBounds(950,170,190,190); // java
		l6.setBounds(1020,380,190,25);
		l6.setFont(f1);
		l6.setForeground(Color.gray);
		
		b3.setBounds(425,430,190,190); // sql
		l5.setBounds(495,635,190,25);
		l5.setFont(f1);
		l5.setForeground(Color.gray);
		
		b5.setBounds(775,430,190,190);	//gk
		l7.setBounds(850,635,190,25);
		l7.setFont(f1);
		l7.setForeground(Color.gray);
		
		b6.setBounds(820,22,120,30);
		b7.setBounds(1118,19,120,35);
		b8.setBounds(950,22,120,30);

		l2.add(l1);
		l2.add(l3);
		l2.add(l4);
		l2.add(l5);
		l2.add(l6);
		l2.add(l7);
		l2.add(b1);
		l2.add(b2);
		l2.add(b3);
		l2.add(b4);
		l2.add(b5);
		l2.add(b6);
		l2.add(b7);
		l2.add(b8);
		con.add(l2);
		frame.add(con); 
		frame.setVisible(true);  
	}
		
		public void actionPerformed(ActionEvent ae)
		{
			String s1=ae.getActionCommand();
			String s2=ae.getActionCommand();
			String s3=ae.getActionCommand();
			String s4=ae.getActionCommand();
			String s5=ae.getActionCommand();
			String s6=ae.getActionCommand();
			String s7=ae.getActionCommand();
			String s8=ae.getActionCommand();
			if(s1.equals("q"))
				{
				new Instruction_Page("gk",f_name);//gk
				frame.setVisible(false);
				}
			if(s2.equals("c"))
			{

				new Instruction_Page("c",f_name);
				frame.setVisible(false);
			}
			if(s3.equals("p"))
			{

				new Instruction_Page("python",f_name);
				frame.setVisible(false);
			}
			if(s4.equals("s"))
			{

				new Instruction_Page("sq",f_name);//sql
				frame.setVisible(false);
			}
			if(s5.equals("j"))
			{

				new Instruction_Page("java",f_name);//java
				frame.setVisible(false);
			}
		
			if(s6.equals("Sign Out"))
			{
				new Login_Page();
				frame.setVisible(false);
			}
		if(s7.equals("Profile"))
		{
			new Profile_Page(f_name);
			frame.setVisible(false);
		}
		if(s8.equals("My Score"))
		{
		new Score_Page(f_name);
		frame.setVisible(false);
		}
				}

}
