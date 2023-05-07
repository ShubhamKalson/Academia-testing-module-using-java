//USER PROFILE
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

public class Profile_Page extends JFrame implements ActionListener {
	JFrame frame=new JFrame("USER PROFILE");
	String s1="  ";
	String s2="   ";
	String s3="    ";
	String s4="   ";
	String s5="   ";
	String s6="   ";
	String s7="   ";
	String s8="   ";
	String s9="   ";
	String s10="   ";
	String s11="   ";
	String s12="   ";
	String s13="   ";
	String s14="   ";
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l9,l10,l11,l12,l19;
ImageIcon i1;
	String f_name;
	Profile_Page(String f_name)
	{
		this.f_name= f_name;
		frame.setSize(1366,768);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we)
			{
			System.exit(0);
			}
		});
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
		Statement stm = co.createStatement();
			ResultSet rs= stm.executeQuery("select * from user_info where first_name='"+f_name+"'");
			while(rs.next())
			{
				s1=rs.getString("first_name");
				s2=rs.getString("last_name");
				s3=rs.getString("password");
				s4=rs.getString("gender");
				s5=rs.getString("dob");
				s6=rs.getString("email");
				s7=rs.getString("contact_no");
				s8=rs.getString("mother_name");
				s9=rs.getString("father_name");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Container con=getContentPane();
		con.setLayout(null);
		l1=new JLabel("First Name :");
		l2=new JLabel(s1);
		l3=new JLabel("Last Name :");
		l4=new JLabel(s2);
		l5=new JLabel("Password:");
		l6=new JLabel(s3);
		l9=new JLabel("Date of Birth:");
		l10=new JLabel(s5);
		l11=new JLabel("Email :");
		l12=new JLabel(s6);
		i1=new ImageIcon("Images/BG3.png");
		l19=new JLabel(i1);
		
		b1=new JButton("Change Details");
		b2=new JButton("Home");
		Font f=new Font("cyrillic", Font.BOLD, 20);
		Font f1=new Font("cyrillic", Font.BOLD, 19);
		l1.setFont(f);
		l1.setForeground(Color.gray);
		l2.setFont(f1);
		l2.setForeground(Color.gray);
		l3.setFont(f);
		l3.setForeground(Color.gray);
		l4.setFont(f1);
		l4.setForeground(Color.gray);
		l5.setFont(f);
		l5.setForeground(Color.gray);
		l6.setFont(f1);
		l6.setForeground(Color.gray);
		l9.setFont(f);
		l9.setForeground(Color.gray);
		l10.setFont(f1);
		l10.setForeground(Color.gray);
		l11.setFont(f);
		l11.setForeground(Color.gray);
		l12.setFont(f1);
		l12.setForeground(Color.gray);
		Font f3=new Font("cyrillic", Font.BOLD, 12);
		b1.setFont(f3);
		b1.setForeground(Color.black);
		b1.setBackground(Color.lightGray);
		Font f2=new Font("cyrillic", Font.BOLD, 18);
		b2.setFont(f2);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setForeground(Color.white);
		b2.setBounds(1118,19,120,35);
		
		b1.setFont(f2);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setForeground(Color.white);
		
		b2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.setBounds(560,647,200,30);//change details
	
		l1.setBounds(450,195,250,25);
		l3.setBounds(450,285,250,25);
		l5.setBounds(450,375,250,25);
		l9.setBounds(450,472,250,25);
		l11.setBounds(450,565,250,25);
		
		l2.setBounds(640,195,200,25);
		l4.setBounds(640,285,200,25);
		l6.setBounds(640,375,200,25);
		l10.setBounds(640,472,200,25);
		l12.setBounds(640,565,200,25);
		l19.setBounds(0,0,1366,768);
		
		
		
		l19.add(l1);
		l19.add(l2);
		l19.add(l3);
		l19.add(l4);
		l19.add(l5);
		l19.add(l6);
		l19.add(l9);
		l19.add(l10);
		l19.add(l11);
		l19.add(l12);

		
		l19.add(b1);
		l19.add(b2);
		con.add(l19);
		frame.add(con);
	frame.setVisible(true);
	}

public void actionPerformed(ActionEvent ae)
{
	String b1=ae.getActionCommand();
	
	if(b1.equals("Home"))
		{
		new Home_Page(f_name);
		frame.setVisible(false);
		}
String b2=ae.getActionCommand();
	
	if(b2.equals("Change Details"))
		{
		new Change_Details(f_name);
		frame.setVisible(false);
		}
}

}
