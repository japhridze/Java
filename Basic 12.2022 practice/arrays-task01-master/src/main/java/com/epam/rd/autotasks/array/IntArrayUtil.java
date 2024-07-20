package com.epam.rd.autotasks.array;

import java.util.Arrays;

public class IntArrayUtil {

	public static void swapEven(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right) {



			if (array[left] % 2 == 0 && array[right] % 2 == 0) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
			left++;
			right--;

			if (left < right && array[left] % 2 != 0) {
				left++;
			}

			if (left < right && array[right] % 2 != 0) {
				right--;
			}
		}
	}


}
