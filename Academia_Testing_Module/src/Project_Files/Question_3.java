package Project_Files;

import javax.swing.*;
import Project_Files.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question_3 extends JFrame implements ActionListener
{
   JFrame frame =new JFrame("Question 3");
   JLabel l1,l2,l3,l4,l5,l6;
   JRadioButton b, rb1,rb2,rb3,rb4;
   JButton b1,b2;
   //JButton b =null;
   ButtonGroup bg;
   String que,op1,op2,op3,op4,answer;
   ImageIcon i1,i2,i3,i4,i5;
   
   
   String test_name;
	String f_name;
	int marks[],i=3;
   
	Question_3(String name,int m[],String f_name)
	{
	  this.f_name=f_name;
	  marks=m.clone();
	  test_name=name;
		frame.setSize(1366,768);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we)
			{
			System.exit(0);
			}
		});
		Container con=getContentPane();
		con.setLayout(null);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","root");
			Statement stm = conn.createStatement();
			String str1 = "select * from ";
			String str3 = " where id = '"+i+"'";
			String str = str1.concat(test_name);
			String query = str.concat(str3);
			
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				que= rs.getString("questions");
				op1= rs.getString("option1");
				op2= rs.getString("option2");
				op3= rs.getString("option3");
				op4= rs.getString("option4");
				answer = rs.getString("answerkey");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		l1=new JLabel(i+" . "+que);
		
		i1=new ImageIcon("Images/Other_ques.png");
		l6=new JLabel(i1);
		b1=new JButton("Next");
		b2=new JButton("Back");
		rb1=new JRadioButton(op1);
		rb2=new JRadioButton(op2);
		rb3=new JRadioButton(op3);
		rb4=new JRadioButton(op4);
		bg=new ButtonGroup();
		
		Font f1=new Font("cyrillic", Font.BOLD, 18);
		Font f=new Font("cyrillic", Font.BOLD, 18);
		l1.setFont(f);
		rb1.setFont(f1);
		rb2.setFont(f1);
		rb3.setFont(f1);
		rb4.setFont(f1);
		Font f3=new Font("cyrillic", Font.BOLD, 18);
		l1.setForeground(Color.gray);
		rb1.setForeground(Color.gray);
		rb2.setForeground(Color.gray);
		rb3.setForeground(Color.gray);
		rb4.setForeground(Color.gray);
		
		b1.setFont(f3);
		b1.setForeground(Color.black);
		b1.setBackground(Color.lightGray);
		b2.setFont(f3);
		b2.setForeground(Color.black);
		b2.setBackground(Color.lightGray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		l1.setBounds(90,90,1000,40);
		l6.setBounds(0,0,1366,768);//background
		
		b1.setFont(f1);
		b1.setBounds(550,540,200,35);//Start Test
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setForeground(Color.white);
		
		b2.setBounds(1118,19,120,35);//back
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setForeground(Color.white);
		
		rb1.setBounds(100,170,450,30);
		rb2.setBounds(100,220,450,30);
		rb3.setBounds(100,270,450,30);
		rb4.setBounds(100,320,450,30);
		
		l6.add(l1);
		l6.add(b1);
		l6.add(b2);
		l6.add(rb1);
		
		rb1.setOpaque(false);
		rb2.setOpaque(false);
		rb3.setOpaque(false);
		rb4.setOpaque(false);
		l6.add(rb2);
		l6.add(rb3);
		l6.add(rb4);
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		
		con.add(l6);
		frame.add(con);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=ae.getActionCommand();
		String s2=ae.getActionCommand();
		String choice;
		if(s1.equals("Next"))
		{
		if(rb1.isSelected())
		{
			b= rb1;
			choice = b.getText();
			if(choice.equals(answer))
			{
				marks[i]=10;
			}
			else
			{
				marks[i]=0;
			}
			new Question_4(test_name,marks,f_name);
			frame.setVisible(false);
		}
		else if(rb2.isSelected())
		{
			b= rb2;
			choice = b.getText();
			if(choice.equals(answer))
			{
				marks[i]=10;
			}
			else
			{
				marks[i]=0;
			}
			new Question_4(test_name,marks,f_name);
			frame.setVisible(false);
		}
		else if(rb3.isSelected())
		{
			b= rb3;
			choice = b.getText();
			if(choice.equals(answer))
			{
				marks[i]=10;
			}
			else
			{
				marks[i]=0;
			}
			new Question_4(test_name,marks,f_name);
			frame.setVisible(false);
		}
		else if(rb4.isSelected())
		{
			b= rb4;
			choice = b.getText();
			if(choice.equals(answer))
			{
				marks[i]=10;
			}
			else
			{
				marks[i]=0;
			}
			new Question_4(test_name,marks,f_name);
			frame.setVisible(false);
		}
		else
		{
			marks[i]=0;
			new Question_4(test_name,marks,f_name);
			frame.setVisible(false);
		}
		System.out.println(marks[i]);
		}
		else if(s2.equals("Back"))
			{
			new Question_2(test_name,marks,f_name);
			frame.setVisible(false);
		}
	}

}
