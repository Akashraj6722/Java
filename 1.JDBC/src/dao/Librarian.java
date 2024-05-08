package dao;

import util.DataEnglish;
import util.DataTamil;
import util.bookRecords;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Library;

public class Librarian {

	public void librarian() throws ClassNotFoundException, SQLException {

		Scanner input = new Scanner(System.in);
		Library lib = new Library();
		String name = null;

		int tamilBooks = 467;
		int englishBooks = 550;
		int countT = tamilBooks;
		int countE = englishBooks;
		int add = 0;
		int update = 0;
		int delete = 0;

		String choice = " ";
		String bookName;
		int bookId;

		String regex = "[a-zA-Z]{1,10}";
		String regex1="[1-9]{1,2}";

		System.out.println("Enter  YOUR NAME:");
		name = input.next().toLowerCase();
		while (!name.matches(regex)) {
			System.err.println("Enter the VALID  NAME:");
			name = input.next().toLowerCase();
		}

		ArrayList<String> librarianNames = new ArrayList<>();
		librarianNames.add("akash" + "naveen" + "harish" + "rakesh" + "saravana");

		for (String copy : librarianNames) {
			while (!copy.contains(name)) {

				System.err.println("YOU DON'T HAVE ACCESS \nRE-ENTER THE CORRECT NAME");
				name = input.next().toLowerCase();
			}
			System.out.println("WELCOME " + name);

		}

		lib.setName(name);
		lib.setTotalBooksAdded(add);

		while (!choice.equals("6")) {

			System.out.println("What do you want to do?\n" + "1.To see the stocks\n" + "2.To add stocks\n"
					+ "3.To update  the existing book details \n" + "4.To delete the book\n"+"5.To see the Book register records\n"+"6.To Quit");

			choice = input.next();

			while (!choice.matches("1") && !choice.matches("2") && !choice.matches("3") && !choice.matches("4")
					&& !choice.matches("5") && !choice.matches("6")) {

				System.out.println("Enter 1 OR 2 OR 3 OR 4 OR 5 OR 6");
				choice = input.next();

			}

			if (choice.equals("1")) {
				System.out.println("TOTAL TAMIL BOOKS:" + tamilBooks + "\nTOTAL ENGLISH BOOKS:" + englishBooks);

			}

			if (choice.equals("2")) {

				
				
				System.out.println("Which type of book,You want to add stock for?\n" + "1.Tamil books" + "2.English books");
				String option1 = input.next();
				while(!option1.matches(regex1)) {
					System.out.println("Type 1 or 2");
					option1 = input.next();

				}

				if (option1.matches("1")) {
					
					DataTamil.read();
					System.out.println("How many books you want to add stock in?");
					add = input.nextInt();
					

					for (int i = 1; i <= add; i++) {

						System.out.println("Enter the book name you want to add:");
						String extraBook = input.next();
						lib.setBookId(0);
						lib.setBookName(extraBook);
						DataTamil.insert(lib);
						countT++;

					}

					System.out.println("---------------------------");
					System.out.println("Total TAMIL books before adding new books:" + tamilBooks);
					System.out.println("---------------------------");
					System.out.println("Total TAMIL books after adding new books:" + countT);

				}
				if (option1.matches("2")) {
					DataEnglish.read();

					System.out.println("How many books you want to add stock in?");
					add = input.nextInt();

					for (int i = 1; i <= add; i++) {

						System.out.println("Enter the book name you want to add:");
						String extraBook = input.next();
						lib.setBookId(0);
						lib.setBookName(extraBook);
						DataEnglish.insert(lib);
						countE++;

					}

					System.out.println("---------------------------");
					System.out.println("Total ENGLISH books before adding new books:" + englishBooks);
					System.out.println("---------------------------");
					System.out.println("Total ENGLISH books after adding new books:" + countE);

				}
				System.out.println("---------------------------");

				System.out.println("LIBRARIAN NAME:" + name + "\nTOTAL BOOKS ADDED:" + add);
			}
			

			if (choice.equals("3")) {

				System.out.println("Which type of book,You want to update the details?\n" + "1.Tamil books" + "2.English books");
				String option1 = input.next();
				while(!option1.matches(regex1)) {
					System.out.println("Type 1 or 2");
					option1 = input.next();

				}
				if (option1.matches("1")) {

                    DataTamil.read();
					System.out.println("How many books you want to update ?");
					add = input.nextInt();

					for (int i = 1; i <= add; i++) {

						System.out.println("Enter the bookname:");
						input.nextLine();
						bookName = input.nextLine();

						System.out.println("Enter the bookID:");
						bookId = input.nextInt();

						lib.setBookName(bookName);
						lib.setBookId(bookId);

						DataTamil.update(lib);
						update++;

					}
				}

				if (option1.matches("2")) {

                   DataEnglish.read();
                   System.out.println("How many books you want to update ?");
					add = input.nextInt();

					for (int i = 1; i <= add; i++) {
						System.out.println("Enter the bookname:");
						input.nextLine();
						bookName = input.nextLine();

						System.out.println("Enter the bookID:");
						bookId = input.nextInt();

						lib.setBookName(bookName);
						lib.setBookId(bookId);

						DataEnglish.update(lib);

						update++;

					}

				}

				System.out.println("LIBRARIAN NAME:" + name + "\nNUMBER OF BOOKS UPDATED:" + update);
			}

			if (choice.equals("4")) {
				System.out.println("Which type of book,You want to delete?\n" + "1.Tamil books" + "2.English books");
				String option1 = input.next();
				while(!option1.matches(regex1)) {
					System.out.println("Type 1 or 2");
					option1 = input.next();
				}
				if (option1.matches("1")) {

                    DataTamil.read();
					System.out.println("How many books you want to delete ?");
					add = input.nextInt();

					for (int i = 1; i <= add; i++) {

						System.out.println("Enter the bookID:");
						bookId = input.nextInt();

						lib.setBookId(bookId);

						DataTamil.delete(lib);
						delete++;

					}
				}

				if (option1.matches("2")) {

                   DataEnglish.read();
                   System.out.println("How many books you want to delete ?");
					add = input.nextInt();

					for (int i = 1; i <= add; i++) {

						System.out.println("Enter the bookID:");
						bookId = input.nextInt();

						lib.setBookId(bookId);

						DataEnglish.delete(lib);
						delete++;

					}

				}

				System.out.println("LIBRARIAN NAME:" + name + "\nNUMBER OF BOOKS DELETED:" + delete);
			}
			
			if(choice.equals("5")) {
				
				bookRecords.read();
			}
			if (choice.equals("6")) {

				System.out.println("You're exited");
				break;
			}
		}

		input.close();
	}

}
