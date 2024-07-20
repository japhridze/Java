package com.epam.rd.autotasks.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import com.epam.rd.autotasks.matrix.MatrixUtil;

@DisplayNameGeneration(ReplaceCamelCase.class)
class MatrixUtilTest {

	@Test
	void theMatrixIsNotChanged() {
		{
			int[][] expected = null;
			int[][] actual = null;
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[][] expected = {};
			int[][] actual = {};
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[][] expected = { {} };
			int[][] actual = { {} };
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[][] expected = { {}, {} };
			int[][] actual = { {}, {} };
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[][] expected = { { 2, 3 }, { 4, 5, 6 } };
			int[][] actual = { { 2, 3 }, { 4, 5, 6 } };
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[][] expected = { { 2, 3 }, { 4, 5 }, {} };
			int[][] actual = { { 2, 3 }, { 4, 5 }, {} };
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[][] expected = { { 2, 3 }, { 4, 5 }, { 6, 7 } };
			int[][] actual = { { 2, 3 }, { 4, 5 }, { 6, 7 } };
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
		{
			int[][] expected = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 } };
			int[][] actual = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 } };
			MatrixUtil.transformMatrix(actual);
			assertArrayEquals(expected, actual);
		}
	}

	@Test
	void zeroIsWrittenToTheLeftOfTheMainDiagonal() {
		{
			int[][] expected = new int[2][];
			int[][] matrix = { { 2, 3 }, { 4, 5 } };
			MatrixUtil.transformMatrix(matrix);
			for (int i = 0; i < matrix.length; i++) {
				expected[i] = new int[i];
				Arrays.fill(expected[i], 0, i, 0);
				int[] actual = Arrays.copyOfRange(matrix[i], 0, i);
				assertArrayEquals(expected[i], actual);
			}
		}
		{
			int[][] expected = new int[4][];
			int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 }, { 5, 7, 8, 5 } };
			MatrixUtil.transformMatrix(matrix);
			for (int i = 0; i < matrix.length; i++) {
				expected[i] = new int[i];
				Arrays.fill(expected[i], 0, i, 0);
				int[] actual = Arrays.copyOfRange(matrix[i], 0, i);
				assertArrayEquals(expected[i], actual);
			}
		}
	}

	@Test
	void oneIsWrittenToTheRightOfTheMainDiagonal() {
		{
			int[][] expected = new int[2][];
			int[][] matrix = { { 2, 3 }, { 4, 5 } };
			MatrixUtil.transformMatrix(matrix);
			for (int i = 0; i < matrix.length; i++) {
				expected[i] = new int[matrix[i].length - 1 - i];
				Arrays.fill(expected[i], 0, matrix[i].length - 1 - i, 1);
				int[] actual = Arrays.copyOfRange(matrix[i], i + 1, matrix[i].length);
				assertArrayEquals(expected[i], actual);
			}
		}
		{
			int[][] expected = new int[4][];
			int[][] matrix = { { 2, 4, 3, 3 }, { 5, 7, 8, 5 }, { 2, 4, 3, 3 }, { 5, 7, 8, 5 } };
			MatrixUtil.transformMatrix(matrix);
			for (int i = 0; i < matrix.length; i++) {
				expected[i] = new int[matrix[i].length - 1 - i];
				Arrays.fill(expected[i], 0, matrix[i].length - 1 - i, 1);
				int[] actual = Arrays.copyOfRange(matrix[i], i + 1, matrix[i].length);
				assertArrayEquals(expected[i], actual);
			}
		}
	}
}

class ReplaceCamelCase extends DisplayNameGenerator.Standard {
	@Override
	public String generateDisplayNameForClass(Class<?> testClass) {
		return replaceCamelCase(super.generateDisplayNameForClass(testClass));
	}

	@Override
	public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
		return replaceCamelCase(super.generateDisplayNameForNestedClass(nestedClass));
	}

	@Override
	public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
		return this.replaceCamelCase(testMethod.getName());
	}

	String replaceCamelCase(String camelCase) {
		StringBuilder result = new StringBuilder();
		result.append(Character.toUpperCase(camelCase.charAt(0)));
		for (int i = 1, len = camelCase.length(); i < len; i++) {
			if (Character.isUpperCase(camelCase.charAt(i))) {
				result.append(' ');
				result.append(Character.toLowerCase(camelCase.charAt(i)));
			} else {
				result.append(camelCase.charAt(i));
			}
		}
		return result.toString();
	}
}
