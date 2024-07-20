package com.epam.rd.autotasks.matrices;
import java.util.Arrays;
public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int colums =matrix[0].length;
        int[][] transposeMatrix = new int[colums][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {

                transposeMatrix[j][i]=matrix[i][j];
            }

        }
        return transposeMatrix;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        int[][] result  = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));

    }
}
