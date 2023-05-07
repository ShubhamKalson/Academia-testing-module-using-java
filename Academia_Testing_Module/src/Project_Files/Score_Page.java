//SCORE PANEL

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

public class Score_Page extends JFrame implements ActionListener {
	JFrame frame=new JFrame("SCORE PANEL");

	String s10="   ";
	String s11="   ";
	String s12="   ";
	String s13="   ";
	String s14="   ";
	JButton b2;
	JLabel l1,l2,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30;
	ImageIcon i1,i2;
	String f_name;
	Score_Page(String f_name)
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
			ResultSet rs= stm.executeQuery("select * from user_info where first_name='"+f_name+"'");
			while(rs.next())
			{
				s10=rs.getString("java");
				s11=rs.getString("c");
				s12=rs.getString("sq");
				s13=rs.getString("gk");
				s14=rs.getString("python");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Container con=getContentPane();
		con.setLayout(null);
		Font f=new Font("cyrillic", Font.BOLD, 22);
		i1=new ImageIcon("Images/BG2 - Copy.png");
		l1=new JLabel(i1);
		i2=new ImageIcon("Images/score.png");
		l2=new JLabel(i2);
		
		l19=new JLabel("Java Score :");
		l19.setFont(f);
		l19.setForeground(Color.gray);
		l20=new JLabel(s10);
		l20.setFont(f);
		l20.setForeground(Color.gray);
		l21=new JLabel("C++ Score :");
		l21.setFont(f);
		l21.setForeground(Color.gray);
		l22=new JLabel(s11);
		l22.setFont(f);
		l22.setForeground(Color.gray);
		l23=new JLabel("MySql Score :");
		l23.setFont(f);
		l23.setForeground(Color.gray);
		l24=new JLabel(s12);
		l24.setFont(f);
		l24.setForeground(Color.gray);
		l25=new JLabel("General Knowledge Score :");
		l25.setFont(f);
		l25.setForeground(Color.gray);
		l26=new JLabel(s13);
		l26.setFont(f);
		l26.setForeground(Color.gray);
		l27=new JLabel("Python Score :");
		l27.setFont(f);
		l27.setForeground(Color.gray);
		l28=new JLabel(s14);
		l28.setFont(f);
		l28.setForeground(Color.gray);
		
		b2=new JButton("Home");
		Font f1=new Font("cyrillic", Font.BOLD, 18);
		b2.setFont(f1);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setForeground(Color.white);
		b2.setBounds(1118,19,120,35);
		b2.addActionListener(this);
		
		l19.setBounds(450,240,480,25);
		l21.setBounds(450,327,480,25);
		l23.setBounds(450,417,480,25);
		l27.setBounds(450,516,480,25);
		l25.setBounds(450,609,480,25);
		l20.setBounds(780,240,480,25);
		l22.setBounds(780,327,480,25);
		l24.setBounds(780,417,480,25);
		l28.setBounds(780,516,480,25);
		l26.setBounds(780,609,480,25);
		l1.setBounds(0,0,1366,768);
		l2.setBounds(30,400,406,306);
		l1.add(l19);
		l1.add(l20);
		l1.add(l21);
		l1.add(l22);
		l1.add(l23);
		l1.add(l24);
		l1.add(l25);
		l1.add(l26);
		l1.add(l27);
		l1.add(l28);
		l1.add(b2);
		l1.add(l2);
		con.add(l1);
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
}

}
