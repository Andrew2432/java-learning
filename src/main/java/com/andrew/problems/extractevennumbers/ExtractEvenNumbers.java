package com.andrew.problems.extractevennumbers;

import java.util.Scanner;

public class ExtractEvenNumbers {
	private Scanner scanner = null;
	private int[] numbers = null;
	private int size = 0;

	public ExtractEvenNumbers(int size) {
		scanner = new Scanner(System.in);
		this.size = size;
		numbers = new int[size];
	}

	public void getNumbers() {
		System.out.println("Enter the numbers: ");

		for (int i = 0; i < size; i++) {
			numbers[i] = scanner.nextInt();
		}
	}

	public void showEvenNumbers() {
		for (int i = 0; i < size; i++) {
			if (numbers[i] % 2 == 0)
				System.out.print(numbers[i] + " ");
		}
	}

	public void start() {
		getNumbers();
		showEvenNumbers();
	}
}
