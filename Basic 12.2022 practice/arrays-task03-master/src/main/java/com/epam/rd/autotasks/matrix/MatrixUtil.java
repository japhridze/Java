package com.epam.rd.autotasks.matrix;

import java.util.Arrays;

public class MatrixUtil {

	public static void transformMatrix(int[][] matrix) {

		if (matrix != null) {

			if (matrix.length > 0 && matrix[0].length > 0) {

				int rows = matrix.length;
				int columns = matrix[0].length;
				boolean square = true;

				if (rows != columns) {
					square = false;
				}

				for (int i = 0; i < rows; i++) {
					if (matrix[i].length != columns) {
						square = false;
					}
				}

				if (square) {

					for (int i = 0; i < matrix.length; i++) {
						for (int j = matrix[i].length - 1; j > i; j--) {
							matrix[i][j] = 1;
						}
						System.out.println("");
						for (int j = 0; j < i; j++) {
							matrix[i][j] = 0;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		{
			int[][] matrix = null;
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = {};
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { {} };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { {}, {} };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 3 }, { 4, 5, 6 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 3 }, { 4, 5 }, {} };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 3 }, { 4, 5 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 }, { 5, 7, 8, 5 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{

			int[][] matrix = { { 2, 3 }, { 4, 5 }, { 6, 7 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}
		{
			int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 } };
			transformMatrix(matrix);
			System.out.println(Arrays.deepToString(matrix));
		}

	}

}