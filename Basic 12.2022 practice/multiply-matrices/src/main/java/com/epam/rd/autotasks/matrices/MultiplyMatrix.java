package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] A, int[][] B) {
        int rows = A.length;
        int columnA = A[0].length;
        int columnB = B[0].length;


        if (columnA != B.length){
            return null;
        }

        int[][] result = new int[rows][columnB];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columnB; j++) {
                for (int k = 0; k < columnA; k++) {
                    result[i][j] +=A[i][k] * B[k][j];
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] A = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] B = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(A, B);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
