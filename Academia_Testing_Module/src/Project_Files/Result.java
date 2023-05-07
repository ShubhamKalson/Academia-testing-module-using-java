//FINAL REPORT

package Project_Files;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import Project_Files.*;
public class Result extends JFrame implements ActionListener
{

	JFrame frame=new JFrame("FINAL REPORT");
	JLabel l1,l2,l3,l4,l5;
	JButton b1;
	ImageIcon i1,i2,i3;
	
	String f_name,query;
	String test_name;
	int marks[],total=0;
	
	Result(String name, int m[],String f_name)
	{
		this.f_name=f_name;
		marks=m.clone();
		for(int i=1;i<=10;i++)
		{
			total+=marks[i];
			System.out.println(marks[i]);
		}
		test_name=name;
		
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
						
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root"); 
						
			Statement stm = con.createStatement();//creation
			//update user_info set java=marks where f_name=username
			String query1="update user_info set ";
			String query2 = query1.concat(test_name);
			String query4 = query2.concat(" ='"+total+"'");
			String query3=" where first_name ='"+f_name+"'";
			query = query4.concat(query3);
			int check = stm.executeUpdate(query);
			 if(check>0)
			 {
				 //JOptionPane.showMessageDialog(null, "RECORD INSERTED ");		 
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null, "NOT INSERTED");
			 }	
			System.out.println(query);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		Container con=getContentPane();
		con.setLayout(null);
		Font f1=new Font("cyrillic", Font.BOLD, 30);
		Font f2=new Font("cyrillic", Font.BOLD, 20);
		l1=new JLabel("Final Score: "+total);
		i1=new ImageIcon("Images/result.png");
		l2=new JLabel(i1);
		
		i2=new ImageIcon("Images/final.png");
		l3=new JLabel(i2);
		
		i3=new ImageIcon("Images/final1.png");
		l4=new JLabel(i3);
		
		b1=new JButton("Finish");
		b1.addActionListener(this);
		l1.setBounds(550,250,400,30);
		l2.setBounds(0,0,1366,768);
		l3.setBounds(30,400,406,306);
		l4.setBounds(920,400,406,306);
		l1.setFont(f1);
		l1.setForeground(Color.gray);
		b1.setFont(f2);
		b1.setBounds(550,540,200,35);//Start Test
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setForeground(Color.white);
		l2.add(l1);
		
		l2.add(b1);
		l2.add(l3);
		l2.add(l4);
		con.add(l2);
		frame.add(con);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=ae.getActionCommand();
		
		if(s1.equals("Finish"))
			{
			new Home_Page(f_name);
			frame.setVisible(false);
			}
	}

}
