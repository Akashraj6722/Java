package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import model.Library;
import util.DataEnglish;
import util.DataTamil;
import util.Register;
import util.bookRecords;

public class LibBooks  {

	public void customer() throws IOException, ClassNotFoundException, SQLException  {
	Scanner input=new Scanner(System.in);
	
	String userName = null ;
	String pass ;
	String passW ;
	String ans;
	String phone = "";
	String name = "";
	String option;
	int bookId = 0 ;

	String regex="[a-zA-Z]{1,10}";
	String regex3="[6789]{1}[0-9]{9}";
	String regexP= "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.])(?=.*\\d).{8,}$";
	
	Library lib=new Library();

	System.out.println("Are you a membership holder?\n"+"Type yes or no");
	ans=input.next();
	
	while(!ans.matches(regex)) {
		System.out.println("Enter YES or NO");
		ans=input.next();

	}
	
	while(!ans.equals("yes")&&(!ans.equals("no"))) {
		
		System.out.println("Enter YES or NO");
		ans=input.next();	
	}
	
	if(ans.equals("no")) {
		System.out.println("GET A MEMBERSHIP IN OUR LIBRARY\n");
		
		System.out.println("SIGNUP");
		System.out.println("Enter the NAME");
		name=input.next();
		while(!name.matches(regex)) {
			System.err.println("Enter the VALID NAME:");
			name=input.next();

		}
		
		System.out.println("Enter the MOBILE number");
		
		phone=input.next();
		while(!phone.matches(regex3)) {
			System.err.println("Enter the  VALID MOBILE number:");
			phone=input.next();
		}
//		while(true)
//		{
//		try {
//			System.out.println("Enter the MOBILE number");
//			
//			phone=input.next();
//			while(!phone.matches(regex3)) {
//				System.err.println("Enter the  VALID MOBILE number:");
//				phone=input.next();
//			}
//			
//			lib.setPhone(phone);
//		     Register.register(lib);
//		     break;
//		}catch(SQLIntegrityConstraintViolationException e) {
//			System.out.println(e);
//			System.out.println("Enter correct phone number");
//			input.nextLine();
//			
//		}
//	}	
			
		System.out.println("SET PASSWORD");
		pass=input.next();
		while(!pass.matches(regexP)) {
			System.err.println("Enter the VALID PASSWORD:");
			pass=input.next();
		}
		
		
		lib.setUserName(name);
		lib.setPhone(phone);
		lib.setPass(pass);
		lib.setType("User");

	     Register.register(lib);

		
	System.out.println("SIGNED UP SUCCESFULLY\n");
	System.out.println("LOGIN");
	
	System.out.println("Enter the USERNAME");
	userName=input.next();
	
	System.out.println("Enter the PASSWORD");
	passW=input.next();
	

	lib.setUserName(userName);
	lib.setPassW(passW);
	lib.setType("User");

	
	Register.login(lib);
	
	while(!Register.login(lib)) {
		
		System.err.println("Invalid User Data\nEnter It Again  ");
		

		System.out.println("Enter the USERNAME");
		userName=input.next();
		

		System.out.println("Enter the PASSWORD");
		passW=input.next();
		

		lib.setUserName(userName);
		lib.setPassW(passW);
		lib.setType("User");

		
		Register.login(lib);
	
	}
	System.out.println("Logged in");

	}
	
	 if(ans.equals("yes")) {
	
	System.out.println("Enter  YOUR NAME:");
	userName=input.next();
	while(!userName.matches(regex)) {
		System.err.println("Enter the VALID NAME:");
		userName=input.next();
	}

	
	System.out.println("Enter  PASSWORD:");
	passW=input.next();
	
	
	lib.setUserName(userName);
	lib.setPassW(passW);
	lib.setType("User");
	
	Register.login(lib);

	while(!Register.login(lib))
	{
		System.err.println("Invalid User Data\nEnter It Again  ");
		System.out.println("Enter  YOUR NAME:");
		userName=input.next();
		lib.setUserName(userName);
		
		System.out.println("Enter  PASSWORD:");
		passW=input.next();
		lib.setPassW(passW);
		lib.setType("User");
		
		Register.login(lib);
		
	}
	System.out.println("Logged in");
}	
	
	System.out.println("Enter your choice:\n"+"1.TAMIL books\n"+"2.ENGLISH books\n");
	option=input.next().toLowerCase();
	
	while(!option.matches("tamil") && (!option.matches("english"))) {
		System.out.println("TYPE TAMIL OR ENGLISH");
		option=input.next().toLowerCase();

	}

	
	if(option.equals("tamil")) {
		
		DataTamil.read();
		System.out.println("Enter the BOOK ID:");
		bookId=NumbersValidation.validateBookId();
		
		lib.setBookId(bookId);
		DataTamil.readSelect(lib);

	}
	
	if(option.equals("english")) {
		
		DataEnglish.read();
		System.out.println("Enter the BOOK ID:");
		bookId=NumbersValidation.validateBookId();	
		
		lib.setBookId(bookId);
		DataEnglish.readSelect(lib);
	
	}
	System.out.println("---------------------------");

	LocalDate d=LocalDate.now();
	LocalDate due=d.plusDays(5);
	
	String date1=d.toString();
	String dueDate=due.toString();
	
	lib.setName(userName);
	lib.setBookId(bookId); 
	lib.setDate(date1);	
	lib.setDueDate(dueDate);
	bookRecords.update(lib);
	System.out.println(lib.toString());
	input.close();
	}
}


