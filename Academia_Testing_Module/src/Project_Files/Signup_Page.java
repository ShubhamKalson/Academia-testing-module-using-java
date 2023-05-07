//REGISTRATION FORM

package Project_Files;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import Project_Files.Validation;

public class Signup_Page extends JFrame implements ActionListener
{
	String msg="  ";
	JFrame frame=new JFrame("REGISTRATION FORM");
	JLabel l10,l2,l3;
	JButton b1,b2;
	JTextField t1,t2,t3,t8,t9;
	ButtonGroup bg;
	ImageIcon i1,i2;
	String password= "    ";
	String email= "     ";
	ButtonGroup group;
	
	Signup_Page()
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
		
		i1=new ImageIcon("Images/Signup_BG.png");
		l10=new JLabel(i1);
		i2=new ImageIcon("Images/Sign_up.png");
		l3=new JLabel(i2);
		t1=new JTextField("First Name");
		t2=new JTextField("Last Name");
		t3=new JTextField("dd-mm-yyyy");
		t8=new JTextField("Email");
		t9=new JTextField("Password");
	      Font f=new Font("cyrillic", Font.BOLD, 17);
		l2=new JLabel("Kindly insert Date of Birth in format : DD-MM-YYYY");
		l2.setFont(f);
		l2.setForeground(Color.gray);

		l2.setBounds(500,620,500,30);
		l2.setVisible(true);

      Font f2=new Font("cyrillic", Font.BOLD, 18);

		b1=new JButton("Sign Up");
		b1.setFont(f2);
		b1.setForeground(Color.BLACK);
		b2=new JButton("Home");
		b2.setFont(f2);
		b2.setForeground(Color.BLACK);
		bg= new ButtonGroup();
		b1.addActionListener(this);
		b2.addActionListener(this);
		t1.addActionListener(this);
		t2.addActionListener(this);
		t3.addActionListener(this);
		t8.addActionListener(this);
		t9.addActionListener(this);
	
		t1.setBounds(122,255,250,30);//first name
		t2.setBounds(990,255,250,30);//last name
		t3.setBounds(560,450,250,30);//dob
		t8.setBounds(330,350,250,30);//email
		t9.setBounds(785,350,250,30);//password
		 
		b1.setBounds(580,530,200,30);//sign up
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setForeground(Color.white);
		
		b2.setBounds(1118,19,120,35);//Home
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setForeground(Color.white);
		
		l3.setBounds(30,400,406,306);
		
		t1.setOpaque(false);
		t2.setOpaque(false);
		t3.setOpaque(false);

		t8.setOpaque(false);
		t9.setOpaque(false);
		Font f3=new Font("cyrillic", Font.BOLD, 18);
		b1.setFont(f3);
		b2.setFont(f3);
		t1.setFont(f3);
		t1.setForeground(Color.WHITE);
		t2.setFont(f3);
		t2.setForeground(Color.WHITE);
		t3.setFont(f3);
		t3.setForeground(Color.WHITE);

		t8.setFont(f3);
		t8.setForeground(Color.WHITE);
		t9.setFont(f3);
		t9.setForeground(Color.WHITE);
		
		String t="First Name";
		t1.setText(t);
		t1.setOpaque(false);
		t1.setBorder(null);
		t1.setForeground(Color.gray);
			
		
		String t0="Last Name";
		t2.setText(t0);
		t2.setForeground(Color.gray);
		t2.setBorder(null);
		t2.setOpaque(false);
		
		String ta="Email";
		t8.setText(ta);
		t8.setOpaque(false);
		t8.setBorder(null);
		t8.setForeground(Color.gray);
			
		
		String tb="Password";
		t9.setText(tb);
		t9.setForeground(Color.gray);
		t9.setBorder(null);
		t9.setOpaque(false);
		
		String tc="Date of birth";
		t3.setText(tc);
		t3.setOpaque(false);
		t3.setBorder(null);
		t3.setForeground(Color.gray);

		l10.setBounds(0,0,1366,768);
		l10.add(l3);
		l10.add(l2);
		l10.add(t1);
		l10.add(t2);
		l10.add(t3);
		l10.add(t8);
		l10.add(t9);
		l10.add(b1);
		l10.add(b2);
		con.add(l10);
		frame.add(con);
		frame.setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=ae.getActionCommand();
		
		if(s1.equals("Sign Up"))
			{
			
			msg="Details submitted";
			String[] str=new String[9];
			str[0] = t1.getText(); 	//first name 
			str[1] = t2.getText(); 	//last name
			str[2]= t9.getText();	//password
			str[3] ="male";		//gender
			str[4] = t3.getText();		//dob
			str[5]= t8.getText();     //email
			
			str[6]= "9882060572";	//contact
			str[7]= "abcd"; 	//mother's name
			str[8]= "abcd";	//father's naem

			if(Check.all_ok(str)) {
			try
			{			
				
//				Long contact_no = new Long(contact_no1);
				
				int java_s= 0;
				int c_s= 0;
				int gk_s= 0;
				int sql_s= 0;
				int python_s=0;
				String dob_new="";
				dob_new+=str[4].substring(0,2);
				dob_new+=str[4].substring(3,5);
				dob_new+=str[4].substring(6,10);
				
				//database connection
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
				Statement stm = con.createStatement();
				String query = "insert into user_info values(null,'"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+dob_new+"','"+str[5]+"','"+str[6]+"','"+str[7]+"','"+str[8]+"','"+java_s+"','"+c_s+"','"+sql_s+"','"+gk_s+"','"+python_s+"')";
				int check = stm.executeUpdate(query);
				if(check>0)
				{
					System.out.println("Successfully registered");
					
				}
				else
				{
					System.out.println("Not Registered try again");
				}		
				
				
			}
			catch(Exception e)
			{
				
				System.out.println(e);
			}
			new Successful_Registration(str[5]);
			frame.setVisible(false);
			}
			}
		String s2=ae.getActionCommand();
		if(s2.equals("Home"))
			{
			new Login_Page();
			frame.setVisible(false);
			}
	}
}


