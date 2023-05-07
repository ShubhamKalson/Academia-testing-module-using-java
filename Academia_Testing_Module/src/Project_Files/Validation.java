package Project_Files;

import javax.swing.JOptionPane;

public class Validation {
	
	public static boolean isDatevalid(String date) {
		boolean ok=true;
if(date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")){
			
			int day=Integer.parseInt(date.substring(0,2));
			int month=Integer.parseInt(date.substring(3,5));
			if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
				if(day>0 && day<32)
					System.out.println("OK!!");
				else {
					String infoMessage="Enter valid date";
					
					String titleBar="details";
				
					JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Wrong date");
					ok=false;
				}
					
			}
			else if(month==4 || month==6 || month==9 || month==11) {
				if(day>0 && day<31)
					System.out.println("OK!!");
				else {
					String infoMessage="Enter valid date";
					
					String titleBar="details";
				
					JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Wrong date");
					ok=false;
				}
			}
			else if(month==2) {
				if(day>0 && day<29)
					System.out.println("OK!!");
				else {
					String infoMessage="Enter valid date";
					
					String titleBar="details";
				
					JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
					System.out.println("Wrong date");
					ok=false;
				}
			}
			else {
				String infoMessage="Enter valid month";
				
				String titleBar="details";
			
				JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Wrong month");
				ok=false;
			}
		}
		else {
			String infoMessage="Enter valid format (dd-mm-yyyy)";
			
			String titleBar="details";
		
			JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Wrong formatt");
			ok=false;
		}
		return ok;
	}
	
	
	public static boolean isContact(String contact) {
		if(contact.length()!=10  || !contact.matches("[0-9]{10}") ) {
			String infoMessage="Enter valid 10-digit number";
			
			String titleBar=" details";
		
			JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Invalid Contact Number");
			return false;
		}
		return true;
	}
	

	public static boolean isPassOK(String pass) {
		
		if(pass.length()<=7) {
			String infoMessage="Password should be minimum 8 characters long";
			
			String titleBar=" details";
		
			JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Invalid Password..");
			return false;
		}
		else if(!pass.contains("@")){
			String infoMessage="Password must contains atleast @";
			String titleBar=" details";
			
			JOptionPane.showMessageDialog(null, infoMessage,"Warning"+titleBar,JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Invalid Password..");
			return false;
		}
		
		return true;
	}
	
	public static boolean isMailOk(String mail) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		
		if(!mail.matches(regex)) {
			String infoMessage="Enter valid e-mail address";
			
			String titleBar=" details";
		
			JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Invalid Email");
			return false;
		}
		
		return true;
	}


}
