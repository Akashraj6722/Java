package com.chainsys.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Librarian {
	
	public void librarian() {
		
		Scanner input=new Scanner(System.in);
		
		String name = null;
		ArrayList<String> arrayListE = new ArrayList<>();
		arrayListE.add("1-Sherlock holmes\n"+ " 2-Half girlfriend\n"+ " 3-Treasure island\n"+ " 4-Rebel Nation\n"+" 5-Rich dad Poor dad\n"+" 6-Beyond the ordinary\n"+" 7-Harry potter\n"+" 8-Alice the wonderland\n"+" 9-The Great Gatsby\n"+" 10-The Lord of the Rings");
        
		ArrayList<String> arrayListT=new ArrayList<>();
		arrayListT.add("1-Seevaka chinthamani\n"+ " 2-Silappathikaram\n"+ " 3-Manimekalai\n"+ " 4-Kundalakesi\n"+" 5-Valayapathi\n"+" 6-Ramayanam"+" 7-Kambaramayanam"+" 8-Ponniyin selvan\n"+" 9-Karuvaachi kaaviyam\n"+" 10-Thanneer desam");

		int tamilBooks=467;
		int englishBooks=550;
		int countT=tamilBooks;
		int countE=englishBooks;
		int countAddT=10;
		int countAddE=10;
		int add = 0;
		int totalBooksAdded;
		String choice;

		
		String regex="[a-zA-Z]{1,10}";
		String regex1="[12]{1}";
				
		System.out.println("Enter  YOUR NAME:");
		name=input.next().toLowerCase();
		while(!name.matches(regex)) {
			System.err.println("Enter the VALID  NAME:");
			name=input.next().toLowerCase();
		}
		
		  ArrayList<String> librarianNames=new ArrayList<>();
	        librarianNames.add("akash"+"naveen"+"harish"+"rakesh"+"saravana");
		
		for(String copy:librarianNames) {
			while(!copy.contains(name)) {
				
				System.err.println("YOU DON'T HAVE ACCESS \nRE-ENTER THE CORRECT NAME");
				name=input.next().toLowerCase();
			}
			System.out.println("WELCOME "+name);
		
		}
		
			System.out.println("What do you want to do?\n"+"1.To see the stocks\n"+"2.To add stocks");
		     
		     choice=input.next();
		    
		    while(!choice.matches(regex1)) {
				System.out.println("Type 1 or 2");
				choice=input.next();
			}
	    while(!choice.matches("1") && !choice.matches("2")) {
	    	
	    	System.out.println("Enter 1 OR 2");
		     choice=input.next();
    	
		    }
		    
		    if(choice.equals("1")) {
		    	System.out.println("TOTAL TAMIL BOOKS:"+tamilBooks+"\nTOTAL ENGLISH BOOKS:"+englishBooks);
		    }
		    if(choice.equals("2")) {
		    	
		    	System.out.println("Which type of book,You want to add stock for?\n"+"1.Tamil books"+"2.English books");
		    	int option1=input.nextInt();
		    	
		    	if(option1==1) {
		    		System.out.println("How many books you want to add stock in?");
		    		 add=input.nextInt();
		    		
		    		for(int i=1;i<=add;i++) {
		    			
		    			System.out.println("Enter the book name you want to add:");
			    		String extraBook=input.next();
			    		arrayListT.add((++countAddT)+"-"+ extraBook);

			    		countT++;
			    	
		    		}

		    		String[] str = arrayListT.toString().split(",");
		    		
		    		for(int j=0; j<str.length; j++)
		    		{
						System.out.println(str[j]);

		    		}
//		    		System.out.println(arrayListT);
	        		 System.out.println("---------------------------");
		    		System.out.println("Total TAMIL books before adding new books:"+tamilBooks);
	        		 System.out.println("---------------------------");
		    		System.out.println("Total TAMIL books after adding new books:"+countT);
		    		
		    	}
		    	if(option1==2) {
		    		
		    		System.out.println("How many books you want to add stock in?");
		    		 add=input.nextInt();
		    		
		    		for(int i=1;i<=add;i++) {
		    			
		    			System.out.println("Enter the book name you want to add:");
			    		String extraBook=input.next();
			    		arrayListE.add(++countAddE+"-"+extraBook);
			    		countE++;
			    		

		    		}
		    		
		    		
		    		String[] str = arrayListE.toString().split(",");
		    		
		    		for(int j=0; j<str.length; j+=1)
		    		{
						System.out.println(str[j]);

		    		}
//		    		System.out.println(arrayListE);
	        		System.out.println("---------------------------");
		    		System.out.println("Total ENGLISH books before adding new books:"+englishBooks);
	        		System.out.println("---------------------------");
		    		System.out.println("Total ENGLISH books after adding new books:"+countE);		    		
		    		
		    	}
		    }
    		System.out.println("---------------------------");

		    Library lib=new Library();
			
			lib.setName(name);
			lib.setTotalBooksAdded(add);
			
		System.out.println("LIBRARIAN NAME:"+name+"\nTOTAL BOOKS ADDED:"+add);
//		System.out.println(lib.getName());
		
		input.close();
	}
}
	
	

	
