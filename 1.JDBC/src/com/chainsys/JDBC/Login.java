package com.chainsys.JDBC;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login implements LogInter {

	public void loginDetails(String name, String pass) throws IOException {

		File files = new File("C:\\Users\\akas3554\\Documents\\login");
		files.mkdir();

		File files1 = new File("C:\\Users\\akas3554\\Documents\\login\\details.txt");
		files1.createNewFile();

		FileWriter text = new FileWriter(files1, true);

		String word = name + " " + pass + "\n";
		text.write(word);
		text.flush();
		text.close();
	}

	public boolean readerDetails(String userName, String passWord) throws IOException {

		File files1 = new File("C:\\Users\\akas3554\\Documents\\login\\details.txt");

		FileReader reader = new FileReader(files1);
		Scanner input = new Scanner(reader);

		while (input.hasNextLine()) {

			String details = input.nextLine();
			String detailsArr[] = details.split(" ");
			if (detailsArr[0].equals(userName) && detailsArr[1].equals(passWord)) {

				System.out.println("LOGGED IN SUCCESFULLY");
				return true;

			}

		}

		return false;

	}

}

