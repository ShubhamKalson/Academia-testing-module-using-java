package Project_Files;

//SUCCESSFUL REGISTRATION
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Successful_Registration extends JFrame implements ActionListener{
	
	JFrame f=new JFrame("SUCCESSFUL REGISTRATION");
	String msg="   ";
	String n="   ";
	String y="   ";
	JLabel l1,l2,l3;
	JButton b1;
	ImageIcon i1;
	String s="";
	Successful_Registration(String s)
	
	{
		Container con=getContentPane();
		con.setLayout(null);
		
	b1=new JButton("Home");
	i1=new ImageIcon("image/d (5).jpg");
	l1=new JLabel(i1);
	l2=new JLabel(" User Name :" + " " + n);
	l3 =new JLabel("Password  :" + "  " + y);
	b1.addActionListener(this);
	Font fo=new Font("Gabriola", Font.BOLD, 45);
	l2.setFont(fo);
	l2.setForeground(Color.WHITE);
	l3.setFont(fo);
	l3.setForeground(Color.WHITE);
	b1.setBounds(1100,650,190,30);
	Font f2=new Font("Century Gothic", Font.BOLD, 15);
	b1.setFont(f2);
	b1.setForeground(Color.BLACK);		
	b1.setBackground(Color.lightGray);
	l1.setBounds(0,0,1366,768);
	l2.setBounds(80,200,800,60);
	l3.setBounds(100,250,500,60);
	l1.add(b1);
	l1.add(l2);
	l1.add(l3);
	con.add(l1);
	f.add(con); 
	f.setVisible(true);
	
		this.s=s;
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
			
			if(n.equals(s))
			{
				isPresent=true;
				break;
			}
		}
		if(isPresent) {
			String name=rs.getString("first_name");
			new Home_Page(name);
			f.setVisible(false);
		}
		else
		{
			f.setVisible(false);
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
		f.setSize(1366,768);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we)
			{
			System.exit(0);
			}
		});
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=ae.getActionCommand();
		
		if(s1.equals("Home"))
			{
			new Login_Page();
			f.setVisible(false);
			}
}

}


