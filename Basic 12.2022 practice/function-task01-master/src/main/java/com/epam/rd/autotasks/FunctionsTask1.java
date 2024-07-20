package com.epam.rd.autotasks;


class FunctionsTask1 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static boolean isSorted(int[] array, SortOrder order) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        boolean sorted = true;
        for (int i = 1; i < array.length; i++) {
            if ((order == SortOrder.ASC && array[i] < array[i - 1]) || (order == SortOrder.DESC && array[i] > array[i - 1])) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}