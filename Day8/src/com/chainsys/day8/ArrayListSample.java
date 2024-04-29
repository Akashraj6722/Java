package com.chainsys.day8;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSample {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ArrayList list = new ArrayList<>();
		System.out.println("Enter the limit:");
		int limit = input.nextInt();

		for (int i = 1; i <= limit; i++) {

			System.out.println("Enter the Employee ID");
			String names = input.next();
			list.add(names);

		}

		System.out.println(list);
		System.out.println("SizeOfArray - "+list.size());
		list.remove(2);
		list.remove("akas3554");
		list.add(2, "nave3557");

		System.out.println(list);
		System.out.println("SizeOfArray - "+list.size());
	}

}
