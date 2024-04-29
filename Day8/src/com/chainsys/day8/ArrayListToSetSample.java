package com.chainsys.day8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListToSetSample {

	public static void main(String[] args) {

//		Scanner input = new Scanner(System.in);
//		ArrayList list = new ArrayList<>();
//		System.out.println("Enter the limit:");
//		int limit = input.nextInt();
//
//		for (int i = 1; i <= limit; i++) {
//
//			System.out.println("Enter the Employee ID");
//			String names = input.next();
//			list.add(names);
//
//		}
//
//		System.out.println(list);
//		System.out.println("SizeOfArray - "+list.size());
////		list.remove(2);
//		list.remove("akas3554");
//		list.add(2, "nave3557");
//		list.set(1,"venk3558" );
//
//		System.out.println(list);
//		System.out.println("SizeOfArray - "+list.size());

		Queue<String> queue = new LinkedList<>();

		queue.offer("1ST");
		queue.offer("2ND");
		queue.offer("3RD");
		queue.offer("4TH");

		String removed = queue.poll();
		System.out.println("Removed : " + removed);

		String front = queue.peek();
		System.out.println("Front : " + front);

		System.out.println(queue);

		Set<String> set = new TreeSet<String>();

		set.add("akash");
		set.add("saravana");
		set.add("naveen");
		set.add("harish");


		System.out.println(set);

		Set<String> set1 = new HashSet<String>();

		set1.add("akash");
		set1.add("saravana");
		set1.add("naveen");
		set1.add("harish");


		System.out.println(set1);

	}

}
