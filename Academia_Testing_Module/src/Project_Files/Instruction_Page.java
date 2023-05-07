//INSTRUCTION PAGE

package Project_Files;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import Project_Files.*;
public class Instruction_Page extends JFrame implements ActionListener
{

	JFrame frame=new JFrame("INSTRUCTIONS");
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b1,b2;
	ImageIcon i1,i2;
	
	 String test_name;
		String f_name;
		int marks[]= new int[11],i=0;
	
		Instruction_Page(String test_name,String f_name)
	{
		this.f_name=f_name;
		this.test_name=test_name;
		frame.setSize(1366,768);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we)
			{
			System.exit(0);
			}
		});
		Container con=getContentPane();
		con.setLayout(null);
		
		String final_name="";
		
		if(test_name=="c")
			final_name="C Language";
		else if(test_name=="gk")
			final_name="General Knowledge";
		else if(test_name=="python")
			final_name="Python";
		if(test_name=="sq")
			final_name="MySQL";
		if(test_name=="java")
			final_name="Java Programming";
			
		l1=new JLabel("Instructions: ");
		l3=new JLabel("1. Exam name :  "+ final_name);
		l4=new JLabel("2. Total Questions 10. ");
		l5=new JLabel("3. You need to score 60% or above to pass.");
//		l6=new JLabel("4. Allocated time is 1 minute(s) 30 second(s) per question. If you complete the question within allocated time, you can move to next question.");
		l7=new JLabel("4. You can go back to a previous question.");
//		l8=new JLabel("6. You can only attempt and pass the exam 2 time(s) to improve your score. ");
//		l9=new JLabel("7. If you already passed this exam 2 time(s), the most recent score is considered your final score.");
//		l10=new JLabel("8. While writing the exam, you can see the remaining time in the top right side. ");
//		l11=new JLabel("9. After the allocated time, you are automatically moved to the next question.");
		
		i1=new ImageIcon("Images/Instruction_Page .png");
		l2=new JLabel(i1);
		i2=new ImageIcon("Images/home.png");
		l12=new JLabel(i2);
		b1=new JButton("Start Test");
		b2=new JButton("Home");
		Font f1=new Font("cyrillic", Font.BOLD, 20);
		l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
//		l6.setFont(f1);
		l7.setFont(f1);
//		l8.setFont(f1);
//		l9.setFont(f1);
//		l10.setFont(f1);
//		l11.setFont(f1);
		Font f3=new Font("cyrillics", Font.BOLD, 12);
		b1.setFont(f3);
		b1.setForeground(Color.black);
		b1.setBackground(Color.lightGray);
		b2.setFont(f3);
		b2.setForeground(Color.black);
		b2.setBackground(Color.lightGray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		l1.setForeground(Color.gray);
		//l2.setForeground(Color.black);
		l3.setForeground(Color.gray);
		l4.setForeground(Color.gray);
		l5.setForeground(Color.gray);
		l7.setForeground(Color.gray);
		
		//l1.setBounds(100,70,200,20);
		l3.setBounds(350,230,800,25);
		l4.setBounds(350,260,800,25);
		l5.setBounds(350,290,800,25);
//		l6.setBounds(200,190,1100,20);
		l7.setBounds(350,320,800,25);
//		l8.setBounds(200,250,800,20);
//		l9.setBounds(200,280,800,20);
//		l10.setBounds(200,310,800,20);
//		l11.setBounds(200,340,800,20);
		l2.setBounds(0,0,1366,768);
		
		b1.setFont(f1);
		b1.setBounds(550,540,200,35);//Start Test
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setForeground(Color.white);
		
		b2.setFont(f1);
		b2.setBounds(1118,19,120,35);//Home
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setForeground(Color.white);
		
		l12.setBounds(30,400,406,306);
		
		l2.add(l1);
		l2.add(l3);
		l2.add(l4);
		l2.add(l5);
//		l2.add(l6);
		l2.add(l7);
//		l2.add(l8);
//		l2.add(l9);
//		l2.add(l10);
//		l2.add(l11);
		l2.add(b1);
		l2.add(b2);
		l2.add(l12);
		con.add(l2);
		frame.add(con);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s1=ae.getActionCommand();
		String s2=ae.getActionCommand();
		
		if(s1.equals("Start Test"))
			{
			new Question_1(test_name,marks,f_name);
			frame.setVisible(false);
			}
		if(s2.equals("Home"))
		{
			new Home_Page(f_name);
			frame.setVisible(false);
		}
	}
}

