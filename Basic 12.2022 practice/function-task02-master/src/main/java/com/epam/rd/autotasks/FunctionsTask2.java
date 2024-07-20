package com.epam.rd.autotasks;

public class FunctionsTask2 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static boolean isSorted(int[] array, SortOrder order) {
        if (array == null || order == null || array.length == 0) {
            throw new IllegalArgumentException("Array or SortOrder can't be null or empty.");
        }
        if (order == SortOrder.ASC) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static int[] transform(int[] array, SortOrder order) {
        if (array == null || order == null || array.length == 0) {
            throw new IllegalArgumentException("Array or SortOrder cannot be null or empty.");
        }
        if (!isSorted(array, order)) {
            return array;
        }

        int[] transformedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = array[i] + i;
        }
        return transformedArray;
    }
}