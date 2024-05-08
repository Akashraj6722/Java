package dao;

import java.util.InputMismatchException;

public class Handle  {
	
	public static boolean errorHandling(int num) {
		
		try {
			if(num!=1 && num!=2) {
				
				System.out.println("Invalid data--");
				return false;
			}
		}catch(InputMismatchException e) {
			
			System.out.println(e);
					
		}
			
		return true;
		
	}

}
