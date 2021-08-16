package com.andrew.problems.numbertoletters;

import java.util.Scanner;
import java.util.Stack;

public class NumberToLetters {
	private Scanner scanner = null;

	public NumberToLetters() {
		scanner = new Scanner(System.in);
	}

	public String getWord(int num) {
		switch (num) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		default:
			return "Zero";
		}
	}

	public void convert() {
		System.out.println("Enter a number:");
		int num = scanner.nextInt();

		Stack<String> words = new Stack<>();

		while (num > 0) {
			words.push(getWord(num % 10));
			num /= 10;
		}

		while (!words.isEmpty()) {
			System.out.print(words.pop() + " ");
		}
	}
}
