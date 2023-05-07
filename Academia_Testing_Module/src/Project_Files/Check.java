package Project_Files;

import javax.swing.JOptionPane;

public class Check {
	
	public static boolean all_ok(String[] str) {
		
		for(String s:str) {
			if(s.length()==0) {
				String infoMessage="Please Fill all the details.";
				
				String titleBar=" Details";
			
				JOptionPane.showMessageDialog(null, infoMessage, "Warning" + titleBar, JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Details not filled.");
				return false;
			}
		}
		
		if(!Validation.isContact(str[6]))
			return false;
		
		if(!Validation.isDatevalid(str[4]))
			return false;
		
		if(!Validation.isPassOK(str[2]))
			return false;
		
		if(!Validation.isMailOk(str[5]))
			return false;
		
		return true;
	}
	
}
