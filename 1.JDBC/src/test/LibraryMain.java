package test;

import java.io.IOException;
import java.sql.SQLException;


import dao.LibBooks;
import dao.Librarian;
import dao.NumbersValidation;


public class LibraryMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException   {
        
		
		
		LibBooks libc=new LibBooks();
		Librarian librarian=new Librarian();
		

		System.out.println("1.Customer\n"+"2.Librarian");		
		System.out.println("Are you a customer OR Librarian?");
		
		int num = NumbersValidation.validateNum();
		
					
		if(num==1) {
			
			libc.customer();
		}
		 if(num==2) {
			
			librarian.librarian();
		}
		}
		
		
	}


