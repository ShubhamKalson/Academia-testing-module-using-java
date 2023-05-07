//UPDATE DETAILS

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

public class Change_Details extends JFrame implements ActionListener {
	JFrame frame=new JFrame("UPDATE DETAILS");
	String s1="  ";
	String s2="   ";
	String s3="    ";
	String s5="   ";
	String s6="   ";
	String s10="   ";
	String s11="   ";
	String s12="   ";
	String s13="   ";
	String s14="   ";
	JButton b1,b2;
	JLabel l1,l2,l3,l5,l6,l9;
	JTextField t1,t2,t3,t5,t6;
ImageIcon i1;
	String f_name;
	Change_Details(String f_name)
	{
		this.f_name=f_name;
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
			ResultSet rs= stm.executeQuery("select * from user_info");
			while(rs.next())
			{
				s1=rs.getString("first_name");
				s2=rs.getString("last_name");
				s3=rs.getString("password");
				s5=rs.getString("dob");
				s6=rs.getString("email");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Container con=getContentPane();
		con.setLayout(null);
		Font f=new Font("cyrillic", Font.BOLD, 18);
		l1=new JLabel("First Name :");
		t1=new JTextField(s1);
		l2=new JLabel("Last Name :");
		t2=new JTextField(s2);
		l3=new JLabel("Password:");
		t3=new JTextField(s3);
		l5=new JLabel("Date of Birth:");
		t5=new JTextField(s5);
		l6=new JLabel("Email :");
		t6=new JTextField(s6);
	    b1=new JButton("Change details");
		b2=new JButton("Home");
		i1=new ImageIcon("Images/BG3.png");
		l9=new JLabel(i1);
		l1.setFont(f);
		l1.setForeground(Color.gray);
		l2.setFont(f);
		l2.setForeground(Color.gray);
		l3.setFont(f);
		l3.setForeground(Color.gray);

		l5.setFont(f);
		l5.setForeground(Color.gray);
		l6.setFont(f);
		l6.setForeground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		t1.addActionListener(this);
		t2.addActionListener(this);
		t3.addActionListener(this);
		t5.addActionListener(this);
		t6.addActionListener(this);

		b1.setBounds(560,647,200,30);//change details
		
		Font f2=new Font("cyrillic", Font.BOLD, 18);
		b1.setFont(f2);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setForeground(Color.white);
		
		b2.setFont(f2);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setForeground(Color.white);
		b2.setBounds(1118,19,120,35);
		

		l1.setBounds(450,195,250,25);
		l2.setBounds(450,285,250,25);
		l3.setBounds(450,375,250,25);
		l5.setBounds(450,472,250,25);
		l6.setBounds(450,565,250,25);
		
		t1.setBounds(640,195,200,25);
		t2.setBounds(640,285,200,25);
		t3.setBounds(640,375,200,25);
		t5.setBounds(640,472,200,25);
		t6.setBounds(640,565,200,25);
		
		t1.setFont(f2);
		String t0=s1;
		t1.setText(t0);
		t1.setForeground(Color.black);
		t1.setBorder(null);
		t1.setOpaque(false);
		
		t2.setFont(f2);
		String ta=s2;
		t2.setText(ta);
		t2.setForeground(Color.black);
		t2.setBorder(null);
		t2.setOpaque(false);
		
		t3.setFont(f2);
		String tb=s3;
		t3.setText(tb);
		t3.setForeground(Color.black);
		t3.setBorder(null);
		t3.setOpaque(false);
		
		t5.setFont(f2);
		String tc=s5;
		t5.setText(tc);
		t5.setForeground(Color.black);
		t5.setBorder(null);
		t5.setOpaque(false);
		
		t6.setFont(f2);
		String td=s6;
		t6.setText(td);
		t6.setForeground(Color.black);
		t6.setBorder(null);
		t6.setOpaque(false);
		
		l9.setBounds(0,0,1366,768);
		
		l9.add(l1);
		l9.add(l2);
		l9.add(l3);
		l9.add(l5);
		l9.add(l6);
	    l9.add(t1);
		l9.add(t2);
		l9.add(t3);
		l9.add(t5);
		l9.add(t6);

		l9.add(b1);
		l9.add(b2);
		con.add(l9);
		frame.add(con);
	frame.setVisible(true);
	}

public void actionPerformed(ActionEvent ae)
{
	
	
	String b1=ae.getActionCommand();
	String b2=ae.getActionCommand();
	if(b1.equals("Home"))
		{
		new Home_Page(f_name);
		frame.setVisible(false);
		}

	
	if(b2.equals("Change details"))
		{
		String dob = t5.getText();
		//boolean date_ok=isDatevalid(dob);
		try
		{
		String f_name = t1.getText();
		String l_name = t2.getText();
		String password= t3.getText();
		String gender= "female";
		String email = t6.getText();
//		int contact_no1= Integer.parseInt(t7.getText());
		String contact_no="9882060572";
//		Long contact_no = new Long(contact_no1);
		String m_name= "abcd";
		String fa_name= "abcd";
		String dob_new=t5.getText();
//		dob_new+=dob.substring(0,2);
//		dob_new+=dob.substring(3,5);
//		dob_new+=dob.substring(6,10);
		Class.forName("com.mysql.jdbc.Driver");
		Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
		Statement stm = co.createStatement();
		
		String updateCount = "update user_info SET first_name ='"+f_name+"',last_name ='"+l_name+"',password ='"+password+"',gender ='"+gender+"',dob ='"+dob_new+"',email ='"+email+"',contact_no ='"+contact_no+"',mother_name ='"+m_name+"',father_name ='"+fa_name+"'";
		int check = stm.executeUpdate(updateCount);
		if(check>0)
			
		{ 
			String infoMessage="Your changes are been updated";
			
			String titleBar="Message";
		
			JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Successfully changed");
			
		}
		else
		{
			System.out.println("Not Changed");
		}		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}


//public boolean isDatevalid(String date) {
//	boolean ok=true;
//if(date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")){
//		
//		int day=Integer.parseInt(date.substring(0,2));
//		int month=Integer.parseInt(date.substring(3,5));
//		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
//			if(day>0 && day<32)
//				System.out.println("OK!!");
//			else {
//				String infoMessage="Enter valid date";
//				
//				String titleBar="details";
//			
//				JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("Wrong date");
//				ok=false;
//			}
//				
//		}
//		else if(month==4 || month==6 || month==9 || month==11) {
//			if(day>0 && day<31)
//				System.out.println("OK!!");
//			else {
//				String infoMessage="Enter valid date";
//				
//				String titleBar="details";
//			
//				JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("Wrong date");
//				ok=false;
//			}
//		}
//		else if(month==2) {
//			if(day>0 && day<29)
//				System.out.println("OK!!");
//			else {
//				String infoMessage="Enter valid date";
//				
//				String titleBar="details";
//			
//				JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("Wrong date");
//				ok=false;
//			}
//		}
//		else {
//			String infoMessage="Enter valid month";
//			
//			String titleBar="details";
//		
//			JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
//			System.out.println("Wrong month");
//			ok=false;
//		}
//	}
//	else {
//		String infoMessage="Enter valid formatt (dd-mm-yyyy)";
//		
//		String titleBar="details";
//	
//		JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
//		System.out.println("Wrong format");
//		ok=false;
//	}
//	return ok;
//}
}
