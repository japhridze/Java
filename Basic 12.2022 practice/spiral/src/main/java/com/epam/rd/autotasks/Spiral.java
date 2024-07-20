package com.epam.rd.autotasks;


public class Spiral {
    public static int[][] spiral(int rows, int columns) {
        int[][] result = new int[rows][columns];
        int currentNumber = 1;
        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;

        while (currentNumber <= rows * columns) {
            // Fill top row
            for (int i = left; i <= right && currentNumber <= rows * columns; i++) {
                result[top][i] = currentNumber++;
            }
            top++;

            for (int i = top; i <= bottom && currentNumber <= rows * columns; i++) {
                result[i][right] = currentNumber++;
            }
            right--;


            for (int i = right; i >= left && currentNumber <= rows * columns; i--) {
                result[bottom][i] = currentNumber++;
            }
            bottom--;

            for (int i = bottom; i >= top && currentNumber <= rows * columns; i--) {
                result[i][left] = currentNumber++;
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] spiral = Spiral.spiral(3, 4);
        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral[i].length; j++) {
                System.out.print(String.format("%4s", spiral[i][j]));
            }
            System.out.println();
        }
    }
}
