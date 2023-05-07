//FORGET PASSWORD

package Project_Files;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class ForgetPass_Page extends JFrame implements ActionListener {

	JFrame frame=new JFrame("FORGET PASSWORD");
	JLabel l1,l2,l4,l5,l6;
	JTextField t1,t2;
	JButton b1,b2;
	ImageIcon i1;

	String n="   ";
	String m="   ";
	String y="  ";
	String q1="   ";
	String q2="   ";
ForgetPass_Page()
{
		 frame.setSize(1366,768);
		 addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we)
					{
					System.exit(0);
					}
				});
				Container con=getContentPane();
				con.setLayout(null);
				
				i1=new ImageIcon("Images/BG2.png");
				l1=new JLabel(i1);
				
				t1=new JTextField(8);
//				t1.setOpaque(false);
				t2=new JTextField("ddmmyyyy");
				b2=new JButton("Home");
				b1=new JButton("Submit");
				b1.addActionListener(this);
				b2.addActionListener(this);
				t1.addActionListener(this);
				t2.addActionListener(this);
				Font f=new Font("cyrillic", Font.BOLD, 17);
				
				l2=new JLabel("Kindly insert Date of Birth in format : DDMMYYYY");
				l2.setFont(f);
				l2.setForeground(Color.gray);

				l2.setBounds(500,620,500,30);
				l2.setVisible(true);
				
				
				
				l1.setBounds(0,0,1366,768);
				b1.setBounds(1100,650,80,30);//back
				b2.setBounds(530,230,100,30);//submit
				t1.setBounds(520,105,300,25);
				t2.setBounds(520,155,150,25);
				t1.setOpaque(false);
				t2.setOpaque(false);
				t1.setFont(f);
				t2.setFont(f);
				b1.setFont(f);
				b1.setBounds(555,435,250,40);//Submit
				b1.setOpaque(false);
				b1.setContentAreaFilled(false);
				b1.setBorderPainted(false);
				b1.setForeground(Color.white);
				
				b2.setFont(f);
				b2.setBounds(1118,19,120,35);//Home
				b2.setOpaque(false);
				b2.setContentAreaFilled(false);
				b2.setBorderPainted(false);
				b2.setForeground(Color.white);

				String t="Email";
				t1.setBounds(560,315,250,35);
				t1.setText(t);
				t1.setOpaque(false);
				t1.setBorder(null);
				t1.setForeground(Color.gray);
					
				t2.setBounds(560,380,250,35);
				String t0="Date of birth";
				t2.setText(t0);
				t2.setForeground(Color.gray);
				t2.setBorder(null);
				t2.setOpaque(false);
				
				
				l4=new JLabel("Your current password is :" +y);
				l4.setBounds(535, 535, 500, 30);
				l1.add(l4);
				l4.setVisible(false);
				l5=new JLabel("You have entered incorrect details.");
				l5.setBounds(535, 535, 500, 30);
				l1.add(l5);
				l5.setVisible(false);
				l1.add(b1);
				l1.add(l2);
				l1.add(b2);
				l1.add(t1);
				l1.add(t2);
				con.add(l1);
				frame.add(con);
				frame.setVisible(true);
	 }
	 public void actionPerformed(ActionEvent ae)
		{
			String s1=ae.getActionCommand();
			String s2=ae.getActionCommand();
			
			if(s1.equals("Home"))
				{
				new Login_Page();
				frame.setVisible(false);
				}
			if(s2.equals("Submit"))
			{
			q1=t1.getText();
			 q2=t2.getText();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
			Statement stm = co.createStatement();
				ResultSet rs= stm.executeQuery("select * from user_info");
				while(rs.next())
				{
					n=rs.getString("email");
					m=rs.getString("dob");
					y=rs.getString("password");
			
			}
			}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			if(n.equals(q1) && m.equals(q2))
				
			{
			Font f=new Font("cyrillic", Font.BOLD, 18);
			l5.setVisible(false);
			l4.setVisible(true);
			l4.setFont(f);
			l4.setForeground(Color.gray);
			l6=new JLabel(y);
			l6.setFont(f);
			l6.setForeground(Color.gray);
			l1.add(l6);
			l6.setBounds(775, 535, 200, 30);	
		
			}
			
			else
			{
				Font f=new Font("cyrillic", Font.BOLD, 18);
				l5.setVisible(true);
				l5.setFont(f);
				l5.setForeground(Color.gray);
			
			}
			}
		}
	 

	}

