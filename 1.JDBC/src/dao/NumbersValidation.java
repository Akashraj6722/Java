package dao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumbersValidation {
	
	public static int validateNum() {
		Scanner input=new Scanner(System.in);

		int num = 0;
		while(input.hasNext()) {
			try {
				num=input.nextInt();
				if(num!=1 && num!=2) {
					System.err.println("Invalid data");
				}else {
				return num;
				}
			}
						catch(InputMismatchException e) {
				System.out.println(e);
				System.err.println("Enter the valid input");
				input.nextLine();
			}
				}
		input.close();
		return 0;
}


	public static int validateBookId() {
	Scanner input=new Scanner(System.in);

	int bookId = 0;
	while(input.hasNext()) {
		try {
			bookId=input.nextInt();
			if(bookId<1) {
					System.err.println("Invalid data");
			}else {
			return bookId;	
			}
		}
					catch(InputMismatchException e) {
			System.out.println(e);
			System.err.println("Enter the valid input");
			input.nextLine();
		}
			}
	input.close();
	return 0;
}
	
	
}
	
	
	
	
