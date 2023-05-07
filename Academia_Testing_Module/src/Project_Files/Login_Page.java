//Login Page

package Project_Files;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.plaf.TextUI;
import javax.swing.*;
import Project_Files.*;

public class Login_Page extends JFrame implements  ActionListener{
		
		JFrame frame = new JFrame("Welcome Login Page "); 
		String n="  ";
		String y="  ";
		String name;
		Graphics g;
		JTextField t1;
		final JPasswordField t2;
		JButton b1,b2,b3;
		JLabel l1,l2,l3;
		ImageIcon i1,i2;
		String q1="   ";
		String q2="   ";
		
Login_Page()
{	
		//frame.setSize(1366,768);
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setSize(dim.width, dim.height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
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
	Font f2=new Font("cyrillic", Font.BOLD, 18);

	i2=new ImageIcon("Images/login.png");
	l2=new JLabel(i2);
	
	l3=new JLabel("You've entered incorrect details.");
	
	b1=new JButton("Login");
	b1.setFont(f2);
		
	b2=new JButton("Sign Up");
	b2.setFont(f2);

	b3=new JButton("Forget your password?");
	b3.setFont(f2);
			
	Font f3=new Font("cyrillic", Font.BOLD, 17);
			
	t1=new JTextField(8);
	t1.setFont(f3);
	
	t2=new JPasswordField();
	t2.setFont(f3);
			
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);

	t1.addActionListener(this);
	t2.addActionListener(this);
	
	l1.setBounds(0 ,0 ,1366,768);//background
	
	String t="Email";
	t1.setBounds(560,315,250,35);
	t1.setText(t);
	t1.setOpaque(false);
	t1.setBorder(null);
	t1.setForeground(Color.gray);
		
	t2.setBounds(560,380,250,35);
	String t0="Password";
	t2.setText(t0);
	t2.setForeground(Color.gray);
	t2.setBorder(null);
	t2.setOpaque(false);
		
	b1.setBounds(555,435,250,40);//login
	b1.setOpaque(false);
	b1.setContentAreaFilled(false);
	b1.setBorderPainted(false);
	b1.setForeground(Color.white);
				
	b2.setBounds(1118,19,120,35);//Sign Up
	b2.setOpaque(false);
	b2.setContentAreaFilled(false);
	b2.setBorderPainted(false);
	b2.setForeground(Color.white);

	b3.setBounds(555,490,250,25);//forgot
	b3.setOpaque(false);
	b3.setContentAreaFilled(false);
	b3.setBorderPainted(false);
	b3.setForeground(Color.gray);

	l2.setBounds(30,400,406,306);
	
	l3.setBounds(555,550,400,25);
	l3.setVisible(false);
	
	l1.add(t1);
	l1.add(t2);
	l1.add(b1);
	l1.add(b2);
	l1.add(b3);
	l1.add(l2);
	l1.add(l3);
	con.add(l1);
		
	frame.add(con);
	frame.setVisible(true);
	}  

	public void actionPerformed(ActionEvent ae)
	{
		String s1=ae.getActionCommand();
		if(s1.equals("Login"))
		{

			q1=t1.getText();
			q2=new String(t2.getPassword());
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
				Statement stm = co.createStatement();
				ResultSet rs= stm.executeQuery("select * from user_info");
				boolean isPresent=false;
				while(rs.next())
				{
					n=rs.getString("email");
					y=rs.getString("password");
					name = rs.getString("first_name");
					if(n.equals(q1) && y.equals(q2))
					{
						isPresent=true;
						break;
					}
				}
				if(!isPresent) {
					//new oi();
					Font f=new Font("cyrillic", Font.BOLD, 18);
					l3.setVisible(true);
					l3.setFont(f);
					l3.setForeground(Color.white);
					//System.out.println("Invalid details");
				}
				else {
					new Home_Page(name);
					frame.setVisible(false);
				}
				
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
		}
		
		
		String s2=ae.getActionCommand();
		if(s2.equals("Sign Up"))
		{
			new Signup_Page();
			frame.setVisible(false);
		}
			
		String s5=ae.getActionCommand();
		if(s5.equals("Forget your password?"))
		{
			new ForgetPass_Page();
			frame.setVisible(false);
		}	
	}
	
public static void main(String s[])
{
	new Login_Page();		
}

} 