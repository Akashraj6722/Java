package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.LibBooks;
import dao.Librarian;


public class LibraryMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException   {
        
		int num = 0 ;
		
		Scanner input=new Scanner(System.in);
		LibBooks libc=new LibBooks();
		Librarian librarian=new Librarian();
		

		System.out.println("1.Customer\n"+"2.Librarian");		
		System.out.println("Are you a customer OR Librarian?");
	
		while(input.hasNext()) {
			try {
				num=input.nextInt();
				if(num!=1 && num!=2) {
					System.err.println("Invalid data");
				}
			}
			
			catch(InputMismatchException e) {
				System.out.println(e);
				System.err.println("Enter the valid input");
				input.nextLine();
			}
		
		
		if(num==1) {
			
			libc.customer();
		}
		 if(num==2) {
			
			librarian.librarian();
		}
		}
		
		input.close();
		
	}

}
