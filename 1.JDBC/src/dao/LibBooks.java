package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import model.Library;
import util.Register;

public class LibBooks  {

	public void customer() throws IOException, ClassNotFoundException, SQLException  {
	Scanner input=new Scanner(System.in);
	
	String userName ="";
	String pass ;
	String passW ;
	String ans;
	String phone;
	String name = ""  ;
	String option;
	String bookId;
	int bkId = 0;

	String regex="[a-zA-Z]{1,10}";
	String regex1="[1-9]{1,2}";
	String regex3="[6789]{1}[0-9]{9}";
	String regexP= " ";
	
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
		System.out.println("SET PASSWORD");
		pass=input.next();
		while(pass.matches(regexP)) {
			System.err.println("Enter the VALID PASSWORD:");
			name=input.next();
			

		}
		
		lib.setUserName(name);
		lib.setPhone(phone);
		lib.setPass(pass);
		Register.register(lib);

		System.out.println("SIGNED UP SUCCESFULLY\n");
	
	
	System.out.println("LOGIN");
	
	System.out.println("Enter the USERNAME");
	userName=input.next();

	System.out.println("Enter the PASSWORD");
	passW=input.next();

	lib.setUserName(userName);
	lib.setPassW(passW);
	
	Register.login(lib);
	
	while(!Register.login(lib)) {
		
		System.err.println("Invalid User Data\nEnter It Again  ");
		

		System.out.println("Enter the USERNAME");
		userName=input.next();

		System.out.println("Enter the PASSWORD");
		passW=input.next();

		lib.setUserName(userName);
		lib.setPassW(passW);
		
		Register.login(lib);
	
	}
	System.out.println("Logged in");

	}
	
