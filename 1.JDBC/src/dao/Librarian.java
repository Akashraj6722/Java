package dao;
import util.DataEnglish;
import util.DataTamil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Library;


public class Librarian {
	
	public void librarian() throws ClassNotFoundException, SQLException {
		
		Scanner input=new Scanner(System.in);
		Library lib = new Library();
		String name = null;
		ArrayList<String> arrayListE = new ArrayList<>();
		arrayListE.add("1-Sherlock holmes\n"+ " 2-Half girlfriend\n"+ " 3-Treasure island\n"+ " 4-Rebel Nation\n"+" 5-Rich dad Poor dad\n"+" 6-Beyond the ordinary\n"+" 7-Harry potter\n"+" 8-Alice the wonderland\n"+" 9-The Great Gatsby\n"+" 10-The Lord of the Rings");
        
		ArrayList<String> arrayListT=new ArrayList<>();
		arrayListT.add("1-Seevaka chinthamani\n"+ " 2-Silappathikaram\n"+ " 3-Manimekalai\n"+ " 4-Kundalakesi\n"+" 5-Valayapathi\n"+" 6-Ramayanam\n"+" 7-Kambaramayanam\n"+" 8-Ponniyin selvan\n"+" 9-Karuvaachi kaaviyam\n"+" 10-Thanneer desam");

		int tamilBooks=467;
		int englishBooks=550;
		int countT=tamilBooks;
		int countE=englishBooks;
		int countAddT=10;
		int countAddE=10;
		int add = 0;
    	int update = 0;
    	int delete=0;

//		int totalBooksAdded;
		String choice;
		String bookName;
		int bkId;

		
		String regex="[a-zA-Z]{1,10}";
		String regex1="[1234]{1}";
		
//		DataTamil dT=new DataTamil();
//		DataEnglish dE=new DataEnglish();
				
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
		
		lib.setName(name);
		lib.setTotalBooksAdded(add);
		
			System.out.println("What do you want to do?\n"+"1.To see the stocks\n"+"2.To add stocks\n"+"3.To update  the existing book details \n"+"4.To delete the book");
		     
		     choice=input.next();
		    
		    while(!choice.matches(regex1)) {
				System.out.println("Type 1 or 2 or 3 or 4");
				choice=input.next();
			}
	    while(!choice.matches("1") && !choice.matches("2") && !choice.matches("3") && !choice.matches("4") ) {
	    	
	    	System.out.println("Enter 1 OR 2 OR 3 OR 4");
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
			    		lib.setBkId(countAddT);
			    		lib.setBookName(extraBook);
			    		DataTamil.insert(lib);
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
			    		lib.setBkId(countAddE);
			    		lib.setBookName(extraBook);
			    		DataEnglish.insert(lib);
			    		countE++;
	    		
		    		}
		    				    		
		    		String[] str = arrayListE.toString().split(",");
		    		
		    		for(int j=0; j<str.length; j+=1)
		    		{
						System.out.println(str[j]);

		    		}
	        		System.out.println("---------------------------");
		    		System.out.println("Total ENGLISH books before adding new books:"+englishBooks);
	        		System.out.println("---------------------------");
		    		System.out.println("Total ENGLISH books after adding new books:"+countE);		    		
		    		
		    	}
		    	System.out.println("---------------------------");

				System.out.println("LIBRARIAN NAME:"+name+"\nTOTAL BOOKS ADDED:"+add);
		    }
    		
//		System.out.println(lib.getName());
		
		 if(choice.equals("3")) {
		    	
		    	System.out.println("Which type of book,You want to update the details?\n"+"1.Tamil books"+"2.English books");
		    	int option1=input.nextInt();
		    	
		    	
		    	if(option1==1) {
		    		
		    		System.out.println(arrayListT);

		    		System.out.println("How many books you want to update ?");
		    		 add=input.nextInt();
		    		 
		    		 for(int i=1;i<=add;i++) {
		    		
		    		
		    		System.out.println("Enter the bookname:");
		    		input.nextLine();
		    		bookName=input.nextLine();
		    		
		    		System.out.println("Enter the bookID:");
		    		bkId = input.nextInt();

		    		lib.setBookName(bookName);
		    		lib.setBkId(bkId);

		    		DataTamil.update(lib);
					update++;

		    		
		    		
		    	}
		    	}
		    	
		    	if(option1==2) {
		    		
		    		System.out.println(arrayListE);
		    		System.out.println("How many books you want to update ?");
		    		 add=input.nextInt();
		    		
		    		 for(int i=1;i<=add;i++) {
		    		System.out.println("Enter the bookname:");
		    		input.nextLine();
		    		bookName=input.nextLine();
		    		
		    		System.out.println("Enter the bookID:");
		    		bkId=input.nextInt();
		    		
		    		lib.setBookName(bookName);
		    		lib.setBkId(bkId);

		    	DataEnglish.update(lib);
		    	
				update++;
		    		
		    		
		    		 }
		    		
		    		
		    	}
		    	
				System.out.println("LIBRARIAN NAME:\n"+name+"NUMBER OF BOOKS UPDATED:"+ update);
		 }
		 
		 
		 if(choice.equals("4")) {
			 System.out.println("Which type of book,You want to delete?\n"+"1.Tamil books"+"2.English books");
		    	int option1=input.nextInt();
		    	
		    	
		    	if(option1==1) {
		    		
		    		System.out.println(arrayListT);

		    		System.out.println("How many books you want to delete ?");
		    		 add=input.nextInt();
		    		 
		    		 for(int i=1;i<=add;i++) {
		    		
		    		
		    		System.out.println("Enter the bookID:");
		    		bkId = input.nextInt();

		    		lib.setBkId(bkId);

		    		DataTamil.delete(lib);
			    	delete++;

		    		
		    	}
		    	}
		    	
		    	if(option1==2) {
		    		
		    		System.out.println(arrayListE);
		    		System.out.println("How many books you want to delete ?");
		    		 add=input.nextInt();
		    		
		    		 for(int i=1;i<=add;i++) {
		    		
		    		System.out.println("Enter the bookID:");
		    		bkId=input.nextInt();
		    		
		    		lib.setBkId(bkId);

		    	DataEnglish.delete(lib);
		    	delete++;
		    	
		    		
		    		
		    		 }
		    		
		    		
		    	}
		    	
		    	System.out.println("LIBRARIAN NAME:\n"+name+"NUMBER OF BOOKS DELETED:"+ delete);
		 }

		
		input.close();
	}
}

	
	

	
