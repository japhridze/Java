package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {

    Sorting sorting = new Sorting();

    @Test
    public void testNullCase() {
        assertThrows(IllegalArgumentException.class, () -> sorting.sort(null));
    }

    @Test
    public void testEmptyCase() {
        int[] array = {};
        sorting.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testSingleElementArrayCase() {
        int[] array = {1};
        sorting.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testSortedArraysCase() {
        int[] array = {1, 2, 3, 4, 5};
        sorting.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testOtherCases() {

        int[] array1 = {5, 3, 8, 4, 2};
        sorting.sort(array1);
        assertArrayEquals(new int[]{2, 3, 4, 5, 8}, array1);


        int[] array2 = {3, 1, 2, 1, 3};
        sorting.sort(array2);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, array2);


        int[] array3 = {3, -1, 2, -3, 0};
        sorting.sort(array3);
        assertArrayEquals(new int[]{-3, -1, 0, 2, 3}, array3);


        int[] array4 = {2, 2, 2, 2, 2};
        sorting.sort(array4);
        assertArrayEquals(new int[]{2, 2, 2, 2, 2}, array4);
    }
}
