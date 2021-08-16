package com.andrew.problems.matrices.lowertriangle;

import java.util.Scanner;

public class MatrixLowerTriangle {
	private Scanner scanner = null;
	private int[][] matrix = null;
	private int dimension = 0;

	public MatrixLowerTriangle(int dim) {
		scanner = new Scanner(System.in);
		matrix = new int[dim][dim];
		dimension = dim;

	}

	public void getMatrix() {
		System.out.println("Enter the matrix: ");

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.printf("Enter [%d][%d]:", i, j);
				matrix[i][j] = scanner.nextInt();
			}
		}
	}

	public void showLowerTriangle() {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				if (j <= i)
					System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void start() {
		getMatrix();
		showLowerTriangle();
	}
}
