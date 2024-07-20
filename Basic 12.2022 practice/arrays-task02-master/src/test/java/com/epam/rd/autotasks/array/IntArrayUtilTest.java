package com.epam.rd.autotasks.array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceCamelCase.class)
class IntArrayUtilTest {

	@Test
	void theDistanceBetweenTheFirstAndTheLastEntryOfTheMaximumValueIsCalculated() {
		{
			int[] array = null;
			int expected = 0;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] {};
			int expected = 0;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] { 4, 100, 3, 4 };
			int expected = 0;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] { 5, 50, 50, 4, 5 };
			int expected = 1;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] { 5, 350, 350, 4, 350 };
			int expected = 3;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] { 10, 10, 10, 10, 10 };
			int expected = 4;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] { 0, -1, -1, 0 };
			int expected = 3;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] { 0, 0 };
			int expected = 1;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
		}
		{
			int[] array = new int[] { 0 };
			int expected = 0;
			int actual = IntArrayUtil.maximumDistance(array);
			assertEquals(expected, actual);
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
