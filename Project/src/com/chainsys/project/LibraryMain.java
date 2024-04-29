package com.chainsys.project;

import java.io.IOException;
import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) throws IOException   {
        
		String num;
		
		Scanner input=new Scanner(System.in);
		LibBooks libc=new LibBooks();
		Librarian librarian=new Librarian();
		
		String regex1="[12]{1}";

		System.out.println("1.Customer\n"+"2.Librarian");		
		System.out.println("Are you a customer OR Librarian?");
		num=input.next();
		
		while(!num.matches(regex1)) {
			System.out.println("Type 1 or 2");
			num=input.next();
		}
		
		while(!num.equals("1") && !num.equals("2")) {
			
			System.err.println("Enter the valid choice");
			num=input.next();		
		}
		
		if(num.equals("1")) {
			
			libc.customer();
		}
		 if(num.equals("2")) {
			
			librarian.librarian();
		}
	
		
		input.close();
		
	}

}