	 if(ans.equals("yes")) {
	
	System.out.println("Enter  YOUR NAME:");
	userName=input.next().toLowerCase();

	
	System.out.println("Enter  PASSWORD:");
	passW=input.next();
	
	lib.setUserName(userName);
	lib.setPassW(passW);
	
	Register.login(lib);

	while(!Register.login(lib))
	{
		System.err.println("Invalid User Data\nEnter It Again  ");
		System.out.println("Enter  YOUR NAME:");
		userName=input.next().toLowerCase();
		lib.setUserName(userName);
		
		System.out.println("Enter  PASSWORD:");
		passW=input.next();
		lib.setPassW(passW);
		
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
		
		System.out.println("Number of books Available:10");
		
		System.out.println("1-Seevaka chinthamani\n"+ "2-Silappathikaram\n"+ "3-Manimekalai\n"+ "4-Kundalakesi\n"+"5-Valayapathi\n"+"6-Ramayanam"+"7-Kambaramayanam"+"8-Ponniyin selvan\n"+"9-Karuvaachi kaaviyam\n"+"10-Thanneer desam\n");
		System.out.println("Enter the BOOK ID:");
		bookId=input.next();
		while(!bookId.matches(regex1)) {
			System.err.println("Enter the VALID  BOOK ID:");
			bookId=input.next();
  }
	
		 String[] tamil= {"Seevaka chinthamani","Silappathikaram","Manimekalai","Kundalakesi","Valayapathi","Ramayanam","Kambaramayanam","Ponniyin selvan","Karuvaachi kaaviyam","Thanner desam"	};	
	        
	         bkId = Integer.parseInt(bookId);
	        for(int i=0;i<tamil.length;i++) {
	        	 
	        	 if((i+1) == bkId) {
	        		 System.out.println("---------------------------");
	        		 System.out.println("BOOK NAME:"+tamil[i]);
	        		 System.out.println("---------------------------");

	        	 
	        	 switch(bkId) {
	        	 case(1):
	        		 
	        		 System.out.println("TOTAL STOCK:47\n"+"AVAILABLE STOCK:12");
	        	 System.out.println("REQUESTED BOOK IS AVILABLE ");
	        	     break;
	        	     
	        	 case(2):
	        		 
	        		 System.out.println("TOTAL STOCK:50\n"+"AVAILABLE STOCK:0\n");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");
	        	     break;
	        	     
                 case(3):
	        		 
	        		 System.out.println("TOTAL STOCK:42\n"+"AVAILABLE STOCK:10");
	        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

	        	     break;    
	        	     
                  case(4):
                	  
	        		 System.out.println("TOTAL STOCK:65\n"+"AVAILABLE STOCK:32");
		        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

	        	     break;
	        	     
                  case(5):
 
                       System.out.println("TOTAL STOCK:23\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                       break;
                       
                   case(6):
 
                       System.out.println("TOTAL STOCK:45\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                       break;
                       
                   case(7):
 
                        System.out.println("TOTAL STOCK:88\n"+"AVAILABLE STOCK:23");
		        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

                        break;
                        
                   case(8):
 
                        System.out.println("TOTAL STOCK:30\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                        break;
                        
                    case(9):
 
                          System.out.println("TOTAL STOCK:70\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                          break;
                          
                     case(10):
 
                           System.out.println("TOTAL STOCK:35\n"+"AVAILABLE STOCK:11");
		        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

                           break;
	        
			}
	        	 }
	}
	}
	
	if(option.equals("english")) {
		
		System.out.println("Number of books Available:10");
		
		System.out.println("1-Sherlock holmes\n"+ "2-Half girlfriend\n"+ "3-Treasure island\n"+ "4-Rebel Nation\n"+"5-Rich dad Poor dad\n"+"6-Beyond the ordinary"+"7-Harry potter"+"8-Alice the wonderland\n"+"9-The Great Gatsby\n"+"10-The Lord of the Rings");
		System.out.println("Enter the BOOK ID:");
		bookId=input.next();
		while(!bookId.matches(regex1)) {
			System.err.println("Enter the VALID  BOOK ID:");
			bookId=input.next();
  }
	
		 String[] english= {"Sherlock holmes","Half girlfriend","Treasure island","Rebel Nation","Rich dad Poor dad","Beyond the ordinary","Harry potter","Alice the wonderland","The Great Gatsby","The Lord of the Rings"};	
	        
	         bkId = Integer.parseInt(bookId);
	        for(int i=0;i<english.length;i++) {
	        	 
	        	 if((i+1) == bkId) {
	        		 System.out.println("---------------------------");
	        		 System.out.println("BOOK NAME:"+english[i]);
	        		 System.out.println("---------------------------");

	        	 
	        	 switch(bkId) {
	        	 case(1):
	        		 
	        		 System.out.println("TOTAL STOCK:47\n"+"AVAILABLE STOCK:12");
	        	 System.out.println("REQUESTED BOOK IS AVILABLE ");
	        	     break;
	        	     
	        	 case(2):
	        		 
	        		 System.out.println("TOTAL STOCK:50\n"+"AVAILABLE STOCK:0\n");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");
	        	     break;
	        	     
                 case(3):
	        		 
	        		 System.out.println("TOTAL STOCK:42\n"+"AVAILABLE STOCK:10");
	        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

	        	     break;    
	        	     
                  case(4):
                	  
	        		 System.out.println("TOTAL STOCK:65\n"+"AVAILABLE STOCK:32");
		        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

	        	     break;
	        	     
                  case(5):
 
                       System.out.println("TOTAL STOCK:23\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                       break;
                       
                   case(6):
 
                       System.out.println("TOTAL STOCK:45\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                       break;
                       
                   case(7):
 
                        System.out.println("TOTAL STOCK:55\n"+"AVAILABLE STOCK:23");
		        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

                        break;
                        
                   case(8):
 
                        System.out.println("TOTAL STOCK:30\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                        break;
                        
                    case(9):
 
                          System.out.println("TOTAL STOCK:70\n"+"AVAILABLE STOCK:0");
	        	     System.out.println("SORRY REQUESTED BOOK IS NOT AVAILABLE RIGHT NOW\n");

                          break;
                          
                     case(10):
 
                           System.out.println("TOTAL STOCK:35\n"+"AVAILABLE STOCK:11");
		        	 System.out.println("REQUESTED BOOK IS AVILABLE ");

                           break;
	        
			}
	        	 }
	}
	        
	}
	System.out.println("---------------------------");

	
	lib.setName(userName);
	lib.setBkId(bkId);
	
	
	System.out.println(lib.toString());
	input.close();
	}
}

