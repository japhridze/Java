package com.epam.rd.qa.basicio;

import java.util.Arrays;


class MatrixException extends RuntimeException{
    public MatrixException(String message) {
        super(message);
    }
}
public class Matrix {

    double[][] matrix;


    public Matrix(int rows, int cols){
        try {
            if (rows < 1 || cols < 1) {
                throw new MatrixException("row or column shouldn't be less than 1");
            }
            matrix = new double[rows][cols];
        } catch(MatrixException e) {
            System.err.println("Error creating matrix: " + e.getMessage());
            throw e;
        }
    }

    public Matrix(double[][] values) {
        try{
            if (values.length == 0 || values[0].length == 0) {
                throw new MatrixException(" rows and columns should have at least 1 row and 1 column");
            }
            int cols = values[0].length;
            int rows = values.length;
            for (int i = 0; i < rows; i++) {
                if (values[i].length != cols) {
                    throw new MatrixException("column length should be consistent");
                }
            }
            matrix = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = values[i][j];
                }
            }
        } catch (MatrixException e) {
            System.err.println("Error creating matrix: " + e.getMessage());
            throw e;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix other = (Matrix) o;
        return Arrays.deepEquals(matrix, other.matrix);
    }
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }


    public int getRows() {
        return matrix.length;
    }


    public int getColumns() {
        if (matrix.length > 0) {
            return matrix[0].length;
        } else {
            return 0;
        }
    }


    public double get(int row, int col) {
        try {
            if (row < 0 || row >= getRows() || col < 0 || col >= getColumns()) {
                throw new MatrixException("index out of bounds exception");
            }
            return matrix[row][col];
        } catch (MatrixException e) {
            // Handle the exception here
            System.err.println("Matrix get operation error: " + e.getMessage());
            throw e;
        }
    }


    public void set(int row, int col, double value) {
        try {
            if (row < 0 || row >= getRows() || col < 0 || col >= getColumns()) {
                throw new MatrixException("Index out of bounds");
            }
            matrix[row][col] = value;
        } catch (MatrixException e) {
            System.out.println("Matrix set operation error: " + e.getMessage());
            throw e;
        }
    }


    public double[][] toArray() {
        try {
            int numRows = getRows();
            int numCols = getColumns();
            double[][] result = new double[numRows][numCols];

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    result[i][j] = matrix[i][j];
                }
            }
            return result;
        } catch (Exception e) {
            System.err.println("Error converting matrix to array: " + e.getMessage());
            return new double[0][0];
        }
    }


    public Matrix add(Matrix other) {
        try {
            int numRowsThis = getRows();
            int numColsThis = getColumns();
            int numRowsOther = other.getRows();
            int numColsOther = other.getColumns();

            if (numRowsThis != numRowsOther || numColsThis != numColsOther) {
                throw new MatrixException("Matrices have different sizes");
            }

            double[][] result = new double[numRowsThis][numColsThis];

            for (int i = 0; i < numRowsThis; i++) {
                for (int j = 0; j < numColsThis; j++) {
                    result[i][j] = matrix[i][j] + other.matrix[i][j];
                }
            }

            return new Matrix(result);
        } catch (MatrixException e) {
            System.err.println("Matrix addition error: " + e.getMessage());
            //return null; // or handle it differently
            throw e;
        }
    }

    public Matrix subtract(Matrix other) {
        try {
            int numRowsThis = getRows();
            int numColsThis = getColumns();
            int numRowsOther = other.getRows();
            int numColsOther = other.getColumns();

            if (numRowsThis != numRowsOther || numColsThis != numColsOther){
                throw new MatrixException("Matrices have different sizes");
            }

            double[][] result = new double[numRowsThis][numColsThis];

            for (int i = 0; i < numRowsThis; i++) {
                for (int j = 0; j < numColsThis; j++) {
                    result[i][j] = matrix[i][j] - other.matrix[i][j];
                }
            }
            return new Matrix(result);
        } catch (MatrixException e) {
            System.out.println("matrix substraction error:" + e.getMessage());
            throw e;
        }
    }

    public Matrix multiply(Matrix other) {
        try {
            int numRowsThis = getRows();
            int numColsThis = getColumns();
            int numRowsOther = other.getRows();
            int numColsOther = other.getColumns();

            if (numColsThis != numRowsOther) {
                throw new MatrixException("Matrices have non-compliant sizes for multiplication");
            }

            double[][] result = new double[numRowsThis][numColsOther];

            for (int i = 0; i < numRowsThis; i++) {
                for (int j = 0; j < numColsOther; j++) {
                    for (int k = 0; k < numColsThis; k++) {
                        result[i][j] += matrix[i][k] * other.matrix[k][j];
                    }
                }
            }

            return new Matrix(result);
        } catch (MatrixException e) {
            System.err.println("Matrix multiplication error: " + e.getMessage());
            throw e;
        }
    }
}